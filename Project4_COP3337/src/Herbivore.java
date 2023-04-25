/*
 * Author: Sam Casto
 * Herbivore is an abstract class that implements the dinosaur interface and holds methods related to herbivores
*/

abstract class Herbivore implements Dinosaur {
	//instance variables for all herbivores
	private int walkingLegs;
	private String age;
	private double height;
	private String location;
	private String namedBy;
	private String name;
	
	//default constructor
	public Herbivore(int legs, String time, double tall, String found, String discoverer, String title) {
		walkingLegs = legs;
		age = time;
		height = tall;
		location = found;
		namedBy = discoverer;
		name = title;
	}
	//setter methods
	public void setWalkingLegs(int legs) {
		walkingLegs = legs;
	}
	public void setAge(String time) {
		age = time;
	}
	public void setHeight(double tall) {
		height = tall;
	}
	public void setLocation(String found) {
		location = found;
	}
	public void setNamedBy(String discoverer) {
		namedBy = discoverer;
	}
	public void setName(String title) {
		name = title;
	}
	//getter methods
	public int getWalkingLegs() {
		return walkingLegs;
	}
	public String getAge() {
		return age;
	}
	public double getHeight() {
		return height;
	}
	public String getLocation() {
		return location;
	}
	public String getNamedBy() {
		return namedBy;
	}
	public String getName() {
		return name;
	}
	//needs a compare to method
	public int compareTo(Herbivore obj) {
		if(this.height < obj.height) {
			return -1;
		}
		else if(this.height > obj.height) {
			return 1;
		}
		else return 0;
	}
}