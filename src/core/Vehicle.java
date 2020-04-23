package core;

public class Vehicle {

	protected int type;
	protected String location;
	protected String make;
	protected String model;
	protected String regNo;
	protected int weight;

	public Vehicle(int type, String location, String make, String model, int weight, String regNo) {

		this.type = type;
		this.location = location;
		this.make = make;
		this.model = model;
		this.regNo = regNo;
		this.weight = weight;
	}

	public int getType() {
		return type;

	}

	public String getLocation() {
		return location;

	}

	public String getMake() {
		return make;

	}

	public String getModel() {
		return model;

	}

	public String getRegNo() {
		return regNo;

	}

	public int getWeight() {
		return weight;
	}

	public boolean isAvailable() {
		boolean availability = false;
		/*
		 * Keeping the default state of availability to false So should something go
		 * wrong, there should not be instances of double booking.
		 */
		return availability;
	}

	public void setSchedule() {

	}

	public String getVehicleInfo() {

		// A blank space is in place at the end of this string
		// to ensure we cannot break any files
		// due to a new line being added in an unexpected place.

		String vehicleInfo = getType() + " " + getLocation() + " " + getMake() + " " + getModel() + " " + getRegNo()
				+ " " + +getWeight() + " ";

		return vehicleInfo;

	}

	public void moveDepot(String s) {
		location = s.toUpperCase();
		System.out.format("Vehicle sucessfully moved to " + location + "\n");
	}
}
