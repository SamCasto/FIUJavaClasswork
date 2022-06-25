/*
 * Author: Samuel Casto
 * Version: 1
 * BookObj will contain all of the instance variables and getter/setter 
 * methods needed for our book objects
 */

public class BookObj {
	//private instance variables (need 6, with 2 ints)
	private String title;
	private String author;
	private int edition;
	private String genre;
	private String publisher;
	private int numPages;
	private int pagesRead;
	
	//default constructor for a BookObj
	public BookObj(String newTitle) {
		title = newTitle;
		author = "";
		edition = -1;
		genre = "";
		publisher = "";
		numPages = -1;
		pagesRead = -1;
	}
	//constructor for a BookObj
	public BookObj(String newTitle, String newAuthor, int newEdition, String newGenre, String newPublisher, int newNumPages, int newPagesRead) {
		title = newTitle;
		author = newAuthor;
		edition = newEdition;
		genre = newGenre;
		publisher = newPublisher;
		numPages = newNumPages;
		pagesRead = newPagesRead;
		
	}//end of BookObj constructor
	
	//setter methods
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	public void setAuthor(String newAuthor) {
		author = newAuthor;
	}
	
	public void setEdition(int newEdition) {
		edition = newEdition;
	}
	
	public void setGenre(String newGenre) {
		genre = newGenre;
	}
	
	public void setPublisher(String newPublisher) {
		publisher = newPublisher;
	}
	
	public void setNumPages(int newNumPages) {
		numPages = newNumPages;
	}
	
	public void setPagesRead(int newPagesRead) {
		pagesRead = newPagesRead;
	}
	
	//calculation setter methods
	public void updatePagesRead(int numPages) {
		pagesRead = pagesRead + numPages;
	}
	
	public void newEdition() {
		edition++;
	}
	
	//getter methods
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getEdition() {
		return edition;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public int getNumPages() {
		return numPages;
	}
	
	public int getPagesRead() {
		return pagesRead;
	}
	
	public int getPagesLeft() {
		return numPages - pagesRead;
	}
	
}//end of public class

