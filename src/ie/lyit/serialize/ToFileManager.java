package ie.lyit.serialize;

import java.util.ArrayList;

import ie.lyit.hotel.Customer;

public class ToFileManager {
	private ToFile toFile;
	
	public ToFileManager(ToFile toFile)
	{
		this.toFile = toFile;
	}
	public ArrayList<Customer> read() {
		ArrayList<Customer> customers = this.toFile.readRecordsFromFile();
		return customers;
	}
	public void write(ArrayList<Customer> customers) {
		this.toFile.writeRecordsToFile(customers);
	}

}
