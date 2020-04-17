package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Depot {

	protected String depotName;
	protected String postCode;

	private static final Scanner S = new Scanner(System.in);

	private static final ArrayList<Vehicle> VEHICLES = new ArrayList<Vehicle>();
	private static final ArrayList<Driver> DRIVERS = new ArrayList<Driver>();

	public Depot(String depotName, String postCode) {
		this.depotName = depotName;
		this.postCode = postCode;

	}

	public Driver depotMenu(Driver curUser) {
		
		String menuInput = "";
		do {
			System.out.format( depotName + "\t\tDepot Menu:\t\t\n\n");
			System.out.format("1) Placeholder first selection\n");
			System.out.format("Q) Main Menu\n");
			menuInput  = S.next().toUpperCase();

			// --------------Menu input Parameters here--------------

			switch (menuInput) {
			case "1":
				System.out.format("case 1\n");
				break;
			case "2":
				System.out.format("Case 2\n");
				break;
			case "Q":
				System.out.format("Returning to Main Menu...\n");
				
				break;
			}

		} while (!menuInput.equals("Q"));
	
		return curUser;
	}

	public String GetDepotName() {
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
			if (v.GetLocation() == depotName) {
				v.PrintVehicleInfo();
			}
		}
	}

	public void IsAvailable() {

	}

	public void PrintDepotInfo() {
		String depotInfo = GetDepotName() + " " + GetPostCode();

		System.out.format(depotInfo + "\n");
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
				if (array[3].startsWith("0")) {

					DRIVERS.add(new Driver(String.valueOf(array[0]), String.valueOf(array[1]), String.valueOf(array[2]),
							Integer.valueOf(array[3])));

				} else if (array[3].startsWith("1")) {

					DRIVERS.add(new Dmanager(String.valueOf(array[0]), String.valueOf(array[1]), String.valueOf(array[2]),
							Integer.valueOf(array[3])));
				}

			}

		} catch (FileNotFoundException e) {
			System.err.format(e.getMessage());
			System.out.format("Please Contact the System Administrator. Error: personel file not found\n");
		} finally {
			if (CSVFile != null) {
				CSVFile.close();
			}
		}
	}
}
