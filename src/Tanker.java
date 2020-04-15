
public class Tanker extends Vehicle {
	
	private String liquidType;
	private int liquidCapacity;
	
	public Tanker(int type, String location, String make, String model, String regNo, int weight, int liquidCapacity, String liquidType) {
		super(type, location, make, model, regNo, weight);
		this.liquidCapacity = liquidCapacity;
		this.liquidType = liquidType;
	}


}
