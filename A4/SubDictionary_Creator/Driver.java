package question1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * The Class Driver.
 */
public class Driver {
	
	/**
	 * The main method.
	 * Takes a txt file with text from user and creates sub-dictionary of used words from the text.
	 * 
	 */
	public static void main(String[] args) {
		//prompt user to input file name
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the file name:");
		String file = kb.next();
		kb.close();
		
		//create i/o streams
		Scanner read = null;
		File result = new File("SubDictionary.txt");
		PrintWriter pw = null;
		try {
			read = new Scanner(new FileInputStream(file), "cp1252");
			pw = new PrintWriter(result);
		} catch (FileNotFoundException e) {
			System.out.println("File was not found and program is terminating...");
			System.exit(0);
		}
		
		//creating list of words
		ArrayList<String> dictionary = new ArrayList<String>();
		
		//loop to read through the file
		while (read.hasNext()) {
			String next = read.next();
			next = next.trim();
			next = next.toUpperCase();
			//digit case
			if (next.matches(".*\\d+.*") || (next.length() <= 1)) {
				if(next.equalsIgnoreCase("A") || next.equalsIgnoreCase("I")) {
					dictionary.add(next);
				}
				continue;
			} else {
				//other characters case
				next = next.replaceAll("(\\?|:|,|=|;|!|\\.)", "");
				if (next.contains("’")) {
					next = next.replaceAll("’\\w", "");
				}
				if (next.length() > 1 || next.equalsIgnoreCase("A") || next.equalsIgnoreCase("I")) {
					dictionary.add(next);
				}
			} 
		
		}
		//sorting
		dictionary.sort(String::compareToIgnoreCase);	
		
		//removing duplicates
		for (int i = 0; i< dictionary.size()-1; i++) {
			if (dictionary.get(i).equals(dictionary.get(i+1))) {
			dictionary.remove(i);
			i--;
			}
		}
		dictionary.trimToSize();
		char current  = '0';
		
		//printing out
		pw.println("The document produced this sub-dictionary, which includes " + dictionary.size() +  " entries.");
		for (int i = 0; i< dictionary.size(); i++) {
			if(current != dictionary.get(i).charAt(0)) {
				current = dictionary.get(i).charAt(0);
				pw.println();
				pw.println(dictionary.get(i).charAt(0));
				pw.println("==");
			}
			pw.println(dictionary.get(i));
		}
		pw.close();
	}
	
	
	
	
	
}
