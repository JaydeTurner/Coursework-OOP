package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	public static Date curDate = new Date();
	public static Driver curUser = new Driver("Guest user", "DEFPASS", "DELOCF", 0);
	public static Vehicle curVehicle = new Vehicle(0, "DEFVEHICLE", "DEFMODEL", "DEFREG", " DEFLOC", 0);

	public WorkSchedule curSchedule = new WorkSchedule("client ", "Address", curDate, curDate, curUser, curVehicle);

	public Depot(String depotName, String postCode) {
		this.depotName = depotName;
		this.postCode = postCode;

	}

	public void depotMenu(Driver thisUser)

	// ------thisUser = The user that is being passed in from the main menu
	// ------curUser = The current user of the depot
	{
		curUser = thisUser;

		LoadVehiclesFromFile();
		loadPersonelFromFile();
		loadScheduleFromFile(curUser);
		
		System.out.format(curUser.getDriverInfo() + " \n");

		String menuInput = "";

		do {
			System.out.format("\n" + depotName + " Depot Menu:\t\t\n\n");
			System.out.format("1) List Vehicles\n");
			System.out.format("2) List Drivers\n");
			System.out.format("3) List Schedule\n");
			if (curUser.getPriviledge() == 1) {
				System.out.format("4) New Vehicle\n");
				System.out.format("5) New Driver\n");
			}
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
			case "3":
				System.out.format("Listing Schedule...\n");
				listSchedule();
				break;
			case "4":
				if(curUser.getPriviledge() == 1) {
				newDriver();
				break;
				}
			case "5":
				if(curUser.getPriviledge() == 1) {
				newVehicle();
				break;
				}
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

	public void listSchedule() {

		for (WorkSchedule s : SCHEDULE) {
			if (s.getAssignedDriver().GetUserName().equals(curUser.getUserName())) {
				System.out.format(s.printSchedule() + "\n");
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

	public void loadScheduleFromFile(Driver curUser) {
		Scanner CSVFile = null;

		try {

			CSVFile = new Scanner(new FileReader("C:\\Users\\jayde\\git\\Coursework-OOP\\src\\data\\Schedule.csv"));

			while (CSVFile.hasNext()) {
				String[] array = CSVFile.nextLine().split(" ");

				// TODO: Separate parsing functionality to be its own class

				// TODO: create a loop to track our index in the array for
				// more readable and efficient

				// --------Parsing our dates from schedule file into date objects-----------
				SimpleDateFormat ft = new SimpleDateFormat("E, MMM dd HH:mm:ss Z yyyy");

				String curStartDateStr = (array[2].toString() + " " + array[3].toString() + " " + array[4].toString()
						+ " " + array[5].toString() + " " + array[6].toString() + " " + array[7].toString());
				String curEndDateStr = (array[8].toString() + " " + array[9].toString() + " " + array[10].toString()
						+ " " + array[11].toString() + " " + array[12].toString() + " " + array[13].toString());

				Date curStartDate = ft.parse(curStartDateStr);
				Date curEndDate = ft.parse(curEndDateStr);
				// ---------Parsing Driver--------

				Driver scheduledDriver = new Driver(String.valueOf(array[14]), " ", array[15], 0);
				// ---------Parsing Vehicle------
				Vehicle scheduledVehicle = new Vehicle(0, null, String.valueOf(array[16]), String.valueOf(array[17]),
						String.valueOf(array[18]), 0);
				// Adding to our schedule list
				SCHEDULE.add(new WorkSchedule(array[0], array[1], curStartDate, curEndDate, scheduledDriver,
						scheduledVehicle));

			}
		} catch (FileNotFoundException e) {
			System.err.format(e.getMessage());
			System.out.format("Please Contact the System Administrator. Error: schedule file not found\n");
		} catch (ParseException e) {
			System.out.format("Unparsable Date");
			e.printStackTrace();
		} finally {
			System.out.format("\nSchedule loaded from file...\n");
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

	public void newVehicle() {

		System.out.format("\nWould you like to add a truck, or tanker?\n");
		System.out.format("1) Truck\n");
		System.out.format("2) Tanker\n");
		String menuInput = S.next();

		if (menuInput.toString() == "1") {
			System.out.format("\nTruck make: ");
			String newMake = S.next().toUpperCase();
			System.out.format("\nTruck Model: ");
			String newModel = S.next().toUpperCase();
			System.out.format("\nTruck Registration Number : ");
			String newRegNo = S.next().toUpperCase();
			System.out.format("\nTruck Weight: ");
			String newWeight = S.next().toUpperCase();
			System.out.format("\nTruck Cargo Capacity: ");
			String newCargoCap = S.next().toUpperCase();

			VEHICLES.add(new Truck(0, depotName, newMake, newModel, newRegNo, Integer.valueOf(newWeight),
					Integer.valueOf(newCargoCap)));
		}

		else if (menuInput.toString() == "2") {
			System.out.format("\nTanker make: ");
			String newMake = S.next().toUpperCase();
			System.out.format("\nTanker Model: ");
			String newModel = S.next().toUpperCase();
			System.out.format("\nTanker Registration Number : ");
			String newRegNo = S.next().toUpperCase();
			System.out.format("\nTanker Weight: ");
			String newWeight = S.next().toUpperCase();
			System.out.format("\nTanker Liquid Type: ");
			String newLiqType = S.next().toUpperCase();
			System.out.format("\nTanker Liquid Capacity: ");
			String newLiqCap = S.next().toUpperCase();

			VEHICLES.add(new Tanker(1, depotName, newMake, newModel, newRegNo, Integer.valueOf(newWeight),
					Integer.valueOf(newLiqCap), newLiqType));
			System.out.format("Vehicle Added! ");
		}
	}

	public void newDriver() {

	}

	public void newSchedule() {

	}

	public void saveSchedule() {

	}

	public void saveVehicles() {
		try {
			final PrintWriter WRITER = new PrintWriter(
					"C:\\Users\\jayde\\git\\Coursework-OOP\\src\\data\\vehicles.csv");
			for (Vehicle v : VEHICLES) { // for every element of arraylist vehicles, then write a line consisting of the
				// data members pulled via getters
				WRITER.println(v.GetType() + " " + v.GetLocation() + " " + v.GetMake() + " " + v.GetModel() + " "
						+ v.GetRegNo() + " " + v.GetWeight());
			}
			WRITER.flush(); // This ensures we have no new line characters or anything stored in the buffer
			WRITER.close();// that could cause runtime issues
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}

	}

	public void saveDrivers() {

	}
}
