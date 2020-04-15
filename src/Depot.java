import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Depot {

	
	protected String depotName;
	private static final ArrayList<Vehicle> VEHICLES = new ArrayList<Vehicle>();
	
	public Depot(String depotName) {
		
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
			System.out.println("Make :" +v.getMake());
		}
	}
	
	public void IsAvailable() {
		
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
							Integer.valueOf(array[6]), Integer.valueOf(array[7])) );


				} else if (array[0].startsWith("1") || array[0].startsWith("2")) {
					
					VEHICLES.add(new Tanker(Integer.valueOf(array[0]), String.valueOf(array[1]), String.valueOf(array[2]),
							String.valueOf(array[3]), String.valueOf(array[5]), Integer.valueOf(array[4]),
							Integer.valueOf(array[0]), String.valueOf(array[6])) );

				}
				
			}

		} catch (FileNotFoundException e) {
			System.err.format(e.getMessage());
			System.out.format("Please Contact the System Administrator. Error: Vehicles file not found\n");
		} finally {
			if (CSVFile != null) {
				CSVFile.close();
				System.out.println("Closing Stream...");
			}
		}

	}
}
