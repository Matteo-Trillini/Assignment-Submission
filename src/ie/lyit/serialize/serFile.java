package ie.lyit.serialize;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import ie.lyit.hotel.Customer;

public class serFile implements ToFile {

	final String FILENAME = "customers.ser";
	int maxNumber = 0;



	@Override
	public ArrayList<Customer> readRecordsFromFile() {
		try {
			
			ArrayList<Customer> customers = new ArrayList<Customer>();

			FileInputStream fis = new FileInputStream(FILENAME);

			ObjectInputStream is = new ObjectInputStream(fis);

			customers = (ArrayList<Customer>) is.readObject();

			is.close();
			
			for (int i = 0; i < customers.size(); i++) {
				if (customers.get(i).getNumber() > maxNumber) {
					maxNumber = customers.get(i).getNumber();
				}
			}
			return customers;
		} catch (FileNotFoundException fNFE) {
			System.out.println("Cannot find customers file.");
			ArrayList<Customer> customers = new ArrayList<Customer>();
			return customers;
		} catch (Exception e) {
			System.out.println("Exception Message: "+e.getMessage());
			ArrayList<Customer> customers = new ArrayList<Customer>();
			return customers;
		}

	}

	@Override
	public void writeRecordsToFile(ArrayList<Customer> customers) {
		try {

			// Deserialize the ArrayList...
			FileInputStream fis = new FileInputStream(FILENAME);

			ObjectInputStream is = new ObjectInputStream(fis);

			customers = (ArrayList<Customer>) is.readObject();

			is.close();

			for (int i = 0; i < customers.size(); i++) {
				if (customers.get(i).getNumber() > maxNumber) {
					maxNumber = customers.get(i).getNumber();
				}
			}
		} catch (FileNotFoundException fNFE) {
			System.out.println("Cannot find customers file.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
