package core;

public class Tanker extends Vehicle {

	private int liquidCapacity;
	private String liquidType;

	public Tanker(int type, String location, String make, String model, String regNo, int weight, int liquidCapacity,
			String liquidType) {
		super(type, location, make, model, weight, regNo);
		this.liquidCapacity = liquidCapacity;
		this.liquidType = liquidType;
	}

	public int getLiquidCapacity() {
		return liquidCapacity;
	}

	public void setLiquidCapacity(int liquidCapacity) {
		this.liquidCapacity = liquidCapacity;
	}

	public String getLiquidType() {
		return liquidType;
	}

	public void setLiquidType(String liquidType) {
		this.liquidType = liquidType;
	}
}
