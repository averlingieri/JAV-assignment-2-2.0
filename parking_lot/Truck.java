package parking_lot;

public class Truck extends Vehicle_with_motor {

	private String load_type;
	private double load_weight;
	private boolean bed;

	public String getLoad_type() {
		return load_type;
	}

	public void setLoad_type(String load_type) {
		this.load_type = load_type;
	}

	public double getLoad_weight() {
		return load_weight;
	}

	public void setLoad_weight(double load_weight) {
		this.load_weight = load_weight;
	}

	public boolean isBed() {
		return bed;
	}

	public void setBed(boolean bed) {
		this.bed = bed;
	}

	public Truck(int num_seats, double weight, double max_speed, double height, int num_wheels, String num_plate, double fuel, int horsepower, String load_type, double load_weight, boolean bed) {
		super(num_seats, weight, max_speed, height, num_wheels, num_plate, fuel, horsepower);
		this.load_type = load_type;
		this.load_weight = load_weight;
		this.bed = bed;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Type of load: " + load_type);
		System.out.println("Weight of load: " + load_weight);
		System.out.println("Include bed: " + bed);
	}
}
