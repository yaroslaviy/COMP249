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
* Due Date Wednesday, 20 February <br>
* 
* 
* @author Yaroslav Bilodid
* Tram class in city package
*/
public class Tram extends CityBus {

	private int maxSpeed;
	
	/**
	 * Default constructor
	 */
	public Tram() {
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
	 * @param maxSpeed The maximum speed of the tram
	 */	
	public Tram(double price, int numStops,  int year,  long route, String line, String driver, int maxSpeed) {
		super(price, numStops, route, year, line, driver);
		this.maxSpeed = maxSpeed;
	}
	
	/**
	 * Copy constructor
	 * @param t1 The original object that is being copied
	 */
	public Tram(Tram t1) {
		super(t1);
		this.maxSpeed = t1.maxSpeed;
	}
	
	/**
	 * Accessor for the maximum speed
	 * @return The maximum speed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	/**
	 *  Accessor for the maximum speed
	 * @param maxSpeed New maximum speed
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	/**
	 * toString method that displays all information about an object
	 */
	public String toString() {
		return "This Tram has a price of " + this.getPrice() + ", " + this.getNumStops() + " stops, its route number " + this.getRouteNum() + ", begin operation year is " + this.getBeginYear() + ", line name " + getLineName() +
				" and driver is " + this.getDriverName() + ", and maximum speed is " + maxSpeed;

	}
	/**
	 * equals method that compares two objects 
	 * @param check Object to be compared to
	 * @return boolean value  
	 */
	public boolean equals(Object check) {
		return super.equals(check) && (this.maxSpeed == ((Tram)check).maxSpeed);		
	}
}
