package global;
import general.*;

//-----------------------------------------------------
//Assignment 2
//Part: I
//Written by: Yaroslav Bilodid ID40068605
//-----------------------------------------------------



/**
* Yaroslav Bilodid ID40068605 <br>
* COMP249 <br>
* Assignment # 2 <br> 
* Due Date Wednesday, 20 February  <br>
* 
* 
* @author Yaroslav Bilodid
* PublicTransportation class
* General parent for every other class
*/
public class Ferry extends PublicTransportation {
	

	private int builtYear;
	private String shipName;
	
	/**
	 * Default constructor
	 */
	public Ferry() {
		super();
		builtYear = 0;
		shipName = null;
	}
	/**
	 * Parameterized constructor
	 * @param price The price of the ticker
	 * @param numStops The number of stops
	 * @param year The year Ferry was build in
	 * @param name The name of the ship
	 */
	public Ferry(double price, int numStops, int year, String name) {
		super(price, numStops);
		this.builtYear = year;
		this.shipName = name;
		
	}
	/**
	 * Copy constructor
	 * @param a1 The original object that is being copied
	 */
	public Ferry(Ferry f1) {
		super(f1);
		this.builtYear = f1.builtYear;
		this.shipName = f1.shipName;
		
	}
	
	/**
	 * Accessor for the year Ferry was build in
	 * @return The year Ferry was build in
	 */
	public int getBuiltYear() {
		return builtYear;
	}
	/**
	 * Mutator for the year Ferry was build in
	 * @param builtYear New year Ferry was build in
	 */
	public void setBuiltYear(int builtYear) {
		this.builtYear = builtYear;
	}
	/**
	 * Accessor for the name of the ship
	 * @return The name of the ship
	 */
	public String getShipName() {
		return shipName;
	}
	/**
	 * Mutator for the name of the ship
	 * @param shipName New name of the ship
	 */
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	/**
	 * toString method that displays all information about an object
	 */
	public String toString() {
		return "This Ferry has a price of " + price + " and " + numStops + " stops, was built in " + builtYear + " and called " + shipName;
	}
	/**
	 * equals method that compares two objects 
	 * @param check Object to be compared to
	 * @return boolean value  
	 */
	public boolean equals(Object check) {
	return super.equals(check) && (this.builtYear == ((Ferry)check).builtYear) && (this.shipName.equalsIgnoreCase(((Ferry)check).shipName));
	}
}
