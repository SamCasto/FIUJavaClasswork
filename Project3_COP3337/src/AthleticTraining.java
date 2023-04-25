/*
 * Author: Sam Casto
 * Subclass of major related to an athletic training degree
 */

public class AthleticTraining extends Major {
	//instance variables
	private int majorHours;
	
	
	//constructor that references major's constructor
	public AthleticTraining(int upperHours) {
		super("Athletic Training",3,150,false);
		majorHours = upperHours;
	}
	//setter methods
	public void setMajorHours(int upperHours) {
		majorHours = upperHours;
	}
	//getter methods
	public int getMajorHours() {
		return majorHours;
	}
	public int getGeneralHours() {
		//returning the amount of general education hours needed to graduate for this degree
		int value = -1; //set to -1 for bug testing
		value = getCreditsNeeded() - getMajorHours();
		return value;
	}
	public String toString() {
		return "The Masters of " + getMajorName() + " requires a total of " + getCreditsNeeded() + " credit hours " +
				"with " + getMajorHours() + " of those being upper level classes and a GPA of " + getMinGPA() + 
				". You will be taking" + getGeneralHours() + " of general hours to get this degree.";
	}
}