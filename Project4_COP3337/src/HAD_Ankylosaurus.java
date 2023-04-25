//Author: Sam Casto
//One of the two concrete classes of armored dinosaurs

public class HAD_Ankylosaurus extends H_ArmoredDinosaur {
	//default constructor
	public HAD_Ankylosaurus() {
		super("Late Cretaceous",7.0,"Canada and USA","Brown","HAD_Ankylosaurus");
	}
	//to string method
	public String toString() {
		return "The " + getName() + " is a dinosaur from the " + getAge() + " era that stood " + getHeight() + " meters" +
				" tall and was found in " + getLocation() + ", and was discovered by " + getNamedBy() + ".";
	}
}