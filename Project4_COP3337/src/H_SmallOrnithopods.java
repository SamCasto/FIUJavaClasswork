/*
 * Author: Sam Casto
 * Small ornithopods is one of our classes that is a direct child of herbivore
 */

public class H_SmallOrnithopods extends Herbivore {
	//default constructor for small ornithopods
	public H_SmallOrnithopods(String age, double tall, String found, String discoverer, String title) {
		//invoking herbivore's constructor
		super(2,age,tall,found,discoverer,title);
	}
	//to string method
	public String toString() {
		return "Small ornithopods are small herbivores that walked on two legs";
	}
	//methods from dinosaur
	public String dinoHeight() {
		return "The " + getName() + " was " + getHeight() + " meters tall!";
	}
	public String dinoLocation() {
		return "The " + getName() + " was found in " + getLocation() + "!";
	}
	public String dinoAge() {
		return "The " + getName() +" was from the " + getAge() + " period!";
	}
}