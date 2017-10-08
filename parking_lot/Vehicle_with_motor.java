package parking_lot;
public class Vehicle_with_motor extends Vehicle {

	private String license_plate;
	private double fuel;
	private int horsepower;

	public String getLicense_plate() {
		return license_plate;
	}

	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public Vehicle_with_motor(int num_seats, double weight, double max_speed, double height, int num_wheels, String license_plate, double fuel, int horsepower) {
		super(num_seats, weight, max_speed, height, num_wheels, license_plate);
		this.license_plate = license_plate;
		this.fuel = fuel;
		this.horsepower = horsepower;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("License plate: " + license_plate);
		System.out.println("Quantity of fuel: " + fuel + "L");
		System.out.println("Horsepower: " + horsepower);
	}

}
