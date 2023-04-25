/*
 * Author: Sam Casto
 * 
 * Dinosaur tester is the testing class for the dinosaur interface as well as the herbivore/carnivore 
 * abstract classes and the concrete classes that extend from them. This program will have a menu allowing
 * users to print out information about dinosarus and use a compareto method
*/


import java.util.ArrayList;
import java.util.Scanner;



public class DinosaurTester{
	
	public static void main(String[] args) {
		//variables needed for main
		Scanner scnr = new Scanner(System.in);
		String input;
		ArrayList<Dinosaur> list = new ArrayList<Dinosaur>();//main dino list
		int i; //for loop variable
		
		//adding our 8 dinos to the list
		list.add(new HSO_Atlascopcosaurus());
		list.add(new HSO_Parksosaurus());
		list.add(new HAD_Ankylosaurus());
		list.add(new HAD_Stegosaurus());
		list.add(new CT_Achillobator());
		list.add(new CH_Staurikosaurus());
		list.add(new CH_Herrerasaurus());
		list.add(new CT_Sinraptor());
		
		
		
		System.out.println("This is working");
		//main while loop that runs the main menu
		int q = 1;
		while(q != 0) {
			//main menu that will be displayed
			System.out.println("Enter what you would like to do");
			System.out.println("p - Print out information about all dinosaurs");
			System.out.println("c - Print out all dinos height/age/location");
			System.out.println("h - Print out -1,0,1 comparing dino height");
			System.out.println("q - Exit the program");
			//collecting user input on what they want the program to do
			input = scnr.next();
			//using user input to determine what will be done
			if(input.equals("q")) {
				q = 0;
			}
			else if(input.equals("p")) {
				//user wants to print all dino information which will be the to string methods
				for(i =0;i<list.size();i++) {
					System.out.println(list.get(i));
				}
			}
			else if(input.equals("c")) {
				//user wants to look at the catalog of dinosaurs heights/age/locations
				for(i = 0; i < list.size(); i++) {
					System.out.print(list.get(i).dinoAge());
					System.out.print(" ");
					System.out.print(list.get(i).dinoHeight());
					System.out.print(" ");
					System.out.println(list.get(i).dinoLocation());
				}
			}
			else if(input.equals("h")) {
				//user wants to compare height between dinos
				//for loop comparing dino heights 
				for(i=0;i<4;i++) {
					if(i==3) {
						System.out.println(((Herbivore) list.get(i)).compareTo((Herbivore) list.get(0)));
					}
					else {
					System.out.println(((Herbivore) list.get(i)).compareTo((Herbivore) list.get(i+1)));
					}
				}
				for(i=4;i<8;i++) {
					if(i==7) {
						System.out.println(((Carnivore) list.get(i)).compareTo((Carnivore) list.get(4)));
					}
					else {
					System.out.println(((Carnivore) list.get(i)).compareTo((Carnivore) list.get(i+1)));
					}
				}
			}
		}//end of while loop
		//closing the scanner
		scnr.close();
	}//end of main method
	
}
