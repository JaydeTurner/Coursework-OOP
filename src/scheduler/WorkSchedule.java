package scheduler;

import java.util.Date;

import core.Driver;
import core.JobState;
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
	private JobState jobState; 
	
	
	protected int cargoType;

	public static Date curDate;

	public WorkSchedule(String client, String deliveryAddress, Date startDate, Date endDate, Driver assignedDriver,
			Vehicle assignedVehicle, int cargoType, Date curDate, JobState jobState) {

		this.client = client;
		this.deliveryAddress = deliveryAddress;
		this.startDate = startDate;
		this.endDate = endDate;
		this.assignedDriver = assignedDriver;
		this.assignedVehicle = assignedVehicle;
		this.jobState = jobState;
	}
	
	public String printSchedule() {
		
		String s = client + " " + deliveryAddress + " " + startDate + " " + endDate + " " + assignedDriver.printDriverInfo() + " " + assignedVehicle.PrintVehicleInfo() ;
		
		
		return s;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Vehicle getAssignedVehicle() {
		return assignedVehicle;
	}

	public void setAssignedVehicle(Vehicle assignedVehicle) {
		this.assignedVehicle = assignedVehicle;
	}

	public JobState getJobState() {
		return jobState;
	}

	public void setJobState(JobState jobState) {
		this.jobState = jobState;
	}

	public int getCargoType() {
		return cargoType;
	}

	public void setCargoType(int cargoType) {
		this.cargoType = cargoType;
	}


}
