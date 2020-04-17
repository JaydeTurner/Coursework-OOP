import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Driver {
	
	protected String userName;
	protected String password;
	
	public Driver(String userName) {
		this.userName = userName;
		
	}
	
	public String GetUserName() {
		
		return userName;
	}
	
	public boolean CheckPassword(String inputPassword) {
		
		Scanner CSVFile = null;

		try {

			CSVFile = new Scanner(new FileReader("C:\\Users\\jayde\\git\\Coursework-OOP\\src\\data\\personel.csv"));

			while (CSVFile.hasNext()) {
				String[] array = CSVFile.nextLine().split(" ");
				
				if (array[0].equals(userName)) {
					
					if(inputPassword.equals(array[1])) {
						System.out.format("You Have sucessfully logged on " + userName + "\n\n");
						break;
					}
					else if(!CSVFile.hasNext()) {
						System.out.format("This is not a recognised user...\n\n\n");
					} 
					else {
						System.out.format("There was an error with your logon " + userName + "\n\n");
			
					}
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

	public boolean IsAvailable() {
		
		return false;
		
	}
	
	public void SetSchedule() {
		
	}
	
	
}
