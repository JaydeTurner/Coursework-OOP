
public class Tanker extends Vehicle {
	
	private String liquidType;
	private int liquidCapacity;
	
	public Tanker(String location, String make, String model, String regNo, int weight) {
		super(location, make, model, regNo, weight);
		this.liquidCapacity = liquidCapacity;
		this.liquidType = liquidType;
	}


}
