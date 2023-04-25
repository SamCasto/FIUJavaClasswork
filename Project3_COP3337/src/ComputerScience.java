/*
 * Author: Sam Casto
 * Subclass of major that focuses on a bachelor's in computer science
 */

public class ComputerScience extends Major{
	//instance variables
	private int majorHours; //hours of upper level classes needed
	private String ofSchool; //either a bachelor of arts or of science
	
	//constructor that references major's through super
	public ComputerScience(int upperHours, String ofValue) {
		//hard-coding our values for the super as we know them beforehand
		super("Computer Science",2.5,120,true);
		majorHours = upperHours;
		ofSchool = ofValue;
	}
	//setter methods
	public void setMajorHours(int upperHours) {
		majorHours = upperHours;
	}
	public void setOfSchool(String ofValue) {
		ofSchool = ofValue;
	}
	//getter methods
	public int getMajorHours() {
		return majorHours;
	}
	public String getOfSchool() {
		return ofSchool;
	}
	
	public int getGeneralHours() {
		//returning the amount of general education hours needed to graduate for this degree
		int value = -1; //set to -1 for bug testing
		value = getCreditsNeeded() - getMajorHours();
		return value;
	}
	public String toString() {
		return "The Bachelors " + getOfSchool() + " in " + getMajorName() + " requires " + getMajorHours() + " credit hours of upper"
				+ " level computer science classes with a GPA of " + getMinGPA() + " to graduate. You will be taking" +
				" " + getGeneralHours() + " of general hours to get this degree.";
	}
	
}