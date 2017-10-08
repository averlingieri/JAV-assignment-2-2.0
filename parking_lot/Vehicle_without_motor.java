package parking_lot;
public class Vehicle_without_motor extends Vehicle {

	private String material;
	private String chassis_id;

	public String getChassis_id() {
		return chassis_id;
	}

	public void setChassis_id(String chassis_id) {
		this.chassis_id = chassis_id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Vehicle_without_motor(int num_seats, double weight, double max_speed, double height, int num_wheels, String material, String chassis_id) {
		super(num_seats, weight, max_speed, height, num_wheels, chassis_id);
		this.material = material;
		this.chassis_id = chassis_id;

	}

	@Override
	public void print() {
		super.print();
		System.out.println("Material: " + material);
		System.out.println("Chassis ID: " + chassis_id);
	}

}
