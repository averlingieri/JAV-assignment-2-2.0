package parking_lot;

public class Vehicle {
	private int num_seats;
	private double weight;
	private double max_speed;
	private double height;
	private int num_wheels;
	private String id;

	public int getNum_seats() {
		return num_seats;
	}

	public void setNum_seats(int num_seats) {
		this.num_seats = num_seats;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getMax_speed() {
		return max_speed;
	}

	public void setMax_speed(double max_speed) {
		this.max_speed = max_speed;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getNum_wheels() {
		return num_wheels;
	}

	public void setNum_wheels(int num_wheels) {
		this.num_wheels = num_wheels;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Vehicle(int num_seats, double weight, double max_speed, double height, int num_wheels, String id) {
		this.num_seats = num_seats;
		this.weight = weight;
		this.max_speed = max_speed;
		this.height = height;
		this.num_wheels = num_wheels;
		this.id = id;
	}

	public void print() {
		System.out.println("Max speed: " + max_speed + "km/h");
		System.out.println("Weight: " + weight + "kg");
		System.out.println("Height: " + height + "m");
		System.out.println("Number of seats: " + num_seats);
		System.out.println("Number of weels: " + num_wheels);
	}

}
