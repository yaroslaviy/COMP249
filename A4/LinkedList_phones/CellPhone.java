//-----------------------------------------------------
//Assignment 4
//Part: II
//Written by: Yaroslav Bilodid ID40068605
//-----------------------------------------------------
package question2;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class CellPhone.
 */
public class CellPhone {
	
	/** The serial num. */
	protected long serialNum;
	
	/** The brand. */
	protected String brand;
	
	/** The year. */
	protected int year;
	
	/** The price. */
	protected double price;

	/**
	 * Gets the serial num.
	 *
	 * @return the serial num
	 */
	public long getSerialNum() {

		return serialNum;
	}

	/**
	 * Sets the serial num.
	 *
	 * @param serialNum the new serial num
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand.
	 *
	 * @param brand the new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Instantiates a new cell phone.
	 *
	 * @param serialNum the serial num
	 * @param brand the brand
	 * @param year the year
	 * @param price the price
	 */
	public CellPhone(long serialNum, String brand, int year, double price) {
		super();
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	/**
	 * Instantiates a new cell phone.
	 *
	 * @param serialNum the serial num
	 * @param original the original
	 */
	public CellPhone(long serialNum, CellPhone original) {
		super();
		this.serialNum = serialNum;
		this.brand = original.brand;
		this.year = original.year;
		this.price = original.price;
	}
	
	/**
	 * Clone method
	 * @return clone of passed CellPhone
	 */
	public CellPhone clone() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the serial number for the clone: ");
		long sNum = kb.nextLong();
		return new CellPhone(sNum, this);
	}


	

	/**
	 * toString method
	 * @return string pf the phone
	 */
	@Override
	public String toString() {
		return "[" + serialNum + ": " + brand + " " + price + "$ "+  year + "]";
	}

	/**
	 * Equals method
	 * @param obj object to compare
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellPhone other = (CellPhone) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
}
