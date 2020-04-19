package scheduler;

import java.util.Date;

import core.Driver;
import core.Vehicle;

public class WorkSchedule {

	// Work schedule will exist in the depot.
	// schedule will be parsed, loaded to memory
	// then in depot I will filter the schedule based on username
	// for users, and provide options for managers.

	private String client;
	private String deliveryAddress;
	private Date startDate;
	private Date endDate;
	private Driver assignedDriver;
	private Vehicle assignedVehicle;

	protected int cargoType;

	public static Date curDate;

	public WorkSchedule(String client, String deliveryAddress, Date startDate, Date endDate, Driver assignedDriver,
			Vehicle assignedVehicle, int cargoType, Date curDate) {

		this.client = client;
		this.deliveryAddress = deliveryAddress;
		this.startDate = startDate;
		this.endDate = endDate;
		this.assignedDriver = assignedDriver;
		this.assignedVehicle = assignedVehicle;
	}
	
	public String printSchedule() {
		
		String s = client + " " + deliveryAddress + " " + startDate + " " + endDate + " " + assignedDriver.printDriverInfo() + " " + assignedVehicle.PrintVehicleInfo() ;
		
		
		return s;
	}


}
