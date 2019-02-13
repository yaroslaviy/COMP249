
// -----------------------------------------------------
// Assignment 1
// Question: PART II
// Written by: Yaroslav Bilodid ID#40068605
// -----------------------------------------------------


import java.util.Scanner;
/**
 * Name and ID Yaroslav Bilodid ID 40068605 <br>
 * COMP249 <br>
 * Assignment # 1 <br>
 * Due Date 01.02.2019 <br>
 * 
 * The driver class for the Book class. 
 */
public class driver {
	/**
	 * Main method for Book class. <br>
	 * Contains code for managing the bookstore. Functions implemented: <br>
	 * - adding objects into inventory <br>
	 * - changing objects <br>
	 * - finding objects with specific criteria such as price and author <br>
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int option;
		int maxBooks = 0;
		int fail = 0;
		int fail2 = 0;
		int total = 0;
		int enterBooks;
		int change;
		int changeOption = 0;
		int changeOption1 = 0;
		String input;
		final String password = "password";

		// Welcome message
		System.out.println("**********************************************");
		System.out.println("      Welcome to our bookstore manager!");
		System.out.println("          Made by Yaroslav Bilodid");
		System.out.println("**********************************************" + '\n');

		// getting max amount of books in a bookstore
		do {
			System.out.println("What is the maximum number of books your bookstore can contain?");
			maxBooks = kb.nextInt();
			if (maxBooks < 1)
				System.out.println("Please enter valid number");
		} while (maxBooks < 1);

		// creating book array
		Book[] inventory = new Book[maxBooks];

		do {

			// main menu
			System.out.println("What do you want to do?");
			System.out.println('\t' + "1. Enter new books (password required)");
			System.out.println('\t' + "2. Change information of a book (password required)");
			System.out.println('\t' + "3. Display all books by specific author");
			System.out.println('\t' + "4. Display all books under a certain price");
			System.out.println('\t' + "5. Quit");

			// making sure the choice is valid
			do {
				System.out.println("Please enter your choice >");
				option = kb.nextInt();
				if (option < 1 && option > 5)
					System.out.println("Your input is not valid");
			} while (option < 1 && option > 5);

			// option 1
			if (option == 1) {

				// checking password
				do {
					System.out.println("Please enter the password:");

					input = kb.next();
					if (!input.equals(password)) {
						fail++;
						System.out.println("Wrong password");
					} else {

						// password is right
						do {
							System.out.println(
									"How many books do you want to enter? (Make sure they fit in your bookstore!)");
							enterBooks = kb.nextInt();
							if (maxBooks - Book.findNumberOfCreatedBooks() < enterBooks)
								System.out.println("This number won't fit, try again with the smaller one.");
						} while (maxBooks - Book.findNumberOfCreatedBooks() < enterBooks);

						// adding books

						int alreadyin = Book.findNumberOfCreatedBooks();
						for (int i = 0; i < enterBooks; i++) {

							System.out.println("Please enter name of the book:");
							kb.nextLine();
							String name = kb.nextLine();
							System.out.println("Please enter author of the book:");
							String author = kb.nextLine();
							System.out.println("Please enter ISBN of the book");
							long Isbn = kb.nextLong();
							System.out.println("Please enter price of the book");
							double price = kb.nextDouble();
							inventory[i + alreadyin] = new Book(name, author, Isbn, price);
							System.out.println("Successfully added to your bookstore!");
						}
					}

					if (fail % 3 == 0 && !input.equals(password))
						total++;

					// all attempts were used, exit program
					if (total == 4) {
						System.out.println("Program detected suspicous activities and will terminate immediately!");
						System.exit(0);
					}

					// 3 attempts were used, back to main menu
				} while (fail % 3 != 0 && !input.equals(password));
			}

			// option 2

			if (option == 2) {

				// ask for password

				do {
					System.out.println("Please enter the password:");

					input = kb.next();
					if (!input.equals(password)) {
						fail2++;
						System.out.println("Wrong password");
					} else {
						do {

							// ask what book to change

							do {
								System.out.println(
										"What book you would like to change?(Please enter number of the book in your inventory)");
								change = kb.nextInt();
							} while (change >= maxBooks);

							// if index provided is not valid

							if (inventory[change] == null) {
								System.out.println("There is no book with this index. Please select an option:");
								System.out.println('\t' + "1. Re-enter new index.");
								System.out.println('\t' + "2. Quit");
								System.out.println('\t' + "3. Back to main menu");
								changeOption = kb.nextInt();

								if (changeOption == 2) {
									System.out.println("Thanks for using our bookstore manager!");
									System.exit(0);
								} else if (changeOption == 3) {
									break;
								}

							} else {

								// displaying info about chosen book

								System.out.println('\t' + "Book #: " + change);
								System.out.println('\t' + "Author: " + inventory[change].getAuthor());
								System.out.println('\t' + "Title: " + inventory[change].getTitle());
								System.out.println('\t' + "ISBN: " + inventory[change].getISBN());
								System.out.println('\t' + "Price: $" + inventory[change].getPrice());

								// asking what to change

								do {
									System.out.println("What do you want to change?");
									System.out.println('\t' + "1. author");
									System.out.println('\t' + "2. title");
									System.out.println('\t' + "3. ISBN");
									System.out.println('\t' + "4. price");
									System.out.println('\t' + "5. Quit");

									// making sure the choice is valid
									do {
										System.out.println("Please enter your choice >");
										changeOption1 = kb.nextInt();
										if (changeOption1 < 1 && changeOption1 > 5)
											System.out.println("Your input is not valid");
									} while (changeOption1 < 1 && changeOption1 > 5);

									// changing info depending on option chosen

									if (changeOption1 == 1) {
										System.out.println("Please enter new author:");
										kb.nextLine();
										String newData = kb.nextLine();
										inventory[change].setAuthor(newData);
									} else if (changeOption1 == 2) {
										System.out.println("Please enter new title:");
										kb.nextLine();
										String newData = kb.nextLine();
										inventory[change].setTitle(newData);
									} else if (changeOption1 == 3) {
										System.out.println("Please enter new ISBN:");
										long newData = kb.nextLong();
										inventory[change].setISBN(newData);
									} else if (changeOption1 == 4) {
										System.out.println("Please enter new price:");
										double newData = kb.nextDouble();
										inventory[change].setPrice(newData);
									}

								} while (changeOption1 != 5);
							}
						} while (changeOption == 1 && changeOption1 != 5);
					}

					// 3 attempts were used, back to main menu
				} while (fail2 % 3 != 0 && !input.equals(password));
			}

			if (option == 3) {
				System.out.print("Please enter the name of the author you're looking for: ");
				String lookfor = kb.next();
				Book.findByAuthor(lookfor, inventory);
			}

			if (option == 4) {
				System.out.print("Please enter the price limit: ");
				double limit =kb.nextDouble();
				Book.findCheaperThan(limit, inventory);
			}
			
		} while (option != 5);
		System.out.println("*******************************************************");
		System.out.println("Thanks for using our bookstore manager! See you later!");
		System.out.println("*******************************************************");
		System.exit(0);

	}

}
