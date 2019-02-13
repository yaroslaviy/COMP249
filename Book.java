// -----------------------------------------------------
// Assignment 1
// Question: PART I
// Written by: Yaroslav Bilodid ID#40068605
// -----------------------------------------------------

/**
 * Name and ID Yaroslav Bilodid ID 40068605 <br>
 * COMP249 <br>
 * Assignment # 1 <br>
 * Due Date 01.02.2019 <br>
 *  
 * The Book class implements methods to operate with the bookstore in the main method
 * @author Yaroslav
 *
 */
public class Book {
	private String title;
	private String author;
	private long ISBN;
	private double price;
	static private int count = 0;

	/**
	 * The basic constructor with no parameters to create an empty object
	 */
	public Book() {
		title = null;
		author = null;
		ISBN = 0;
		price = 0;
		count++;
	}
	/**
	 *  Constructor to create an object with given parameters
	 * @param name Book's title
	 * @param autname Book's author
	 * @param num Book's ISBN
	 * @param cost Book's price
	 */
	public Book(String name, String autname, long num, double cost) {
		title = name;
		author = autname;
		ISBN = num;
		price = cost;
		count++;
	}

	/**
	 * Title accessor
	 * @return title of the Book
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 *  Author accessor
	 * @return name of the author of the Book
	 */
	public String getAuthor() {
		return this.author;
	}
	
	/**
	 * ISBN accessor
	 * @return ISBN number of the Book
	 */
	public long getISBN() {
		return this.ISBN;
	}
	
	/**
	 * Price accessor
	 * @return Price of the Book
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Title mutator
	 * @param name is title of the Book
	 */
	public void setTitle(String name) {
		this.title = name;
	}
	/**
	 * Author mutator
	 * @param name is author of the Book
	 */
	public void setAuthor(String name) {
		this.author = name;
	}
	/**
	 * ISBN mutator
	 * @param num is ISBN of the Book
	 */
	public void setISBN(long num) {
		this.ISBN = num;
	}
	/**
	 * Price mutator 
	 * @param cost is price of the Book
	 */
	public void setPrice(double cost) {
		this.price = cost;
	}

	/**
	 *  toString method to display all the information about given Book object
	 */
	public String toString() {
		return "The book with the name " + this.title + " and was written by " + this.author + " has an ISBN number of "
				+ this.ISBN + " and its price is " + this.price;
	}
	
	/**
	 * method to return how many objects of Book were created 
	 * @return total Books created
	 */
	public static int findNumberOfCreatedBooks() {
		return count;
	}
	
	/**
	 * equals  method to compare two objects of Book.
	 * @param b1 is Book object to be compared
	 * @return truw if Books are the same , false otherwise
	 */
	public boolean equals(Book b1) {
		return this.author.equals(b1.author) && this.title.equals(b1.title) && this.price == b1.price
				&& this.ISBN == b1.ISBN;
	}
	
	/**
	 * This method displays books with specific author.
	 * @param author is a name of the author given by user
	 * @param invent is an array of created Books
	 */
	public static void findByAuthor(String author, Book[] invent) {
		int c = 0;
		for (int i= 0; i < count; i++) {
			if (invent[i].author.equalsIgnoreCase(author)) {
				System.out.println(invent[i].toString() + '\n');
				c++;
			}
		
		}
		System.out.println(c + " books were found.");
	}
	
	/**
	 * This method displays books with prices lower than given
	 * @param limit is a price limit given by user
	 * @param invent is an array of created Books
	 */
	public static void findCheaperThan(double limit, Book[] invent) {
		int c = 0;
		for (int i= 0; i < count; i++) {
			if (invent[i].price < limit) {
				System.out.println(invent[i].toString() + '\n');
				c++;
			}
		
		}
		System.out.println(c + " books were found.");
	}
}
