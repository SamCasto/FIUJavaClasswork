//Author: Sam Casto
//Concrete class of the carnivore abstract class

public class C_Theropods extends Carnivore {
	//default constructor
	public C_Theropods(String age, double tall, String found, String discoverer, String title) {
		super(2,age,tall,found,discoverer,title);
	}
	
	//to string method
	public String toString() {
		return "The C_Theropods were large carnivores that walked on two legs";
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