/*
 * Author: Sam Casto
 * Car keeps track of a car's license plate and decal type 
 */
public class Car {
	private int decalType;
	private int licensePlate;
	
	public Car() {
		
	}
	public Car(int decal, int license) {
		decalType = decal;
		licensePlate = license;
	}
	
	public void setDecalType(int value) {
		decalType = value;
	}
	public void setLicensePlate(int value) {
		licensePlate = value;
	}
	public int getDecalType() {
		return decalType;
	}
	public int getLicensePlate() {
		return licensePlate;
	}
	public String toString() {
		return "License Plate Number: " + getLicensePlate() + "  DecalType: " + getDecalType();
	}
}