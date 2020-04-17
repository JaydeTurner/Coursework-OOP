import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class EDepot {
	private static final Scanner S = new Scanner(System.in);

	private static final ArrayList<Depot> DEPOTS = new ArrayList<Depot>();

	public static void main(String[] args) {

		LoadDepotsFromFile();

		MainMenu();

	}

	public static void MainMenu() {

		String menuInput = " "; // Initialising menu input to a blank space.
				do {
			System.out.format("\tExcellence E-Depot Systems\n");
			System.out.format("\t\tMain Menu:\t\t\n");
			System.out.format("1) Log On\n");
			System.out.format("2) List Depots\n");
			System.out.format("Q) Quit Application\n");

			menuInput = S.next().toUpperCase();

			switch (menuInput) {
			case "1":
				System.out.format("You have selected Log On\n");
				LogOn();
				break;
			case "2":
				System.out.format("You have selected list Depots\n");
				ListDepots();
				break;
			}

		} while (!menuInput.equals("Q"));

	}

	public Depot GetDepot() {

		return null;
	}

	public static void ListDepots() {
		System.out.format("List Of Depots:\n");
		for (Depot d : DEPOTS) {
			d.PrintDepotInfo();
			d.listVehicles();
		}
		System.out.format("\n\n");

	}

	public static void LogOn() {

		String usrName = " ";
		String pwd = " ";

		System.out.format("\nUsername: ");
		usrName = S.next().toUpperCase();

		System.out.format("\nYou are trying to log in as " + usrName);

		Driver curUser = new Driver(usrName);

		System.out.format("\nPassword: ");
		pwd = S.next();

		System.out.format("Logging in...");

		if (curUser.CheckPassword(pwd)) {
			System.out.format("Welcome, " + usrName + "\n\n");
		}

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
