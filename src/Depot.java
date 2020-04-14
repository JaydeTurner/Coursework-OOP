import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Depot {
	
	private static final ArrayList<Vehicle> VEHICLES = new ArrayList<Vehicle>();

	
	protected String depotName;


	public void GetVehicle() {
		
	}
	
	public void Getdriver() {
		
	}
	
	public void WorkSchedule() {
		
	}
	
	public void CheckPassword() {
		
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

			CSVFile = new Scanner(new FileReader("data/vehicles.csv"));

			while (CSVFile.hasNext()) {

				if (CSVFile.hasNext("0")) {
					
					String[] array = CSVFile.nextLine().split(" ");
					
					VEHICLES.add(new Truck(Integer.valueOf(array[0]), array[1], Double.valueOf(array[2]),
							Boolean.valueOf(array[3]), Boolean.valueOf(array[4]),
							(array.length == 5) ? "" : array[5]));

					Truck mytruck = new Truck();
				} else {
					Tanker mytanker = new Tanker();
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
}
