package parking_lot;
import java.util.ArrayList;

public class Plaza {
	private Parking_level<? extends Vehicle>[] area;
	private int num_levels;
	private static int NUM_SPOTS = 30;

	public Plaza() {
		int i;
		ArrayList<Parking_spot> spots = new ArrayList<Parking_spot>();
		ArrayList<String> enters = new ArrayList<String>();
		ArrayList<String> exits = new ArrayList<String>();

		num_levels = 4;

		area = new Parking_level<?>[num_levels];

		// Initialize parking spots
		for (i = 0; i < NUM_SPOTS; i++) {
			spots.add(new Parking_spot(i));
		}

		// Initialize enters
		enters.add(new String("e01"));
		enters.add(new String("e02"));
		enters.add(new String("e03"));
		enters.add(new String("e04"));
		enters.add(new String("e05"));

		// Initialize exits
		exits.add(new String("l01"));
		exits.add(new String("l02"));
		exits.add(new String("l03"));
		exits.add(new String("l04"));
		exits.add(new String("l05"));

		// Initialize parking levels
		area[0] = new Parking_level<Bike>(spots.subList(0, 5), 0.5, enters.subList(0, 1), exits.subList(0, 1));
		area[1] = new Parking_level<Car>(spots.subList(5, 12), 1, enters.subList(1, 2), exits.subList(1, 2));
		area[2] = new Parking_level<Bus>(spots.subList(12, 19), 3, enters.subList(2, 3), exits.subList(2, 3));
		area[3] = new Parking_level<Truck>(spots.subList(19, 30), 4, enters.subList(3, 5), exits.subList(3, 5));
	}

	public int num_vehicles() {
		int i;
		int count = 0;

		for (i = 0; i < num_levels; i++) {
			count += area[i].num_vehicles();
		}

		return count;
	}

	public int occupied_spots() {
		int i;
		int count = 0;

		for (i = 0; i < num_levels; i++) {
			count += area[i].occupied_spots();
		}

		return count;
	}

	public void print_num_vehicle() {
		System.out.println("Number of bikes: " + area[0].num_vehicles());
		System.out.println("Number of cars: " + area[1].num_vehicles());
		System.out.println("Number of busses: " + area[2].num_vehicles());
		System.out.println("Number of trucks: " + area[3].num_vehicles());

	}

	public void add_vehicle(Vehicle v, String enter_id) {
		if (v instanceof Bike) {
			((Parking_level<Bike>) area[0]).add_vehicle((Bike) v, enter_id);
		} else if (v instanceof Car) {
			((Parking_level<Car>) area[1]).add_vehicle((Car) v, enter_id);
		} else if (v instanceof Bus) {
			((Parking_level<Bus>) area[2]).add_vehicle((Bus) v, enter_id);
		} else if (v instanceof Truck) {
			((Parking_level<Truck>) area[3]).add_vehicle((Truck) v, enter_id);
		} else
			System.out.println("Unvalid vehicle");
	}

	public void remove_vehicle(String vehicle_id, String exit_id) {
		Vehicle v;
		int i;

		for (i = 0; i < num_levels; i++) {
			v = area[i].get_vehicle(vehicle_id);

			if (v != null) {
				area[i].remove_vehicle(vehicle_id, exit_id);
				break;
			}
		}
		if (i == num_levels)
			System.out.println("Unvalid vehicle");
	}

	public void print_vehicles_properties() {
		for (int i = 0; i < area.length; i++ )
		{
			Parking_level<? extends Vehicle> a = area[i];
			System.out.println("Level " + (i + 1) + ":");
			a.print_vehicles_properties();
		}
	}

	public void print_vehicles() {
		for (int i = 0; i < area.length; i++ )
		{
			Parking_level<? extends Vehicle> a = area[i];
			System.out.println("Level " + (i + 1) + ":");
			a.print_vehicles();
		}
	}

	public void print_enters_exits() {
		for (int i = 0; i < area.length; i++ )
		{
			Parking_level<? extends Vehicle> a = area[i];
			System.out.println("Level " + (i + 1) + ":");
			a.print_enters_exits();
		}
	}

}
