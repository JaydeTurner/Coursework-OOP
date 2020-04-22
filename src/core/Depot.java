package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import scheduler.WorkSchedule;

//TODO: REFACTOR ALL FUNCTIONS AND VARIABLES TO BE CORRECT CASE 
//	WITH APPROPRIATE NAMES

public class Depot {

	protected String depotName;
	protected String postCode;

	private static final Scanner S = new Scanner(System.in);

	private static final ArrayList<Vehicle> VEHICLES = new ArrayList<Vehicle>();
	private static final ArrayList<Driver> DRIVERS = new ArrayList<Driver>();
	private static final ArrayList<WorkSchedule> SCHEDULE = new ArrayList<WorkSchedule>();

	public Date curDate = new Date();
	public static Driver curUser = new Driver("Guest user", "DEFPASS", "DELOCF", 0);
	public static Vehicle curVehicle = new Vehicle(0, "DEFVEHICLE", "DEFMODEL", "DEFREG", " DEFLOC", 0);

	public WorkSchedule curSchedule = new WorkSchedule("client ", "Address", curDate, curDate, curUser, curVehicle, 1,
			curDate, JobState.PENDING);

	public Depot(String depotName, String postCode) {
		this.depotName = depotName;
		this.postCode = postCode;

	}

	public void depotMenu(Driver curUser) {
		LoadVehiclesFromFile();
		loadPersonelFromFile();

		String menuInput = "";

		do {
			System.out.format("\n" + depotName + " Depot Menu:\t\t\n\n");
			System.out.format("1) List Vehicles\n");
			System.out.format("2) List Drivers\n");
			System.out.format("Q) Main Menu\n");
			menuInput = S.next().toUpperCase();

			// --------------Menu input Parameters here--------------

			switch (menuInput) {
			case "1":
				System.out.format("Listing Vehicles...\n");
				listVehicles();
				break;
			case "2":
				System.out.format("Listing Drivers...\n");
				listDrivers();
				break;
			case "Q":
				System.out.format("Returning to Main Menu...\n");

				break;
			}

		} while (!menuInput.equals("Q"));

	}

	public String getDepotName() {
		return depotName;
	}

	public String GetPostCode() {
		return postCode;
	}

	public void setDepotName(String s) {
		depotName = s;

	}

	public void GetVehicle() {

	}

	public void Getdriver() {

	}

	public void WorkSchedule() {

	}

	public void CheckPassword() {

	}

	public void listVehicles() {

		for (Vehicle v : VEHICLES) {

			if (v.GetLocation().equals(getDepotName())) {
				System.out.format(v.getVehicleInfo() + "\n");
			}

		}
	}

	public void listDrivers() {

		for (Driver d : DRIVERS) {
			if (d.getDepotLocation().endsWith(getDepotName())) {
				System.out.format(d.getDriverInfo() + "\n");
			}
		}
	}

	public void IsAvailable() {

	}

	public void PrintDepotInfo() {
		String depotInfo = getDepotName() + " " + GetPostCode();

		System.out.format(depotInfo + "\n");
	}

	@SuppressWarnings("deprecation")
	public void loadScheduleFromFile(Driver curUser) {
		Scanner CSVFile = null;

		try {

			CSVFile = new Scanner(new FileReader("C:\\Users\\jayde\\git\\Coursework-OOP\\src\\data\\Schedule.csv"));

			while (CSVFile.hasNext()) {
				String[] array = CSVFile.nextLine().split(" ");

				// TODO: Seperate parsing functionality to be its own class

				// --------Parsing our dates from schedule file into date objects-----------
				String curStartDateStr = (array[2] + " " + array[3].toString() + " " + array[4].toString() + " "
						+ array[5] + " " + array[6]);
				String curEndDateStr = (array[7] + " " + array[8].toString() + " " + array[9].toString() + " "
						+ array[10] + " " + array[11]);
				Date curStartDate = new Date(curStartDateStr);
				Date curEndDate = new Date(curEndDateStr);

				// ---------Parsing Driver--------

				Driver scheduledDriver = new Driver(String.valueOf(array[12]), " ", array[14], 0);

				// ---------Parsing Vehicle------

				Vehicle scheduledVehicle = new Vehicle(0, null, String.valueOf(array[17]), String.valueOf(array[18]),
						String.valueOf(array[19]), 0);

				if (scheduledDriver.getUserName().equals(curUser.getUserName())) {

					SCHEDULE.add(new WorkSchedule(array[0], array[1], curStartDate, curEndDate, scheduledDriver, scheduledVehicle, 0,
							curDate, null));
				}

			}
		} catch (FileNotFoundException e) {
			System.err.format(e.getMessage());
			System.out.format("Please Contact the System Administrator. Error: personel file not found\n");
		} finally {
			System.out.format("\nPersonel loaded from file...\n");
			if (CSVFile != null) {
				CSVFile.close();
			}
		}

	}

	public void LoadVehiclesFromFile() {

		/*
		 * Here my intention is to load in our vehicles CSV Then I was to get the first
		 * token for the first line. If this token is 0 then we are adding a truck. If
		 * the token is above 0 then we are adding a tanker. Continues till end of file
		 */

		Scanner CSVFile = null;

		try {

			CSVFile = new Scanner(new FileReader("C:\\Users\\jayde\\git\\Coursework-OOP\\src\\data\\vehicles.csv"));

			while (CSVFile.hasNext()) {
				String[] array = CSVFile.nextLine().split(" ");
				if (array[0].startsWith("0")) {

					VEHICLES.add(new Truck(Integer.valueOf(array[0]), String.valueOf(array[1]),
							String.valueOf(array[2]), String.valueOf(array[3]), String.valueOf(array[4]),
							Integer.valueOf(array[6]), Integer.valueOf(array[7])));

				} else if (array[0].startsWith("1") || array[0].startsWith("2")) {

					VEHICLES.add(new Tanker(Integer.valueOf(array[0]), String.valueOf(array[1]),
							String.valueOf(array[2]), String.valueOf(array[3]), String.valueOf(array[5]),
							Integer.valueOf(array[4]), Integer.valueOf(array[0]), String.valueOf(array[6])));

				}

			}

		} catch (FileNotFoundException e) {
			System.err.format(e.getMessage());
			System.out.format("Please Contact the System Administrator. Error: Vehicles file not found\n");
		} finally {
			System.out.format("\nVehicles loaded from file...\n");
			if (CSVFile != null) {
				CSVFile.close();
			}
		}

	}

	public void loadPersonelFromFile() {
		Scanner CSVFile = null;

		try {

			CSVFile = new Scanner(new FileReader("C:\\Users\\jayde\\git\\Coursework-OOP\\src\\data\\personel.csv"));

			while (CSVFile.hasNext()) {
				String[] array = CSVFile.nextLine().split(" ");
				if (getDepotName().equals(array[2])) {
					if (array[3].equals("0")) {

						DRIVERS.add(new Driver(String.valueOf(array[0]), String.valueOf(array[1]),
								String.valueOf(array[2]), Integer.valueOf(array[3])));

					} else if (array[3].equals("1")) {

						DRIVERS.add(new Dmanager(String.valueOf(array[0]), String.valueOf(array[1]),
								String.valueOf(array[2]), Integer.valueOf(array[3])));

					}
				}
			}

		} catch (FileNotFoundException e) {
			System.err.format(e.getMessage());
			System.out.format("Please Contact the System Administrator. Error: personel file not found\n");
		} finally {
			System.out.format("\nPersonel loaded from file...\n");
			if (CSVFile != null) {
				CSVFile.close();
			}
		}
	}

}
