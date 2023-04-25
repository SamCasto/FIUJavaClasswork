/*
 * Author: Sam Casto
 */
public class DigitalArt extends Art {
	//instance variables
	private double foundationGPA; //gpa required for bachelor of fine arts digital art(studio)
	
	//constructor that references art's constructor
	public DigitalArt(double gpa) {
		super(60,true);
		foundationGPA = gpa;
		setOnline(false);
		setMajorName("Digital Arts");
	}
	
	//setter methods
	public void setFoundationGPA(double gpa) {
		foundationGPA = gpa;
	}
	
	//getter methods
	public double getFoundationGPA() {
		return foundationGPA;
	}
	
	//extra methods
	public String toString() {
		return "The Bachelor of Fine Arts in " + getMajorName() + " requires " + getCreditsNeeded() + " credit hours " +
				"with " + getMajorHours() + " being upper level art classes with a GPA of " + getMinGPA() + " to graduate. " +
				"You will be taking " + getGeneralHours() + " of general hours to get this degree." +
				"However to get into this program you need an art foundation GPA of " + getFoundationGPA()+ ".";
	}
	
	
}