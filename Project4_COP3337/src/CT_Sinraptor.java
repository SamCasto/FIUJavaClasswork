//Author: Sam Casto
//Sinraptor is a concrete class that extends theropods

public class CT_Sinraptor extends C_Theropods {
	//default constructor
	public CT_Sinraptor() {
		super("Mid Jurassic",7.6,"China","Gao","CT_Sinraptor");
	}
	//to string method
	public String toString() {
		return "The " + getName() + " is a dinosaur from the " + getAge() + " era that stood " + getHeight() + " meters" +
				" tall and was found in " + getLocation() + ", and was discovered by " + getNamedBy() + ".";
	}
}