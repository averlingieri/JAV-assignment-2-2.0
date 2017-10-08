package parking_lot;

public class Bus extends Vehicle_with_motor {

	private String type; // e.g. schoolbus, etc.

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Bus(int num_seats, double weight, double max_speed, double height, int num_wheels, String num_plate, double fuel, int horsepower, String type) {
		super(num_seats, weight, max_speed, height, num_wheels, num_plate, fuel, horsepower);
		this.type = type;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Type of bus: " + type);
	}

}
