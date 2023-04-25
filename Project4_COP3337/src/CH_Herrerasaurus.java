//Author: Sam Casto
//Herrerasaurus is a concrete class that extends herrerasauridae

public class CH_Herrerasaurus extends C_Herrerasauridae {
	//default constructor
	public CH_Herrerasaurus() {
		super(2,"Late Triassic",3.0,"Argentina","Reig","CH_Herrerasaurus");
	}
	//to string method
	public String toString() {
		return "The " + getName() + " is a dinosaur from the " + getAge() + " era that stood " + getHeight() + " meters" +
				" tall and was found in " + getLocation() + ", and was discovered by " + getNamedBy() + ".";
	}
}