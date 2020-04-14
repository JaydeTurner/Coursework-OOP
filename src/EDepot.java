import java.util.Scanner;

public class EDepot {
    private static final Scanner S = new Scanner(System.in);


	public static void main(String[] args) {
		
		
		//Check our existing depot's and load them in from file. Here we can alert the user if there is a problem with the files.
		
		
		
		String menuInput = " "; // Initialising menu input to a blank space.
								// This is because our check for this loop will
								// trigger and end the loop if it contains NULL
        do {
            System.out.format("\tExcellent E-Depot Systems\n");
            System.out.format("\t\tMain Menu:\t\t\n");
            System.out.format("\nPlease select the Depot you wish to access:\n");
            
            //For each depot, print each depot information per line
            //GetDepot();
    		//List of available depots
            
          //User menu input
            menuInput = S.next().toUpperCase();

            
        } while (!menuInput.equals(null));
		
		
		
		//GetDepot();
		//List of available depots
		
		
		//User menu input
		
		
		//LogOn();
		//Log on call
	}
	
	public Depot GetDepot() {
		
		return null;
		}
	
	
	public void LogOn() {
		
		System.out.format("\nUsername:\n");
		
		//Handle Username input, display input
		
		System.out.format("\nPassword:\n");
		
		//Handle Password, Hide input
	}
	
	public void SetupWorkSchedule() {
		
	}
}
