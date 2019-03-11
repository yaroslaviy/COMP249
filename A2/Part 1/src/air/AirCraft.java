package air;
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
public class AirCraft extends PublicTransportation {
	
	public enum ClassType{
		HELICOPTER, AIRLINE, GLIDER, BALLOON
	}
	public enum MaintenanceType{
		WEEKLY, MONTHLY, YEARLY
	}
	
	private ClassType classType;
	private MaintenanceType mainType;
	
	
	/**
	 * Default constructor
	 */
	public AirCraft() {
		super();
		this.classType = null;
		this.mainType = null;
	}

	/**
	 * Parameterized constructor
	 * @param price The price of the ticker
	 * @param numStops The number of stops
	 * @param classType The type of Air Craft
	 * @param mainType The type of maintenance
	 */
	public AirCraft(double price, int numStops, ClassType classType, MaintenanceType mainType) {
		super(price, numStops);
		this.classType = classType;
		this.mainType = mainType;
	}
	
	/**
	 * Copy constructor
	 * @param a1 The original object that is being copied
	 */
	public AirCraft(AirCraft a1) {
		super(a1);
		this.classType = a1.classType;
		this.mainType = a1.mainType;
	}
	
	
	/**
	 * Accessor for the class of the AirCraft
	 * @return The class of the AirCraft
	 */
	public ClassType getClassType() {
		return classType;
	}
	/**
	 * Mutator for the class of the AirCraft
	 * @param classType the class of the AirCraft
	 */
	public void setClassType(ClassType classType) {
		this.classType = classType;
	}
	/**
	 * Accessor for the maintenance type of the AirCraft
	 * @return The maintenance type of the AirCraft
	 */
	public MaintenanceType getMainType() {
		return mainType;
	}
	/**
	 * Mutator for the class of the AirCraft
	 * @param mainType the maintenance type of the AirCraft
	 */
	public void setMainType(MaintenanceType mainType) {
		this.mainType = mainType;
	}
	/**
	 * toString method that displays all information about an object
	 */
	public String toString() {
		return "This AirCraft has a price of " + price + " and " + numStops + " stops, it is a " + classType + " and has a maintenance " + mainType;
	}
	/**
	 * equals method that compares two objects 
	 * @param check Object to be compared to
	 * @return boolean value  
	 */
	public boolean equals(Object check) {
		return super.equals(check) && (this.classType == ((AirCraft)check).classType)  && (this.mainType == ((AirCraft)check).mainType);
	}
}
