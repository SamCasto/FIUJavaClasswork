/*
	Author: Sam Casto
	Version: 1
	
*/
//importing our needed classes
import java.io.FileReader;
import java.util.Scanner;

public class trebuchetTester {
	
	
	public static void main(String[] args) throws Exception {
		int stop = 0; //numb is to hold values when needed
		
		//creating our trebuchet object
		trebuchet Trebuchet = new trebuchet();
		//defining our scanner to read from the input file
		Scanner scnr = new Scanner(new FileReader("C:\\Users\\samue\\eclipse-workspace\\Project2_COP3337\\src\\inputs.txt"));
		
		//grabbing our number of sets outside our main loop
		Trebuchet.setSets(scnr.nextInt());
		//Trebuchet.setSets(1);
		//main loop that will get whole sets of data, and call proper methods to print
		for(stop = 0; stop < Trebuchet.getSets(); stop++){
			//reading the file and assigning the variables using trebuchet methods
			Trebuchet.setValues(scnr);
			//after setValues, we have scanned all information needed to output one table
			//so here we would need to call our calculation methods
			
			//and then here we need to print the table
			Trebuchet.printTable();
			//and after printing the table we should loop back around and input the next set of data
		}
		
		
		
	}
}