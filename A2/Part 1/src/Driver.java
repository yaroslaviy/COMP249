import java.util.Random;

import city.*;

import general.*;
import global.*;
import air.AirCraft;
import air.AirCraft.ClassType;
import air.AirCraft.MaintenanceType;

//-----------------------------------------------------
//Assignment 2
//Part: I
//Written by: Yaroslav Bilodid ID40068605
//-----------------------------------------------------

/**
 * Yaroslav Bilodid ID40068605 <br>
 * COMP249 <br>
 * Assignment # 2 <br>
 * Due Date Wednesday, 20 February <br>
 * 
 * 
 * @author Yaroslav Bilodid PublicTransportation class General parent for every
 *         other class
 */
public class Driver {
	
	/**
	 * Static method for generating price
	 * @return double in range from 0 to 11 excluded
	 */
	public static double generatePrice() {
		Random r = new Random();
		return r.nextDouble() + r.nextInt(10);

	}
	
	/**
	 * Method for finding minimum price in array
	 * @param arr Array of PublicTransportation
	 * @return index of object with minimum price
	 */
	public static int findMinPrice(PublicTransportation[] arr) {
		int min = 0;
		boolean newMin = false;
		boolean finish = false;
		for (int i = 0; i < arr.length - 1; i++) {
			if (newMin)
				i = min;
			for (int x = i + 1; x < arr.length; x++) {
				if (arr[i].getPrice() <= arr[x].getPrice()) {
					newMin = false;
				} else {
					newMin = true;
					min = x;
					break;
				}
				if (x == arr.length - 1)
					finish = true;
			}
			if (finish)
				break;
		}
		return min;
	}
	
	/**
	 * Method for finding maximum price in array
	 * @param arr Array of PublicTransportation
	 * @return index of object with maximum price
	 */
	public static int findMaxPrice(PublicTransportation[] arr) {
		int max = 0;
		boolean newMax = false;
		boolean finish = false;
		for (int i = 0; i < arr.length - 1; i++) {
			if (newMax)
				i = max;
			for (int x = i + 1; x < arr.length; x++) {
				if (arr[i].getPrice() >= arr[x].getPrice()) {
					newMax = false;
				} else {
					newMax = true;
					max = x;
					break;
				}
				if (x == arr.length - 1)
					finish = true;
			}
			if (finish)
				break;
		}
		return max;
	}

	public static void main(String[] args) {
		
		//creating 6 objects from different classes
		PublicTransportation p1 = new PublicTransportation(3.25, 50);
		CityBus c1 = new CityBus(2.50, 35, 88322222, 2005, "Monkland", "Adam");
		Tram t1 = new Tram(2.45, 50, 2010, 2142414124L, "LOL", "LUL", 70);
		AirCraft a1 = new AirCraft(8.5, 3, ClassType.AIRLINE, MaintenanceType.YEARLY);
		Ferry f1 = new Ferry(4.35, 5, 1987, "SHIP");
		Metro m1 = new Metro(3.25, 46, 241421242141L, 1950, "STM", "Dodik", 15, "Mtl");
		
		// displaying information of 6 created objects
		System.out.println(p1.toString());
		System.out.println(c1.toString());
		System.out.println(t1.toString());
		System.out.println(a1.toString());
		System.out.println(f1.toString());
		System.out.println(m1.toString());
		
		//creating array of 15 objects
		PublicTransportation[] arr = new PublicTransportation[15];

		arr[0] = p1;
		arr[1] = c1;
		arr[2] = t1;
		arr[3] = a1;
		arr[4] = f1;
		arr[5] = m1;
		
		//generating the rest of array with random ticket prices
		for (int i = 6; i < arr.length; i++) {
			arr[i] = new Metro(generatePrice(), 15, 877788787878887L, 1960, "Generated", "Gena", 70, "Paris");
		}
		

		//displaying the lowest and the highest price
		System.out.println('\n'+"The lowest price Public Transportation has an index of " + findMinPrice(arr) + ". "  + arr[findMinPrice(arr)].toString());
		System.out.println("The highest price Public Transportation has an index of " + findMaxPrice(arr) + ". "   + arr[findMaxPrice(arr)].toString());

	}

}
