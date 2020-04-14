
public class Truck extends Vehicle{
	
	private int cargoCapacity;
	
	public Truck(String location, String make, String model, String regNo, int weight, int cargoCapacity) {
		super(location, make, model, regNo, weight);
		this.cargoCapacity = cargoCapacity;
	}


	

}
