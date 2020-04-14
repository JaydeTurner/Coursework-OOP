import java.io.FileReader;

public class Vehicle {

	protected String location;
	protected String make;
	protected String model;
	protected String regNo;
	protected int weight;
	
	public Vehicle(String location, String make, String model, String regNo, int weight) {
		this.location = location;
		this.make = make;
		this.model = model;
		this.regNo = regNo;
		this.weight = weight;
	}

	public boolean IsAvailable() {
		boolean availability = false;
		/*
		 * Keeping the default state of availability to false So should something go
		 * wrong, there should not be instances of double booking.
		 */
		return availability;
	}

	public void SetSchedule() {

	}

	

}
