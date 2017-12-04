package ie.lyit.testers;

import java.util.Scanner;
import ie.lyit.serialize.CustomerSerializer;

public class CustomerSerializerTester {

	public static void main(String[] args) {
		CustomerSerializer customerSerializer = new CustomerSerializer();
		Scanner keyboardIn = new Scanner(System.in);

		// Read the ArrayList from the File
		customerSerializer.readRecordsFromFile();

		String option;

		do {
			System.out.println("Hotel Menu:");
			System.out.println("\t1. Add");
			System.out.println("\t2. List");
			System.out.println("\t3. View");
			System.out.println("\t4. Edit");
			System.out.println("\t5. Delete");
			System.out.println("\t6. Quit");
			System.out.print("Enter option :-");
			
			option = keyboardIn.next();
			
			if(option.equals("1")) {
				customerSerializer.add();
				System.out.println("\nYou have entered a new customer.");
			}
			else if(option.equals("2")) {
				System.out.println("\nThis is the list of current customers:");
				customerSerializer.list();
			}
			else if(option.equals("3")) {
				customerSerializer.view();
			}
			else if(option.equals("4")) {
				customerSerializer.edit();
				System.out.println("\nThe customers details have been edited.");
			}
			else if(option.equals("5")) {
				customerSerializer.delete();
				System.out.println("\nThe customer has been deleted.");
			}
			else if(option.equals("6")) {
				System.out.print("Exited from menu, goodbye.");
				option = "exit";
			}
			else
				System.out.println("Invalid Option");			

			// Write the ArrayList to File
			customerSerializer.writeRecordsToFile();

		}while(option!="exit");
	}
}