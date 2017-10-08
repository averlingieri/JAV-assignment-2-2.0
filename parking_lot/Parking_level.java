package parking_lot;
import java.util.List;
import java.util.HashMap;

public class Parking_level<T extends Vehicle> {

	private HashMap<T, Integer> parking_map; // First spot occupied by one vehicle
	private HashMap<String, Enter> enters; // Enter ID (e01, etc) associated to one enter
	private HashMap<String, Exit> exits; // Exit ID (l01, etc) associated to one exit
	private HashMap<String, T> vehicles; // Vehicle ID (license plate or chassis number) associated to one vehicle
	private double occupied_area; // Total area occupied in the parking level
	private double vehicle_num_spots; // Area occupied by one vehicle (Bike = 0.5, Car = 1, etc)
	private Parking_spot[] spots; // Spots of parking level

	public Parking_level(List<Parking_spot> spots, double vehicle_num_spots, List<String> enters, List<String> exits) {
		vehicles = new HashMap<String, T>();
		parking_map = new HashMap<T, Integer>();
		this.enters = new HashMap<String, Enter>();
		this.exits = new HashMap<String, Exit>();
		occupied_area = 0;
		this.vehicle_num_spots = vehicle_num_spots;
		this.spots = new Parking_spot[spots.size()];

		// Convert List<Parking_spot> to Parking_spot[]
		spots.toArray(this.spots);

		// Associate Enter ID to Enter instance
		for (String enter : enters) {
			this.enters.put(enter, new Enter(vehicle_num_spots));
		}

		// Associate Exit ID to Exit instance
		for (String exit : exits) {
			this.exits.put(exit, new Exit(vehicle_num_spots));
		}
	}

	public void add_vehicle(T v, String enter_id) {
		Enter e;
		// Check if there is enough space for parking a vehicle
		if (occupied_area + vehicle_num_spots <= spots.length) {
			// Search free spot
			for (int i = 0; i < spots.length; i++) {
				if (spots[i].getOccupied_area() < 1.0) {
					// Map car to first free spot
					parking_map.put(v, i);
					break;
				}
			}

			// Set parking spots as occupied (<= 1.0)
			for (int i = parking_map.get(v); i < parking_map.get(v) + vehicle_num_spots; i++) {
				spots[i].setOccupied_area(Math.min(1.0, vehicle_num_spots));
			}

			// Add vehicle to list of parked vehicles
			vehicles.put(v.getId(), v);

			// Increase occupied area
			occupied_area += vehicle_num_spots;

			// Increment number of vehicles that passed through enter_id
			e = enters.get(enter_id);
			if (e == null) {
				System.out.println("unvalid enter");
				return;
			}
			e.inc_num_vehicles();
		} else
			System.out.println("It's full");
	}

	public void remove_vehicle(String vehicle_id, String exit_id) {
		Exit e;
		T v = vehicles.get(vehicle_id);
		if (!vehicles.remove(vehicle_id, v)) {
			System.out.println("It's empty");
			return;
		}

		// Free parking spot from occupied area
		for (int i = parking_map.get(v); i < parking_map.get(v) + vehicle_num_spots; i++) {
			spots[i].setOccupied_area(Math.max(0.0, spots[i].getOccupied_area() - vehicle_num_spots));
		}

		// Remove vehicle from parking_map
		parking_map.remove(v);

		// Decrease occupied area
		occupied_area -= vehicle_num_spots;

		// Increment number of vehicles that passed through exit_id
		e = exits.get(exit_id);
		if (e == null) {
			System.out.println("unvalid exit");
			return;
		}
		e.inc_num_vehicles();
	}

	public int occupied_spots() {
		return (int) Math.ceil(occupied_area);
	}

	public int num_vehicles() {
		return vehicles.size();
	}

	public T get_vehicle(String index) {
		return vehicles.get(index);
	}

	public void print_vehicles_properties() {
		for (T v : vehicles.values()) {
			v.print();
			System.out.println("");
		}
	}

	public void print_vehicles() {
		int first_spot;
		for (T v : parking_map.keySet()) {
			System.out.print("Vehicle " + v.getId() + " occupies spots: ");
			first_spot = parking_map.get(v);
			for (int i = first_spot; i < first_spot + vehicle_num_spots; i++) {
				if (i == Math.ceil(first_spot + vehicle_num_spots - 1))
					System.out.print(i + 1);
				else
					System.out.print((i + 1) + ", ");
			}
			System.out.println("");
		}
	}

	public void print_enters_exits() {
		for (String k : enters.keySet()) {
			System.out.println("Enter " + k + " = " + enters.get(k).get_counter());
		}
		for (String k : exits.keySet()) {
			System.out.println("Exit " + k + " = " + exits.get(k).get_counter());
		}
	}

	public HashMap<T, Integer> getParking_map() {
		return parking_map;
	}

	public void setParking_map(HashMap<T, Integer> parking_map) {
		this.parking_map = parking_map;
	}

	public HashMap<String, Enter> getEnters() {
		return enters;
	}

	public void setEnters(HashMap<String, Enter> enters) {
		this.enters = enters;
	}

	public HashMap<String, Exit> getExits() {
		return exits;
	}

	public void setExits(HashMap<String, Exit> exits) {
		this.exits = exits;
	}

	public HashMap<String, T> getVehicles() {
		return vehicles;
	}

	public void setVehicles(HashMap<String, T> vehicles) {
		this.vehicles = vehicles;
	}

	public double getOccupied_area() {
		return occupied_area;
	}

	public void setOccupied_area(double occupied_area) {
		this.occupied_area = occupied_area;
	}

	public double getVehicle_num_spots() {
		return vehicle_num_spots;
	}

	public void setVehicle_num_spots(double vehicle_num_spots) {
		this.vehicle_num_spots = vehicle_num_spots;
	}

	public Parking_spot[] getSpots() {
		return spots;
	}

	public void setSpots(Parking_spot[] spots) {
		this.spots = spots;
	}

}
