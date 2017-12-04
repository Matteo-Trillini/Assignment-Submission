package ie.lyit.hotel;

import javax.swing.JOptionPane;
		 
public class IntToString{
   public static void main(String[] args){
      String numberAsString = JOptionPane.showInputDialog(null, "Enter an integer");
			      
      // Attempt to convert the String to an Int
      int number = Integer.parseInt(numberAsString);
      System.out.println("Conversion was successful!\n" + "The integer entered is " + number + ".");
   }
}