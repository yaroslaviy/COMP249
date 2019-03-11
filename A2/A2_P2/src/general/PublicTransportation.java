package general;

// -----------------------------------------------------
// Assignment 2
// Part: I
// Written by: Yaroslav Bilodid ID40068605
// -----------------------------------------------------



/**
 * Yaroslav Bilodid ID40068605 <br>
 * COMP249 <br>
 * Assignment # 2 <br> 
 * Due Date Wednesday, 20 February  <br>
 * 
 * 
 * @author Yaroslav Bilodid <br>
 * PublicTransportation class in general package <br>
 * Superclass for every other class
 */
public class PublicTransportation {
	private double price;
	private int numStops;
	
	/**
	 * Default constructor
	 */
	public PublicTransportation() {
		price = 0;
		numStops = 0;
	}
	
	/**
	 * Parameterized constructor
	 * @param price The price of the ticker
	 * @param numStops The number of stops
	 */
	public PublicTransportation(double price, int numStops) {
		this.price = price;
		this.numStops = numStops;
	}
	
	/**
	 * Copy constructor
	 * @param p1 The original object that is being copied
	 */
	public PublicTransportation(PublicTransportation p1) {
		this.price = p1.price;
		this.numStops = p1.numStops;
	}
	
	/**
	 * Accessor for ticket price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Mutator for the ticket price
	 * @param price New ticket price 
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Accessor for number of stops
	 * @return number of stops
	 */
	public int getNumStops() {
		return numStops;
	}
	
	/**
	 * Mutator for the number of stops
	 * @param numStops New number of stops
	 */
	public void setNumStops(int numStops) {
		this.numStops = numStops;
	}
	
	/**
	 * toString method that displays all information about an object
	 */
	public String toString() {
		return "This PublicTransportation has a price of " + price + " and " + numStops + " stops.";
	}
	
	/**
	 * equals method that compares two objects 
	 * @param check Object to be compared to
	 * @return boolean value  
	 */
	public boolean equals(Object check) {
		if (check == null || check.getClass() != this.getClass()) 
	           return false;  	 
		return (this.price == ((PublicTransportation)check).price) && (this.numStops == ((PublicTransportation)check).numStops);		
	}
}