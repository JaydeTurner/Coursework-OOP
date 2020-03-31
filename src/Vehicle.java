
public class Vehicle {
	
	protected String make;
	protected String model;
	protected String regNo;
	protected int weight;
	
	
	public boolean IsAvailable() {
		boolean availability = false;
		/*Keeping the default state of availability to false
		So should something go wrong, there should not be instances
		of double booking.
		*/
		return availability;
	}
	
	public void SetSchedule() {
		
	}
	
}
	
	