import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*Author: Sam Casto
 * Version: 1
 * Trebuchet will define our trebuchet methods needed to input values from the file
 * as well as calculate our acceptable output values and we should probably format the 
 * output here as well so main is not cluttered
*/

public class trebuchet {
	//variables needed for file input/calculations
	//how many times to loop our input method
	private int numOfSets;
	//how many times to loop our speed input method
	private int numOfSpeeds;
	//how many times to loop our angle input method
	private int numOfAngles;
	//array to hold our speed values
	private int[] speedArray;
	//array to hold our angle values
	private int[] angleArray;
	private int min;
	private int max;
	//we will have to use a 2d array somehow
	private int[][] comboArray;
	//will hold our calculated result before being printed and replaced
	private double result;
	
	//default constructor
	public void Trebuchet() {
		numOfSets = 0;
		numOfSpeeds = 0;
		numOfAngles = 0;
		
	}
	//getter methods
	public double getResult() {
		return result;
	}
	public int getSets() {
		return numOfSets;
	}
	public int getNumSpeeds() {
		return numOfSpeeds;
	}
	public int getNumAngles() {
		return numOfAngles;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public int getSpeedArrayAt(int index) {
		return speedArray[index];
	}
	public int getAngleArrayAt(int index) {
		return angleArray[index];
	}
	//setter methods
	public void setSets(int sets) {
		numOfSets = sets;
	}
	
	public void setNumSpeeds(int speeds) {
		numOfSpeeds = speeds;
	}
	
	public void setNumAngles(int angles) {
		numOfAngles = angles;
	}
	
	public void setMin(int newMin) {
		min = newMin;
	}
	
	public void setMax(int newMax) {
		max = newMax;
	}
	public void setResult(double newResult) {
		result = newResult;
	}
	//checks our results against min max to see if it result should be added to bestResult
	public Boolean checkResult(double newResult) {
		boolean result = false;
		if((getResult() >= min) && (getResult() <= max)) {
			result = true;
			return result;
		}
		return result;
	}
	//calculating our result from launch speed and launch angle
	public void mathResult(int row, int column) {
		double launchSpeed;
		double launchAngle;
		double result;
		//looks like we are going to use this to perform our calculations for the distance
		//based on the launch speed(row) and launch angle(column)
		launchSpeed = comboArray[row][0];
		launchAngle = comboArray[row][column];
		//doubling launch speed and converting launch angle to radians
		launchSpeed = launchSpeed * launchSpeed;
		launchAngle = Math.toRadians(launchAngle);
		//performing sin function and launchAngle*2
		launchAngle = Math.sin(launchAngle * 2);
		//assuming launchSpeed is in m/s originally
		result = (launchSpeed * launchAngle)/9.8;
		setResult(result);
		
		
		//our formula is roughly (row^2) * sin(2 * column(in radians))
		//divided by a gravitational constant(9.81 m/s^2)
	}
	public void combineArrays() {
		//declaring the actual array and using angleArray + 1 to account for the first column
		//being a speed value
		comboArray = new int[speedArray.length][angleArray.length + 1];
		//adding the speed and angle values into combo array by filling each row first
		int i = 0;//i will be for rows
		int j = 0;//j will be for columns
		for(i=0;i < speedArray.length;i++) {
			//we are in the first row only so our column index will always be 0
			comboArray[i][0] = speedArray[i];
			//looping through the rest of the row starting from j = 1 because j = 0 is a speed value
			for(j=1;j < angleArray.length + 1 ;j++) {
				comboArray[i][j] = angleArray[j - 1];
			}
		}
		
		//verified above is working
		
	}
	public void setValues(Scanner scnr) {
		//we will be reading the file here and using the setter methods inside here as well
		int i = 0; //for for loops
		//next int will be the numOfSpeeds for this set
		setNumSpeeds(scnr.nextInt());
		speedArray = new int[numOfSpeeds];
		//using numOfSpeeds we need to loop the values into the speedArray
		for(i = 0; i < numOfSpeeds; i++) {
			speedArray[i] = scnr.nextInt();
		}
		setNumAngles(scnr.nextInt());
		angleArray = new int[numOfAngles];
		//using numOfAngles to loop the correct numb of values into angleArray
		for(i = 0; i < numOfAngles; i++) {
			angleArray[i] = scnr.nextInt();
		}
		//last two values for this set are the min/max
		setMin(scnr.nextInt());
		setMax(scnr.nextInt());
		//we have all our values so let's combine our arrays
		combineArrays();
	}
	
	//print method for the table
	public void printTable() {
		int i = 0;//for loop variable
		int j = 0;//for loop variable
		//printing the top part of the table
		System.out.println("	Projectile Table");
		System.out.println("---------------------------------");
		//printing the top of our table
		for(j=0;j<comboArray[i].length;j++) {
			//printing the top of our table with Speed and the degree values
			//instance for when j = 0 and we need to print speed first
			if(j==0) {
				System.out.print("Speed      ");
			}
			else {
				System.out.printf("%3d Deg      ", comboArray[i][j]);
			}
		}
		//adding a line after our first row
		System.out.println();
		//this currently works at printing our inside rows where j > 0
		// now we just need to format it
		for(i=0;i<comboArray.length;i++) {
			j = 0;
			//prints out our speed value in the first column
			System.out.printf(" %3d      ",comboArray[i][j]);
			for(j=1;j<comboArray[i].length;j++) {
				//call math result with our current launch speed(row)
				//and our current launch angle(column)
				mathResult(i,j);
				//printing the result from the calculations
				System.out.printf("%8.3f     ",getResult());
				
			}
			System.out.println();
		}
		
		System.out.println("---------------------------------");
		System.out.println("Best trajectory values");
		//print out acceptable values
		//checking to see if i, j will get printed to best results
		for(i=0;i<comboArray.length;i++) {
			for(j=1;j<comboArray[i].length;j++) {
				//call math result with our current launch speed(row)
				//and our current launch angle(column)
				mathResult(i,j);
				//printing the result from the calculations
				if(checkResult(getResult())) {
					System.out.printf("%d m/s and %d deg; ",speedArray[i],angleArray[j-1]);
				}
			}
			
		}
		System.out.println();
		
		System.out.println("---------------------------------");
	
	}
}