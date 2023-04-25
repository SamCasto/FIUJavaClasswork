/*
 * Author: Sam Casto
 * Version: 1
 * Major holds our parent constructor and all variables/methods that are associated 
 * with it that the child classes will use
 */

public class Major{
	//need at least three attributes/variables for our subclasses to inherit
	private String majorName;
	private double minGPA;
	private int minCreditsNeeded;
	private boolean online; //if a course can be taken fully online
	
	//constructor
	public Major(String name, double GPA, int neededCredits, boolean value) {
		majorName = name;
		minGPA = GPA;
		minCreditsNeeded = neededCredits;
		online = value;
	}
	
	//setter methods
	public void setMajorName(String newName) {
		majorName = newName;
	}
	public void setMinGPA(double newGPA) {
		minGPA = newGPA;
	}
	public void setCreditsNeeded(int newCredits) {
		minCreditsNeeded = newCredits;
	}
	public void setOnline(boolean value) {
		online = value;
	}
	//getter methods
	public String getMajorName() {
		return majorName;
	}
	public double getMinGPA() {
		return minGPA;
	}
	public int getCreditsNeeded() {
		return minCreditsNeeded;
	}
	public boolean getOnline() {
		return online;
	}
	//space for extra methods as needed
	public String toString() {
		return "The major of " + getMajorName() + " requires " + getCreditsNeeded() + " credit hours"
				+ " completed with a " + getMinGPA() + " minimum GPA required to graduate.";
	}
	public String printIfOnline() {
		if(getOnline()) {
			return "The " + getMajorName() + " degree is offered online.";
		}
		else {
			return "The " + getMajorName() + " degree is not offered online.";
		}
	}
	//overriding equals method
	@Override
	public boolean equals(Object other) {
		//comparing if the amount of credits between two majors are the same
		if(this.getCreditsNeeded() == ((Major) other).getCreditsNeeded()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
}
