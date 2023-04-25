/* Author: Sam Casto

 * Version: 1
 * Main tester for our parent major class where we will add our objects to an arraylist and check 
 * to make sure our toString methods are working, equals is being overridden, and that the code compiles
 */
import java.util.ArrayList;

public class MajorTester {
	
	public static void main(String[] args) {
		//declaring our arraylist
		ArrayList<Object> list = new ArrayList<Object>();
		//adding our objects into the arraylist
		list.add(new Major("Chemistry",3.0,128,false));
		list.add(new ComputerScience(60,"of Arts"));
		list.add(new AthleticTraining(75));
		list.add(new Art(60,false));
		list.add(new DigitalArt(2.75));
		
		
		//main loop
		for (int i = 0; i < list.size(); i++){
			//outputting our information from our objects
			//overridden toString methods being called
			System.out.println(list.get(i));
			//overridden equal methods being called
			if(i == (list.size() - 1)) {
				//last object so we need to compare it to a different one than i + 1
				System.out.println("Does a degree in " + ((Major) list.get(i)).getMajorName() + " require the same " +
						"amount of credits as " + ((Major) list.get(0)).getMajorName() + "?");
				System.out.println(list.get(i).equals(list.get(0)));
			}
			else {
				System.out.println("Does a degree in " + ((Major) list.get(i)).getMajorName() + " require the same " +
						"amount of credits as " + ((Major) list.get(i+1)).getMajorName() + "?");
				System.out.println(list.get(i).equals(list.get(i + 1)));
				
			}
			
			
		}//end of the main loop
		
		
	}
}