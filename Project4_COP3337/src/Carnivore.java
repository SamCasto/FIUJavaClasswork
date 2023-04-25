/*
 * Author: Sam Casto
 * Carnivore abstract class that implements dinosaur. Holds methods related to carnivores
 */

abstract class Carnivore implements Dinosaur{
	//instance variables for all carnivores
		private int walkingLegs;
		private String age;
		private double height;
		private String location;
		private String namedBy;
		private String name;
		
		//default constructor
		public Carnivore(int legs, String time, double tall, String found, String discoverer, String title) {
			walkingLegs = legs;
			age = time;
			height = tall;
			location = found;
			namedBy = discoverer;
			name = title;
		}
		//setter methods
		public void setWalkingLegs(int legs) {
			walkingLegs = legs;
		}
		public void setAge(String time) {
			age = time;
		}
		public void setHeight(double tall) {
			height = tall;
		}
		public void setLocation(String found) {
			location = found;
		}
		public void setNamedBy(String discoverer) {
			namedBy = discoverer;
		}
		public void setName(String title) {
			name = title;
		}
		//getter methods
		public int getWalkingLegs() {
			return walkingLegs;
		}
		public String getAge() {
			return age;
		}
		public double getHeight() {
			return height;
		}
		public String getLocation() {
			return location;
		}
		public String getNamedBy() {
			return namedBy;
		}
		public String getName() {
			return name;
		}	
		//need a compare to method
		public int compareTo(Carnivore obj) {
			if(this.height < obj.height) {
				return -1;
			}
			else if(this.height > obj.height) {
				return 1;
			}
			else return 0;
		}
}