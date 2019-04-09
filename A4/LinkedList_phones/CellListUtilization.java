package question2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CellListUtilization {
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

		for (int i = 0; i < cells.size(); i++) {
			String[] result = cells.get(i).split("\\s+");
			long serial = Long.parseLong(result[0]);
			double price = Double.parseDouble(result[2]);
			int year = Integer.parseInt(result[3]);
			if (!l1.contains(serial))
				l1.addToStart(new CellPhone(serial, result[1], year, price));
		}
		
		l1.showContents();
		l1.insertAtIndex(new CellPhone(1111, "test", 2008, 9999.99), 0);
		l1.deleteFromIndex(1);
		l1.insertAtIndex(new CellPhone(1111, "test12", 2888, 1111.99), 0);
		l1.deleteFromStart();
		l1.replaceAtIndex(new CellPhone(11114444, "test3", 7788, 2211.99), 2);
		l1.find(11114444);
		System.out.println(l1.contains(2787985));
		l1.showContents();
		l2.showContents();
		System.out.println(l2.equals(l1));
		System.out.println("===========");
		l2 = new CellList(l1);
		l2.showContents();
		
		
	}
}
