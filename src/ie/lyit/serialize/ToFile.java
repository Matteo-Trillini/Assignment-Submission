package ie.lyit.serialize;

import java.util.ArrayList;
import ie.lyit.hotel.Customer;

public interface ToFile {
	public ArrayList<Customer> readRecordsFromFile();
	public void writeRecordsToFile(ArrayList<Customer> customers);
}
