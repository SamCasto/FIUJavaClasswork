/*
 * Author: Samuel Casto
 * Version: 1 Date: 6/25/22
 * Language: Java
 * Description: A book library with a menu offering choices to the user of
 * 				adding a new book, updating a current book in the catalog,
 * 				listing the books in the catalog, and printing specific information
 * 				about a book from the catalog until the user is ready to exit the program.
 */

//importing the array list/scanner
import java.util.ArrayList;
import java.util.Scanner;

public class BookObjTester {
	
	//coming from Python I really need this personally
	public static void print(String statement) {
		System.out.println(statement);
	}

	public static void main(String[] args) {
		//variable declaration with default values
		int numb = 0; //holds numbers
		int index = 0; //for keeping track of which book we have added
		int i = 1; //for loop number
		
		//scanner declaration to accept user input
		Scanner scnr = new Scanner(System.in);
		String input = ""; //string for user input
		
		//creating book arraylist(need 6 books)
		ArrayList<BookObj> library = new ArrayList<BookObj>();
		//format for adding is title, author, edition, genre, publisher, 
		//numPages, and pagesRead
		library.add(new BookObj("The Mysterious Affair at Styles","Agatha Christie",2,"Mystery","HarperCollins",258,0));
		library.add(new BookObj("Essays of E.B. White","E.B. White",2,"Satire","HarperPerennial",364,0));
		library.add(new BookObj("Chess Fundamentals","Jose Raul Capablanca",2,"Chess","SDE Publishing",128,0));
		library.add(new BookObj("The Basis of Combination in Chess","J. du Mont",1,"Chess","Dover Publications Inc.",218,0));
		library.add(new BookObj("Weapons of Chess","Bruce Pandolfini",1,"Chess","Simon & Schuster Inc.",287,0));
		library.add(new BookObj("Art of Attack in Chess","Vladimir Vukovic",1,"Chess","Everyman Publishers plc",352,0));
		
		//main loop of program
		for(i = 1; i > 0; i++) {
			print("Please enter the letter that corresponds to what you would like to do");
			print("A - Adds a new book");
			//catalog number is index + 1
			print("U - Update a current book by catalog number");
			print("C - Print out book catalog");
			print("P - Print out a particular book's information");
			print("Q - Exits the program");
			
			
			//taking user input to decide what our program will do
			input = scnr.nextLine();
			
			//evaluating input against menu options
			if(input.equals("A")) {
				//user wants to add a new book(7 fields)
				print("You will be adding a new book to the catalog.");
				
				//asking the user to input the title field
				print("What is the title?");
				input = scnr.nextLine();
				
				//creating our new book object with just the title
				library.add(new BookObj(input));
				
				//keeping track of which book it is based on index
				index = library.size() - 1;
				
				//asking for the author
				print("Who is it by?");
				input = scnr.nextLine();
				//assigning the author to our new book we have created
				library.get(index).setAuthor(input);
				
				print("What edition is it?");
				numb = scnr.nextInt();
				library.get(index).setEdition(numb);
				
				//clearing the scanner because it breaks here for some reason
				scnr.nextLine();
				
				print("Who published it?");
				input = scnr.nextLine();
				library.get(index).setPublisher(input);
				
				print("How many pages are there?");
				numb = scnr.nextInt();
				library.get(index).setNumPages(numb);
				
				print("How many pages have you read?");
				numb = scnr.nextInt();
				library.get(index).setPagesRead(numb);
				
				print("All done!");
				
			}//end of add option
			
			else if(input.equals("U")) {
				//user wants to update a book using the catalog number(index + 1)
				print("Which book would you like to update?");
				
				//getting book catalog number
				index = scnr.nextInt();
				
				//converting it to index instead
				index = index - 1;
				
				//asking for what specifically the user would like to update
				print("What would you like to update?");
				print("t - Title");
				print("a - Author");
				print("x - A new edition was released");
				print("e - Edition number");
				print("p - Publisher information");
				print("n - Number of pages");
				print("r - Number of read pages");
				
				//clearing the scanner
				scnr.nextLine();
				
				//assigning user input to input 
				input = scnr.nextLine();
				
				//logic for selecting what to update based on input
				if(input.equals("t")) {
					//asking for title and assigning updated title to the correct indexed book
					print("What is the updated title?");
					input = scnr.nextLine();
					library.get(index).setTitle(input);
				}
				else if(input.equals("a")) {
					print("Who is the updated author?");
					input = scnr.nextLine();
					library.get(index).setAuthor(input);
				}
				else if(input.equals("e")) {
					print("What is the updated edition?");
					numb = scnr.nextInt();
					library.get(index).setEdition(numb);;
				}
				else if(input.equals("p")) {
					print("Who is the updated publisher?");
					input = scnr.nextLine();
					library.get(index).setPublisher(input);
				}
				else if(input.equals("n")) {
					print("What is the updated number of pages?");
					numb = scnr.nextInt();
					library.get(index).setNumPages(numb);
				}
				else if(input.equals("r")) {
					print("How many pages have you read?");
					numb = scnr.nextInt();
					library.get(index).updatePagesRead(numb);
				}
				else if(input.equals("x")) {
					library.get(index).newEdition();
				}
				else print("Invalid selection. Returning to main menu");
			}//end of update option
			
			else if(input.equals("C")) {
				//user wants to print out our catalog of books
				for(i = 0; i < library.size(); i++) {
					print((i + 1) + ": " + library.get(i).getTitle() + " by " + library.get(i).getAuthor());
				}
			}//end of catalog option
			
			else if(input.equals("P")) {
				//user wants to print something specific out about a book
				//we will be using the index/catalog number trick again
				print("Which book's information would you like to print?");
				//getting book catalog number
				index = scnr.nextInt();
				//converting it to index instead
				index = index - 1;
				
				//clearing scanner
				scnr.nextLine();
				
				//presenting the same options as update but with our extra methods too
				print("What information would you like to print?");
				print("t - Title");
				print("a - Author");
				print("e - Edition number");
				print("p - Publisher information");
				print("n - Number of pages");
				print("r - Number of read pages");
				print("l - Number of pages left");
				print("z - Everything");
				
				//assigning user input to input
				input = scnr.nextLine();
				
				//logic based off input
				if(input.equals("t")) {
					print(library.get(index).getTitle());
				}
				else if(input.equals("a")) {
					print(library.get(index).getAuthor());
				}
				else if(input.equals("e")) {
					print(Integer.toString(library.get(index).getEdition()));
				}
				else if(input.equals("p")) {
					print(library.get(index).getPublisher());
				}
				else if(input.equals("n")) {
					print(Integer.toString(library.get(index).getNumPages()));
				}
				else if(input.equals("r")) {
					print(Integer.toString(library.get(index).getPagesRead()));
				}
				else if(input.equals("l")) {
					print(Integer.toString(library.get(index).getPagesLeft()));
				}
				else if(input.equals("z")) {
					print(library.get(index).getTitle() + " by " + library.get(index).getAuthor() + ", edition "
							+ Integer.toString(library.get(index).getEdition()) + ", published by "
							+ library.get(index).getPublisher() + " having " + Integer.toString(library.get(index).getNumPages())
							+ " pages total with " + Integer.toString(library.get(index).getPagesRead()) + " read leaving " 
							+ Integer.toString((library.get(index).getPagesLeft())) + " left to read." );
				}
				else print("Invalid selection. Returning to main menu");
			}//end of print option
			
			else if(input.equals("Q")) {
				//user wants to exit the program
				i = -1;
			}//end of exit option
			
			//user has not entered a valid option
			else print("Invalid input");
		}//end of for loop

	}//end of main

}//end of objtester
