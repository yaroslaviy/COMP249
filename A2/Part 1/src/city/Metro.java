package city;

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
public class Metro extends CityBus {

	private int numVehicles;
	private String city;
	
	/**
	 * Default constructor
	 */
	public Metro() {
		super();
	}
	
	/**
	 * Parameterized constructor
	 * @param price The price of the ticker
	 * @param numStops The number of stops
	 * @param route The name of the route
	 * @param year The begin operation year
	 * @param line The name of the line
	 * @param driver The name of the driver
	 * @param numVehicules The number of vehicles operating
	 * @param city The city where Metro operates
	 */	
	public Metro(double price, int numStops, long route, int year, String line, String driver, int numVehicles, String city) {
		super(price, numStops, route, year, line, driver);
		this.numVehicles = numVehicles;
		this.city = city;
	}
	
	/**
	 * Copy constructor
	 * @param m1 The original object that is being copied
	 */
	public Metro(Metro m1) {
		super(m1);
		this.city = m1.city;
	}
	/**
	 * Accessor for the number of vehicles
	 * @return The number of vehicles
	 */
	public int getNumVehicles() {
		return numVehicles;
	}
	/**
	 * Mutator for the number of vehicles
	 * @param numVehicles New number of vehicles
	 */
	public void setNumVehicles(int numVehicles) {
		this.numVehicles = numVehicles;
	}
	
	/**
	 * Accessor for the name of the city
	 * @return The name of the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Mutator for the name of the city
	 * @param city New name of the city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * toString method that displays all information about an object
	 */
	public String toString() {
		return "This Metro has a price of " + price + ", " + numStops + " stops, its route number " + routeNum + ", begin operation year is " + beginYear + ", line name " + lineName 
				+ " and driver is " + driverName + ", operates in " + city + " and has " + numVehicles + " vehicles.";
	}
	/**
	 * equals method that compares two objects 
	 * @param check Object to be compared to
	 * @return boolean value  
	 */
	public boolean equals(Object check) {
		return super.equals(check) && (this.numVehicles == ((Metro)check).numVehicles) && (this.lineName.equalsIgnoreCase(((Metro)check).lineName));
	}
}
