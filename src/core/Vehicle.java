package core;
public class Vehicle {

	protected int type;
	protected String location;
	protected String make;
	protected String model;
	protected String regNo;
	protected int weight;
	
	public Vehicle(int type, String location, String make, String model, String regNo, int weight) {

		this.type = type;
		this.location = location;
		this.make = make;
		this.model = model;
		this.regNo = regNo;
		this.weight = weight;
	}

	public int GetType() {
		return type;
		
	}
	
	public String GetLocation() {
		return location;
		
	}
	
	public String GetMake() {
		return make;
		
	}
	
	public String GetModel() {
		return model;
		
	}
	
	public String GetRegNo() {
		return regNo;
		
	}
	
	public int GetWeight() {
		return weight;
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
	
	public void PrintVehicleInfo() {
		
		String vehicleInfo = GetLocation() + " " + GetMake() + " " + GetModel() + " " +
		 GetRegNo() + " " + + GetWeight() + " "  + IsAvailable();
		
		System.out.format(vehicleInfo);
		
		

	}

	

}
