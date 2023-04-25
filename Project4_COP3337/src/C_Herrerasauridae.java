//Author: Sam Casto
//Concrete class of the carnivore abstract class

public class C_Herrerasauridae extends Carnivore {
	//default constructor
	public C_Herrerasauridae(int legs,String age, double tall, String found, String discoverer, String title) {
		super(legs,age,tall,found,discoverer,title);
	}
	
	//to string method
	public String toString() {
		return "Herrerasauridae were small, primitive carnivores that walked on two legs.";
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