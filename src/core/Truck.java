package core;

public class Truck extends Vehicle{
	
	
		
	private int cargoCapacity;

	public Truck(int type, String location, String make, String model, String regNo, int weight, int cargoCapacity) {
		super(type, location, make, model, regNo, weight);
		this.cargoCapacity = cargoCapacity;
	}




	

}
