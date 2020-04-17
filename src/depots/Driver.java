package depots;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Driver {

	protected String userName;
	protected String password;
	protected String depotLocation;
	protected char priviledge;
	protected boolean authStatus = false;

	public Driver(String userName, String password, String depotLocation, char priviledge) {
		this.userName = userName;
		this.password = password;
		this.depotLocation = depotLocation;
		this.priviledge = priviledge;

	}

	public String GetUserName() {

		return userName;
	}

	public void setUserName(String i) {
		this.userName = i;

	}

	public boolean SetAuthStatus(boolean s) {
		authStatus = s;
		return s;

	}

	public boolean GetAuthStatus() {
		return authStatus;
	}

	public boolean CheckCredentials(String inputUsername, String inputPassword) {

		Scanner CSVFile = null;

		try {

			CSVFile = new Scanner(new FileReader("C:\\Users\\jayde\\git\\Coursework-OOP\\src\\data\\personel.csv"));

			while (CSVFile.hasNext()) {
				String[] array = CSVFile.nextLine().split(" ");

				if (array[0].equals(inputUsername)) {

					if (inputPassword.equals(array[1])) {
						setUserName(inputUsername);
						System.out.format("You Have sucessfully logged on " + userName + "\n\n");

						authStatus = true;
						break;
					}
				} else if (!CSVFile.hasNext()) {
					System.out.format("This is not a recognised user...\n\n\n");

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

		return false;

	}

	public char getPriviledge() {
		return priviledge;

	}

	public boolean IsAvailable() {

		return false;

	}

	public void SetSchedule() {

	}

}
