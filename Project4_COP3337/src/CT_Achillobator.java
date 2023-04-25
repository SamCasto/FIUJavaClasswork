//Author: Sam Casto
//Achillobater is a concrete class that extends theropods

public class CT_Achillobator extends C_Theropods {
	//default constructor
	public CT_Achillobator() {
		super("Late Cretaceous",5.0,"Mongolia","Perle, Norell and Clark","CT_Achillobator");
	}
	//to string method
	public String toString() {
		return "The " + getName() + " is a dinosaur from the " + getAge() + " era that stood " + getHeight() + " meters" +
				" tall and was found in " + getLocation() + ", and was discovered by " + getNamedBy() + ".";
	}
}