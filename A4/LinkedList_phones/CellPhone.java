package question2;

import java.util.Scanner;

public class CellPhone {
	protected long serialNum;
	protected String brand;
	protected int year;
	protected double price;

	public long getSerialNum() {

		return serialNum;
	}

	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CellPhone(long serialNum, String brand, int year, double price) {
		super();
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	public CellPhone(long serialNum, CellPhone original) {
		super();
		this.serialNum = serialNum;
		this.brand = original.brand;
		this.year = original.year;
		this.price = original.price;
	}
	
	public CellPhone clone() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the serial number for the clone: ");
		long sNum = kb.nextLong();
		return new CellPhone(sNum, this);
	}


	

	@Override
	public String toString() {
		return "[" + serialNum + ": " + brand + " " + price + "$ "+  year + "]";
	}

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
		if (serialNum != other.serialNum)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
}
