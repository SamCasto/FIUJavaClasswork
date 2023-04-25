/*
 * Author: Sam Casto
 * Atlascopcosaurus is a concrete class of small ornithopods
 */

public class HSO_Atlascopcosaurus extends H_SmallOrnithopods {
	//default constructor
	public HSO_Atlascopcosaurus() {
		super("Early Cretaceous",3.0,"Australia","Rich and Rich","HSO_Atlascopcosaurus");
	}
	
	//to string method
	public String toString() {
		return "The " + getName() + " is a dinosaur from the " + getAge() + " era that stood " + getHeight() + " meters" +
				" tall and was found in " + getLocation() + ", and was discovered by " + getNamedBy() + ".";
	}
	
}