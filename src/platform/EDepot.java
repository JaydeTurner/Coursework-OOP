package platform;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import core.Depot;
import core.Driver;


// Any instances of DEF as a string stand for default and should NOT appear at runtime.



//TODO: REFACTOR ALL FUNCTIONS AND VARIABLES TO BE CORRECT CASE 
//	WITH APPROPRIATE NAMES

public class EDepot {
	
	private static final Scanner S = new Scanner(System.in);
	private static final ArrayList<Depot> DEPOTS = new ArrayList<Depot>();

	public static Driver curUser = new Driver("Guest user", "DEF", "DEF", 0);
	public static Depot curDepot = new Depot("DEFDEP", "DEFDEPCODE");
	public static Date curDate = new Date();

	public static void main(String[] args) {

		LoadDepotsFromFile();
		MainMenu();

	}

	public static void MainMenu() {

		String menuInput = " "; // Initialising menu input to a blank space.
		// ---------------Root Menu display
		do {
			System.out.format("\tExcellence E-Depot Systems\n");
			System.out.format("\t\tMain Menu:\t\t\n");
			System.out.format("\n\nWelcome, " + curUser.GetUserName() + "\n");

			// If else to make our menu dynamic
			// If we are not an authenticated user, Display log on as 1)
			if (!curUser.GetAuthStatus()) {
				System.out.format("1) Log On\n");
				// Otherwise, if we are authenticated then we can connect to a depot instead.
			} else if (curUser.GetAuthStatus()) {
				System.out.format("1) Depot Menu\n");
			}

			System.out.format("2) List Depots\n");
			// //Dynamic menu setting. Here we display log off to only users that are logged
			// on.
			while (curUser.GetAuthStatus()) {
				System.out.format("L) Log Off\n");
				break;
			}

			System.out.format("Q) Quit Application\n");
			menuInput = S.next().toUpperCase();

			// --------------Menu input Parameters here--------------

			switch (menuInput) {
			case "1":
				if (!curUser.GetAuthStatus()) {
					System.out.format("You have selected Log On\n");
					LogOn();

					break;
				} else if (curUser.GetAuthStatus()) {
					System.out.format("You have selected Depot Menu\n");
					curDepot.depotMenu(curUser);
					break;
				}
			case "2":
				System.out.format("You have selected list Depots\n");
				ListDepots();
				break;
			case "L":
				System.out.format("Logging out...\n");
				LogOff();
				break;
			}

		} while (!menuInput.equals("Q"));
		
		System.out.format("Closing Streams and shutting down...");
		S.close();

	}

	public Depot GetDepot() {

		return null;
	}

	public static void ListDepots() {
		System.out.format("List Of Depots:\n");
		for (Depot d : DEPOTS) {
			d.PrintDepotInfo();
		}
		System.out.format("\n");

	}

	public static void LogOn() {

		String usrName = " ";
		String pwd = " ";

		System.out.format("\nUsername: ");
		usrName = S.next().toUpperCase();
		System.out.format("\nYou are trying to log in as " + usrName);
		System.out.format("\nPassword: ");
		pwd = S.next();
		System.out.format("Logging in...");

		curUser.CheckCredentials(usrName, pwd);
		if (curUser.getAuthStatus()) {
			
			curDepot.setDepotName(curUser.getDepotLocation());
			System.out.format("Welcome, " + usrName + "\n");
			System.out.format("You are connected to : " + curDepot.getDepotName() + "\n");
		}
	}

	public static void LogOff() {
		curUser.setUserName("Guest");
		curUser.setDepotLocation("DEF");
		curUser.SetAuthStatus(false);
	}

	public void SetupWorkSchedule() {

	}

	public static void LoadDepotsFromFile() {

		Scanner CSVFile = null;

		try {

			CSVFile = new Scanner(new FileReader("C:\\Users\\jayde\\git\\Coursework-OOP\\src\\data\\depots.csv"));

			while (CSVFile.hasNext()) {
				String[] array = CSVFile.nextLine().split(" ");

				DEPOTS.add(new Depot(String.valueOf(array[0]), String.valueOf(array[1])));
			}

		} catch (FileNotFoundException e) {
			System.err.format(e.getMessage());
			System.out.format("Please Contact the System Administrator. Error: Depots file not found\n");
		} finally {
			if (CSVFile != null) {
				CSVFile.close();
			}
		}

	}

}
