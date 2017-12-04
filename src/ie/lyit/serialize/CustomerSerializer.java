package ie.lyit.serialize;

import java.util.ArrayList;
import ie.lyit.hotel.Customer;
import java.io.*;
import java.util.*;

public class CustomerSerializer implements CustomerDAO{
	// Constant FILENAME for the file to be created
	final String FILENAME = "customers.ser";

	// Declare ArrayList called customers - for storing a list of customers
	private ArrayList<Customer> customers;
	int maxNumber = 0;

	// Default Constructor
	public CustomerSerializer() {
		// Construct customers ArrayList
		customers = new ArrayList<Customer>();
	}

	public void add() {
		// Create a Customer object
		Customer customer = new Customer();
		// Read its details
		customer.read();
		// And add it to the customers ArrayList
		customers.add(customer);
	}

	public void list() {
		// for every Customer object in customers
		for (int i = 0; i < customers.size(); i++) {
			Customer tmpCustomer = customers.get(i);
			// display it
			System.out.println(tmpCustomer.getNumber() + ": " + tmpCustomer);
		}
	}

	public Customer view() {
		Scanner keyboard = new Scanner(System.in);

		// Read the number of the customer to be viewed from the user
		System.out.println("Enter number of customer : ");
		int customerToView = keyboard.nextInt();

		// for every Customer object in customers
		for (int i = 0; i < customers.size(); i++) {
			Customer tmpCustomer = customers.get(i);
			// if it's number equals the number of the customerToView
			if (tmpCustomer.getNumber() == customerToView) {
				// display it
				System.out.println(tmpCustomer.getNumber() + ":" + tmpCustomer);
				return tmpCustomer;
			}
		}
		// if we reach this code the customer was not found so return null
		return null;
	}

	public void delete() {
		// Call view() to find, display, & return the customer to delete
		Customer tempCustomer = view();
		// If the customer != null, i.e. it was found then...
		if (tempCustomer != null)
			// ...remove it from customers
			customers.remove(tempCustomer);
	}

	public void edit() {
		// Call view() to find, display, & return the customer to edit
		Customer tempCustomer = view();
		// If the customer != null, i.e. it was found then...
		if (tempCustomer != null) {
			// get it's index
			int index = customers.indexOf(tempCustomer);
			// read in a new customer and...
			tempCustomer.read();
			// reset the object in customers
			customers.set(index, tempCustomer);
		}
	}

	public void writeRecordsToFile() {
		ToFileManager toFile = new ToFileManager(new serFile());
		toFile.write(customers);
/*		try{
			// Serialize the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(FILENAME);

			ObjectOutputStream os = new ObjectOutputStream(fileStream);

			os.writeObject(customers);

			os.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store customers.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}*/
		
	}

	public void readRecordsFromFile() {
		ToFileManager toFile = new ToFileManager(new serFile());
		customers = toFile.read();
/*		try{
			// Deserialize the ArrayList...
			FileInputStream fis = new FileInputStream(FILENAME);

			ObjectInputStream is = new ObjectInputStream(fis);

			customers = (ArrayList<Customer>)is.readObject();

			is.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot find customers file.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}		*/		
		
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
}