package core;

public class Truck extends Vehicle {

	private int cargoCapacity;

	public Truck(int type, String location, String make, String model, String regNo, int weight, int cargoCapacity) {
		super(type, location, make, model, weight, regNo);
		this.cargoCapacity = cargoCapacity;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public void setCargoCapacity(int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	public String getTruckInfo() {

		String truckInfo = getType() + " " + getLocation() + " " + getMake() + " " + getModel() + " " + getRegNo() + " "
				+ +getWeight() + " " + getCargoCapacity();

		return truckInfo;

	}

}
