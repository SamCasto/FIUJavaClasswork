//Author: Sam Casto
//Stegosaurus is the second concrete class of armored dinosaurs

public class HAD_Stegosaurus extends H_ArmoredDinosaur {
	//default constructor
	public HAD_Stegosaurus() {
		super("Late Jurassic",9.0,"USA","Marsh","HAD_Stegosaurus");
	}
	//to string method
	public String toString() {
		return "The " + getName() + " is a dinosaur from the " + getAge() + " era that stood " + getHeight() + " meters" +
				" tall and was found in " + getLocation() + ", and was discovered by " + getNamedBy() + ".";
	}
}