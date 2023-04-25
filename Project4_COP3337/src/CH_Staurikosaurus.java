//Author: Sam Casto
//Staurikosaurus is a concrete class that extends herrerasauridae

public class CH_Staurikosaurus extends C_Herrerasauridae {
	//default constructor
	public CH_Staurikosaurus() {
		super(2,"Late Triassic",2.0,"Brazil","Colbert","CH_Staurikosaurus");
	}
	//to string method
	public String toString() {
		return "The " + getName() + " is a dinosaur from the " + getAge() + " era that stood " + getHeight() + " meters" +
				" tall and was found in " + getLocation() + ", and was discovered by " + getNamedBy() + ".";
	}
}