package parking_lot;

public class Bike extends Vehicle_without_motor {

	private String type;
	private boolean bell;
	private boolean luggage_carrier;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isBell() {
		return bell;
	}

	public void setBell(boolean bell) {
		this.bell = bell;
	}

	public boolean isLuggage_carrier() {
		return luggage_carrier;
	}

	public void setLuggage_carrier(boolean luggage_carrier) {
		this.luggage_carrier = luggage_carrier;
	}

	public Bike(int num_seats, double weight, double max_speed, double height, int num_wheels, String kind_towing, String type, boolean bell, boolean luggage_carrier, String chassis_id) {
		super(num_seats, weight, max_speed, height, num_wheels, kind_towing, chassis_id);
		this.type = type;
		this.bell = bell;
		this.luggage_carrier = luggage_carrier;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Type of bike: " + type);
		System.out.println("Include a luggage carrier: " + luggage_carrier);
		System.out.println("Include a bell: " + bell);
	}

}
