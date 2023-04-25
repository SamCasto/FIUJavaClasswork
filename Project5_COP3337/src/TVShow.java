//Author: Samuel Casto

public class TVShow {
	//variables needed for TVShow
	private String name;
	private int yearPremiered;
	private int numOfSeasons;
	private int numOfEpisodes;
	private String network;
	private String genre;
	private String maleLead;
	private String femaleLead;
	
	//default constructor
	public TVShow() {
		
	}
	
	//setter methods
	public void setName(String value) {
		name = value;
	}
	public void setYearPremiered(int value) {
		yearPremiered = value;
	}
	public void setNumOfSeasons(int value) {
		numOfSeasons = value;
	}
	public void setNumOfEpisodes(int value) {
		numOfEpisodes = value;
	}
	public void setNetwork(String value) {
		network = value;
	}
	public void setGenre(String value) {
		genre = value;
	}
	public void setMaleLead(String value) {
		maleLead = value;
	}
	public void setFemaleLead(String value) {
		femaleLead = value;
	}
	//getter methods
	public String getName( ) {
		return name;
	}
	public int getYearPremiered( ) {
		return yearPremiered;
	}
	public int getNumOfSeasons( ) {
		return numOfSeasons;
	}
	public int getNumOfEpisodes( ) {
		return numOfEpisodes;
	}
	public String getNetwork( ) {
		return network;
	}
	public String getGenre( ) {
		return genre;
	}
	public String getMaleLead( ) {
		return maleLead;
	}
	public String getFemaleLead( ) {
		return femaleLead;
	}
	
	//toString method
	public String toString() {
		return "The TV Show " + getName() + " first aired in " + getYearPremiered() + " and ran for " +
				getNumOfSeasons() + " seasons with " + getNumOfEpisodes() + " episodes on the " + getNetwork() +
				" network. The show's genre was " + getGenre() + " with the male lead being " + getMaleLead() + 
				" and the female lead being " + getFemaleLead() + ".";
	}
	
	

	
    
	
}