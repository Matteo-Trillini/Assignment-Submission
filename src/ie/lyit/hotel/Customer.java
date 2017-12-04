package ie.lyit.hotel;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Pattern;

import ie.lyit.serialize.CustomerSerializer;

public class Customer extends Person implements Serializable{// INHERITANCE - Customer IS-A Person
	// Customer has name, address, & phoneNumber from Person
	private String emailAddress;    // AND emailAddress
	private int number;			    // AND number
	
	private static int nextNumber=1;// static for unique number - starts off at 1

	// Default Constructor
	// Called when object is created like this ==> 
	//   Customer cObj = new Customer();	
	public Customer(){
		super();			// NOTE:Don't need to call super() explicitly.
		emailAddress=null;
			
		CustomerSerializer cs = new CustomerSerializer();
		cs.readRecordsFromFile();
		if(cs.getMaxNumber()>1)
		{
			number = nextNumber + cs.getMaxNumber();
		}
		else
			number=nextNumber++;
		// Set number to static nextNumber before incrementing nextNumber
		
	}

	// Initialization Constructor
	// Called when object is created like this ==>
	// Customer cObj = new Customer("Mr","Joe","Doe","12 Hi Rd,Letterkenny",
	//                              "0871234567","joe@hotmail.com");
	public Customer(String t, String fN, String sn, String address, String pNo, String email){
		// Call super class constructor - Passing parameters required by Person ONLY!
		super(t, fN, sn, address, pNo);
		// And then initialise Customers own instance variables
		emailAddress=email;
		// And finally set number to static nextNumber before incrementing nextNumber
		CustomerSerializer cs = new CustomerSerializer();
		cs.readRecordsFromFile();
		if(cs.getMaxNumber()>1)
		{
			number = nextNumber + cs.getMaxNumber();
		}
		else
			number=nextNumber++;
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
	public String toString(){
		return super.toString() + "," + emailAddress;
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(c1.equals(c2))				
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj){
		Customer cObject;
		if (obj instanceof Customer)
			cObject = (Customer)obj;
		else
			return false;

		return(this.number==cObject.number);
	}

	// set() and get() methods
	public void setEmailAddress(String emailAddress){
		this.emailAddress=emailAddress;
	}

	public String getEmailAddress(){
		return this.emailAddress;
	}	

	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	public int getNumber(){
		return number;
	}

	public void read() {
		Scanner keyboardIn = new Scanner(System.in);
		String temp = new String("");
		int tempNum = -1;
			
		//Title 
		do 
		{
			System.out.print("Enter Title:-");
			temp = keyboardIn.nextLine();
			if
			(
					!temp.equalsIgnoreCase("Mr") &&
					!temp.equalsIgnoreCase("Mrs") &&
					!temp.equalsIgnoreCase("Ms") &&
					!temp.equalsIgnoreCase("Dr") 
			)
				System.out.println("Valid options are as follows: \n Mrs \n Ms \n Mr \n Dr ");
		}
		while
		(
				!temp.equalsIgnoreCase("Mr") &&
				!temp.equalsIgnoreCase("Mrs") &&
				!temp.equalsIgnoreCase("Ms") &&
				!temp.equalsIgnoreCase("Dr") 	
		);
		this.name.setTitle(temp);

		System.out.print("Enter First Name:-");
		this.name.setFirstName(keyboardIn.nextLine());

		System.out.print("Enter Surname:-");
		this.name.setSurname(keyboardIn.nextLine());

		System.out.print("Enter Address:-");
		this.address=keyboardIn.nextLine();

		//phone Number
		do 
		{
			System.out.print("Enter Phone Number:-");
			temp = keyboardIn.nextLine();
			if (Pattern.matches("[a-zA-Z]+", temp) == false)
			{
			    tempNum = Integer.parseInt(temp); 
			}
			else
				System.out.println("Phone number can only contain numbers");
		}
		while
		(tempNum == -1);
		
		this.phoneNumber=""+tempNum;

		//Email
		do 
		{
			System.out.print("Enter Email Address:-");
			temp = keyboardIn.nextLine();
			if(temp.contains("@"))
				continue;
			else
				System.out.println("Must be a valid Email");
		}
		while(!temp.contains("@"));
		
		this.emailAddress=temp;

	}

	//	public void read(){
	//		JTextField txtNumber = new JTextField();
	//		txtNumber.setText("" + this.getNumber());
	//		JTextField txtFirstName = new JTextField();
	//		txtFirstName.requestFocus();
	//		JTextField txtSurname = new JTextField();
	//		JTextField txtPhoneNumber = new JTextField();
	//		JTextField txtEmail = new JTextField();
	//
	//		Object[] message = {
	//				"Number:", txtNumber,
	//				"First Name:", txtFirstName,
	//				"Surname:", txtSurname,
	//				"Phone Number:", txtPhoneNumber,
	//				"Email Address:", txtEmail,
	//		};
	//
	//		int option = JOptionPane.showConfirmDialog(null, message, "Enter customer details", JOptionPane.OK_CANCEL_OPTION);
	//
	//		if (option == JOptionPane.OK_OPTION){
	//			this.emailAddress = txtEmail.getText();
	//			this.number = txtNumber.getText();
	//		}
}