package ie.lyit.serialize;

import ie.lyit.hotel.Customer;

public interface CustomerDAO {
	public void delete();
	public void add();
	public void list();
	public Customer view();
	public void readRecordsFromFile();
	public void writeRecordsToFile();

}
