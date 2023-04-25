/*
 * Author: Sam Casto
 * Subclass of major that focuses on a degree in Art from FIU 
 */
public class Art extends Major{
	//instance variables
	private int majorHours;
	private boolean fineArts; //if the degree is a fine art degree or not
	
	
	//constructor that references major's constructor
	public Art(int upperHours, boolean value) {
		super("Art",2.5,120,true);
		majorHours = upperHours;
		fineArts = value;
	}
	//setter methods
	public void setMajorHours(int upperHours) {
		majorHours = upperHours;
	}
	public void setFineArts(boolean value) {
		fineArts = value;
	}
	//getter methods
	public int getMajorHours() {
		return majorHours;
	}
	public boolean getFineArts() {
		return fineArts;
	}
	public int getGeneralHours() {
		//returning the amount of general education hours needed to graduate for this degree
		int value = -1; //set to -1 for bug testing
		value = getCreditsNeeded() - getMajorHours();
		return value;
	}
	public String isFineArts() {
		if(getFineArts()) {
			return "The "+ getMajorName() + " degree is a fine arts degree";
		}
		else {
			return "The "+ getMajorName() + " degree is not a fine arts degree";
		}
		
	}
	public String toString() {
		return "The Bachelors of " + getMajorName() + " requires a " + getMinGPA() + " GPA and for you to take " +
				getCreditsNeeded() + " total hours with " + getMajorHours() + " of those hours being upper level art " +
				"classes to graduate. You will be taking " + getGeneralHours() + " of general hours to get this degree.";
	}
}