package parking_lot;

public class Car extends Vehicle_with_motor {

	private int num_car_door;
	private boolean car_ramp;
	private String type;

	public int getNum_car_door() {
		return num_car_door;
	}

	public void setNum_car_door(int num_car_door) {
		this.num_car_door = num_car_door;
	}

	public boolean isCar_ramp() {
		return car_ramp;
	}

	public void setCar_ramp(boolean car_ramp) {
		this.car_ramp = car_ramp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Car(int num_seats, double weight, double max_speed, double height, int num_wheels, String num_plate, double fuel, int horsepower, int num_car_door, boolean car_ramp, String type) {
		super(num_seats, weight, max_speed, height, num_wheels, num_plate, fuel, horsepower);
		this.num_car_door = num_car_door;
		this.car_ramp = car_ramp;
		this.type = type;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Number of car doors: " + num_car_door);
		System.out.println("Include car ramp: " + car_ramp);
		System.out.println("Type of car: " + type);
	}

}
