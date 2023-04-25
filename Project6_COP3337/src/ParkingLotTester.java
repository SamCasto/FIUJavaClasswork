
/*
 * Author: Sam Casto
 * 
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class ParkingLotTester {
	
	
	public static void main(String[] args){
		//generating random decal types
		//our decal types will be the numbers one through three
		Random rand = new Random();
		String input = "";
		int value;
		//declaring our stack for parking lot
		Stack<Car> parkingLot = new Stack<>();
		int decalType = rand.nextInt(3) + 1;
		int stackMax = 15;
		//decalring our stack for the street
		Stack<Car> street = new Stack<>();
		//Queue for cars waiting to park
		Queue<Car> waiting = new LinkedList<>();
		//scanner object for user inptu
		Scanner scnr = new Scanner(System.in);
		//rand statement is rand.nextInt(3) + 1
		//populating the parking lot with 10 cars
		Car car1 = new Car(rand.nextInt(3) + 1,12345);
		Car car2 = new Car(rand.nextInt(3) + 1, 45656);
		Car car3 = new Car(rand.nextInt(3) + 1, 78956);
		Car car4 = new Car(rand.nextInt(3) + 1, 23456);
		Car car5 = new Car(rand.nextInt(3) + 1, 34556);
		Car car6 = new Car(rand.nextInt(3) + 1, 45656);
		Car car7 = new Car(rand.nextInt(3) + 1, 56756);
		Car car8 = new Car(rand.nextInt(3) + 1, 67856);
		Car car9 = new Car(rand.nextInt(3) + 1, 78956);
		Car car10 = new Car(rand.nextInt(3) + 1, 12056);
		
		//adding them to the parking lot
		parkingLot.push(car1);
		parkingLot.push(car2);
		parkingLot.push(car3);
		parkingLot.push(car4);
		parkingLot.push(car5);
		parkingLot.push(car6);
		parkingLot.push(car7);
		parkingLot.push(car8);
		parkingLot.push(car9);
		parkingLot.push(car10);
		
		int go = 1;
		while (go > 0 ) {
			System.out.println("Please enter the letter that corresponds to what you would like to do");
			System.out.println("p - Try to park a car");
			System.out.println("a - Add a car");
			System.out.println("q - Exits the program");
			
			input = scnr.next();
			
			if(input.equals("q")) {
				go = 0;
			}
			else if(input.equals("a")) {
				//user wants to add a car
				System.out.println("What is the license plate for the car?");
				value = scnr.nextInt();
				//creating the car object
				
			}
			else if(input.equals("p")) {
				//user wants to try and park a car
				
				//we will need to check if there is space and if the car has the right decal somehow
				if(parkingLot.size() < 15) {
					
				}
			}
		}//end of while loop
	
			
			
		
		
	}

	
}