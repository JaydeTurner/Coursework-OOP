package core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Driver {

	protected String userName;
	protected String password;
	protected String depotLocation;
	protected int priviledge;
	private boolean authStatus = false;

	public Driver(String userName, String password, String depotLocation, int priviledge) {
		this.userName = userName;
		this.password = password;
		this.depotLocation = depotLocation;
		this.priviledge = priviledge;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setDepotLocation(String depotLocation) {
		this.depotLocation = depotLocation;
	}

	public String getDepotLocation() {
		return depotLocation;
	}

	public String GetUserName() {

		return userName;
	}

	public void setUserName(String i) {
		this.userName = i;

	}

	public boolean SetAuthStatus(boolean s) {
		setAuthStatus(s);
		return s;

	}

	public boolean GetAuthStatus() {
		return getAuthStatus();
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

						setAuthStatus(true);
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

	public int getPriviledge() {
		return priviledge;

	}

	public boolean IsAvailable() {

		return false;

	}

	public void SetSchedule() {

	}

	public boolean getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(boolean authStatus) {
		this.authStatus = authStatus;
	}

}
