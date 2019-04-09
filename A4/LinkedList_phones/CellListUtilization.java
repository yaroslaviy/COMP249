//-----------------------------------------------------
//Assignment 4
//Part: II
//Written by: Yaroslav Bilodid ID40068605
//-----------------------------------------------------
package question2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * The Class CellListUtilization.
 */
public class CellListUtilization {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		CellList l1 = new CellList();
		CellList l2 = new CellList();

		Scanner read = null;
		try {
			read = new Scanner(new FileInputStream("Cell_Info.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File with Cell Info wasn't found. Terminating program...");
			System.exit(0);
		}

		ArrayList<String> cells = new ArrayList<String>();

		while (read.hasNextLine()) {
			String info = read.nextLine();
			cells.add(info);
		}
// reading file
		for (int i = 0; i < cells.size(); i++) {
			String[] result = cells.get(i).split("\\s+");
			long serial = Long.parseLong(result[0]);
			double price = Double.parseDouble(result[2]);
			int year = Integer.parseInt(result[3]);
			if (!l1.contains(serial))
				l1.addToStart(new CellPhone(serial, result[1], year, price));
		}
//testing methods
		System.out.println("List from file:");
		l1.showContents();
		l1.insertAtIndex(new CellPhone(1111, "test", 2008, 9999.99), 0);
		System.out.println();
		System.out.println("Inserting at index 0:");
		l1.showContents();
		l1.deleteFromIndex(0);
		System.out.println();
		System.out.println("Deleting from index 0:");
		l1.showContents();
		
		l1.insertAtIndex(new CellPhone(1111, "test12", 2888, 1111.99), 3);
		System.out.println("Inserting at index 3:");
		l1.showContents();
		l1.deleteFromStart();
		System.out.println("Deleting from the start:");
		l1.showContents();
		l1.replaceAtIndex(new CellPhone(11114444, "test3", 7788, 2211.99), 2);
		System.out.println("Replacing at index 2:");
		l1.showContents();
		System.out.println("Finding by serial number:");
		l1.find(1233333444);
		System.out.println("Testing contains:");
		System.out.println(l1.contains(2787985));
		//testing invalid inputs
		l1.showContents();
		l2.showContents();
		l2.deleteFromStart();
		//l2.insertAtIndex(new CellPhone(11114444, "test3", 7788, 2211.99), 3);
		//l2.deleteFromIndex(3);
		//l2.replaceAtIndex(new CellPhone(11114444, "test3", 7788, 2211.99), 0);
		
		
		System.out.println(l2.equals(l1));
		System.out.println("===========");
		l2 = new CellList(l1);
		System.out.println("Testing copy of the list:");
		System.out.println(l2.equals(l1));
		l2.showContents();
		
		
		
		
	}
}
