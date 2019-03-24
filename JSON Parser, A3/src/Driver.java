// -----------------------------------------------------
// Assignment 3
// Written by: Yaroslav Bilodid ID#40068605
// -----------------------------------------------------



import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * The Class Driver.
 * Yaroslav Bilodid ID#40068605
 * COMP249
 * Assignment # 3
 * Due Date 21-03-2019
 */
public class Driver {
	
	/**
	 * The main method.
	 * Creates output files and writes generated output
	 * 
	 */
	public static void main(String[] args) {
		// create keyboard Scanner and ask for input
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to AuthorBibCreator! \n\nPlease enter the author name you are looking for:");
		String searchAuthor = kb.nextLine();

		// creating File scanner and PrintWriters
		Scanner read = null;
		File[] result = new File[3];
		PrintWriter[] pw = new PrintWriter[3];

		// making output files
		try {
			result[0] = new File(searchAuthor + "-IEEE.json");
			result[1] = new File(searchAuthor + "-ACM.json");
			result[2] = new File(searchAuthor + "-NJ.json");
			
			// defining PrintWriters
			for (int i = 0; i < 3; i++) {
				
				try {
					//check if file already exists
					if (result[i].exists() || result[i].isDirectory()) {
						throw new FileExistsException(
								"\nThere is already an existing file for that author with the name: "
										+ result[i].getName() + ". File will\r\n"
										+ "be renamed as BU, and older BU files will be deleted!");
					} else {
						pw[i] = new PrintWriter(result[i]);
					}
				// changing file name if it exists already
				} catch (FileExistsException e) {
					String temp = result[i].getName();
					result[i] = new File(result[i].getName().substring(0, temp.length() - 5) + "-BU.json");
					pw[i] = new PrintWriter(result[i]);
					System.out.println(e.getMessage());
				}
			}

		} catch (IOException e) {
			System.out.println("File for result is not found!");
			for(int i = 0; i<3; i++) {
				pw[i].close();
				if(result[i].exists()) {
				result[i].delete();
				}
				System.exit(0);
			}
		}
		
		// start getting info
		int found = 0;
		ArrayList<Article> match = new ArrayList<Article>();
		String[] param = null;
		for (int i = 0; i < 10; i++) {
			read = createScanner(i, pw);

			while (read.hasNextLine()) {
				String next = read.nextLine();
				if (next.contains("@ARTICLE{")) {
					param = processBibFile(read, searchAuthor);
					if (param != null) {
						match.add(new Article(param));
						pw[0].println(match.get(found).generateIEEE() + '\n');
						pw[1].println(match.get(found).generateACM(found+1) + '\n');
						pw[2].println(match.get(found).generateNJ() + '\n');
						found++;
					}
				}
			}

		}

		read.close();
		kb.close();
		for (int i = 0; i < 3; i++) {
			pw[i].close();
		}

		if (found == 0) {
			for (int i = 0; i < 3; i++) {
				result[i].delete();
			}
			System.out.println("No files have been created!");
		} else {
			System.out.println("\n\nA total of " + found + " were found using name: " + searchAuthor);
			System.out.print("Files ");
			for (int i = 0; i < 3; i++) {
				if (i == 2)
					System.out.print(result[i].getName() + " ");
				else
					System.out.print(result[i].getName() + ", ");
			}
			System.out.println(" have been created!");
		}
		System.out.println("Good bye! Hope you enjoyed our AuthorBibCreator.");
	}

	/**
	 * Creates the Scanner.
	 *
	 * @param i the index of input File
	 * @param pw the Printwriter(to close in case if files are not found
	 * @return the Scanner with input file 
	 */
	public static Scanner createScanner(int i, PrintWriter[] pw) {
		Scanner read = null;
		try {
			read = new Scanner(new FileReader("Latex" + (i + 1) + ".bib"));
		} catch (FileNotFoundException e) {
			System.out.println("File " + "Latex" + (i + 1) + ".bib" + " is not found!");
			System.out.println(
					"Please check if this file exists. Program will terminate after closing any opened files.");
			for (int k = 0; k < 3; k++) {
				pw[k].close();
			}
			System.exit(0);
		}
		return read;
	}

	/**
	 * Process bib file.
	 *
	 * @param read the Scanner with input file
	 * @param authorName the author name to look for
	 * @return the information about the article found
	 */
	public static String[] processBibFile(Scanner read, String authorName) {
		String[] info = new String[11];

		boolean found = false;

		while (true) {

			String nextLine = read.nextLine();
			if (nextLine.contains("author={")) {
				if (nextLine.contains(authorName)) {
					found = true;
					info[0] = nextLine.replace("author={", "");
					info[0] = info[0].replaceAll("}, *", "");
				}
				continue;
			}
			if (found) {
				if (nextLine.contains("journal={")) {
					info[1] = nextLine.replace("journal={", "");
					info[1] = info[1].replaceAll("}, *", "");

				} else if (nextLine.contains("title={")) {
					info[2] = nextLine.replace("title={", "");
					info[2] = info[2].replaceAll("}, *", "");

				} else if (nextLine.contains("year={")) {
					info[3] = nextLine.replace("year={", "");
					info[3] = info[3].replaceAll("}, *", "");

				} else if (nextLine.contains("volume={")) {
					info[4] = nextLine.replace("volume={", "");
					info[4] = info[4].replaceAll("}, *", "");

				} else if (nextLine.contains("pages={")) {
					info[5] = nextLine.replace("pages={", "");
					info[5] = info[5].replaceAll("}, *", "");

				} else if (nextLine.contains("keywords={")) {
					info[6] = nextLine.replace("keywords={", "");
					info[6] = info[6].replaceAll("}, *", "");

				} else if (nextLine.contains("doi={")) {
					info[7] = nextLine.replace("doi={", "");
					info[7] = info[7].replaceAll("}, *", "");

				} else if (nextLine.contains("ISSN={")) {
					info[8] = nextLine.replace("ISSN={", "");
					info[8] = info[8].replaceAll("}, *", "");

				} else if (nextLine.contains("month={")) {
					info[9] = nextLine.replace("month={", "");
					info[9] = info[9].replaceAll("}, *", "");

				} else if (nextLine.contains("number={")) {
					info[10] = nextLine.replace("number={", "");
					info[10] = info[10].replaceAll("}, *", "");
				}
			}

			if (nextLine.matches("^}"))
				break;
		}
		if (found)
			return info;
		else
			return null;

	}
	

}
