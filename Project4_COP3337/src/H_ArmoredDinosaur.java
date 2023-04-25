/*
 * Author: Sam Casto
 * Second herbivore concrete class of the armored dinosaur variety
 */

public class H_ArmoredDinosaur extends Herbivore {
	
	//default constructor
	public H_ArmoredDinosaur(String age, double tall, String found, String discoverer, String title) {
		super(4,age,tall,found,discoverer,title);
	}
	//to string method
	public String toString() {
		return "Armored dinosaurs are dinosaurs generally are medium-sized, four-legged herbivores with body armour, sometimes including tail spikes.";
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