package city;
import general.*;

//-----------------------------------------------------
//Assignment 2
//Part: I
//Written by: Yaroslav Bilodid ID40068605
//-----------------------------------------------------



/**
 *  Yaroslav Bilodid ID40068605 <br>
 * COMP249 <br>
 * Assignment # 2 <br> 
 * Due Date Wednesday, 20 February <br>
 * 
 * 
 * @author Yaroslav Bilodid <br>
 * CityBus class in city package <br>
 * Superclass of Tram and Metro classes 
 *
 */
public class CityBus extends PublicTransportation {
	private long routeNum;
	private int beginYear;
	private String lineName;
	private String driverName;
	
	/**
	 * Default constructor
	 */
	public CityBus() {
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
 */
	public CityBus(double price, int numStops, long route, int year, String line, String driver) {
		super(price, numStops);
		this.routeNum = route;
		this.beginYear = year;
		this.lineName = line;
		this.driverName = driver;
		
	}
	
	/**
	 * Copy constructor
	 * @param c1 The original object that is being copied
	 */
	public CityBus(CityBus c1) {
		super(c1);
		this.routeNum = c1.routeNum;
		this.beginYear = c1.beginYear;
		this.lineName = c1.lineName;
		this.driverName = c1.driverName;
		
	}
	
	/**
	 * Accessor for the route number
	 * @return The route number
	 */
	public long getRouteNum() {
		return routeNum;
	}
	
	/**
	 * Mutator for the route number
	 * @param routeNum New route number 
	 */
	public void setRouteNum(long routeNum) {
		this.routeNum = routeNum;
	}
	
	/**
	 * Accessor for the begin operation year
	 * @return Begin operation year
	 */
	public int getBeginYear() {
		return beginYear;
	}
	
	/**
	 * Mutator for the begin operation year
	 * @param beginYear New begin operation year
	 */
	public void setBeginYear(int beginYear) {
		this.beginYear = beginYear;
	}
	
	/**
	 * Accessor for the line name
	 * @return The line name
	 */
	public String getLineName() {
		return lineName;
	}
	
	/**
	 * Mutator for the line name
	 * @param lineName New line name
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	/**
	 * Accessor for the driver's name
	 * @return the driver's name
	 */
	public String getDriverName() {
		return driverName;
	}
	/**
	 * Mutator for the driver's name
	 * @param driverName New driver's name
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	/**
	 * toString method that displays all information about an object
	 */
	public String toString() {
		return "This CityBus has a price of " + this.getPrice() + ", " + this.getNumStops() + " stops, its route number " + routeNum + ", begin operation year is " + beginYear + ", line name " + lineName 
				+ " and driver is " + driverName;
	}
	/**
	 * equals method that compares two objects 
	 * @param check Object to be compared to
	 * @return boolean value  
	 */
	public boolean equals(Object check) { 
		return super.equals(check) && (this.routeNum == ((CityBus)check).routeNum) && (this.beginYear == ((CityBus)check).beginYear) 
				&& (this.lineName.equalsIgnoreCase(((CityBus)check).lineName)) && (this.driverName.equalsIgnoreCase(((CityBus)check).driverName));		
	}
}
