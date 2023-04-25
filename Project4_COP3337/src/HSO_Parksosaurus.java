/*
 * Author: Sam Csato
 * Parksosaurus is the concrete class of small ornithopods 
 */

public class HSO_Parksosaurus extends H_SmallOrnithopods {
	//default constructor
	public HSO_Parksosaurus() {
		super("Late Cretaceous",3.0,"Canada","Sternberg","HSO_Parksosaurus");
	}
	
	//to string method
	public String toString() {
		return "The " + getName() + " is a dinosaur from the " + getAge() + " era that stood " + getHeight() + " meters" +
				" tall and was found in " + getLocation() + ", and was discovered by " + getNamedBy() + ".";
	}
}