package parking_lot;
import java.io.*;

public class Parking {

	public static void main(String[] arguments) {

		Plaza plaza = new Plaza();

		try {
			BufferedReader br = new BufferedReader(new FileReader("./src/park.txt"));
			String line = null;
			Vehicle v;

			while ((line = br.readLine()) != null) {
				String[] params = line.split(", ");
				if (params[0].equals("E")) {
					switch (params[2]) {
					case "bike": {
						v = new Bike(Integer.parseInt(params[3]), Double.parseDouble(params[4]),
								Double.parseDouble(params[5]), Double.parseDouble(params[6]),
								Integer.parseInt(params[7]), params[8], params[9], Boolean.parseBoolean(params[10]),
								Boolean.parseBoolean(params[11]), params[12]);
						break;
					}
					case "bus": {
						v = new Bus(Integer.parseInt(params[3]), Double.parseDouble(params[4]),
								Double.parseDouble(params[5]), Double.parseDouble(params[6]),
								Integer.parseInt(params[7]), params[8], Double.parseDouble(params[9]),
								Integer.parseInt(params[10]), params[11]);
						break;
					}
					case "car": {
						v = new Car(Integer.parseInt(params[3]), Double.parseDouble(params[4]),
								Double.parseDouble(params[5]), Double.parseDouble(params[6]),
								Integer.parseInt(params[7]), params[8], Double.parseDouble(params[9]),
								Integer.parseInt(params[10]), Integer.parseInt(params[11]),
								Boolean.parseBoolean(params[12]), params[13]);
						break;
					}
					case "truck": {
						v = new Truck(Integer.parseInt(params[3]), Double.parseDouble(params[4]),
								Double.parseDouble(params[5]), Double.parseDouble(params[6]),
								Integer.parseInt(params[7]), params[8], Double.parseDouble(params[9]),
								Integer.parseInt(params[10]), params[11], Double.parseDouble(params[12]),
								Boolean.parseBoolean(params[13]));
						break;
					}

					default: {
						System.out.println("Unvalid vehicle");
						return;
					}

					}

					plaza.add_vehicle(v, params[1]);
					System.out.println("Total number of vehicles: " + plaza.num_vehicles() + " occupied spots = " + plaza.occupied_spots());
					plaza.print_vehicles();
					System.out.println("");
				} else if (params[0].equals("L")) {
					plaza.remove_vehicle(params[2], params[1]);
					System.out.println("Total number of vehicles: " + plaza.num_vehicles() + " occupied spots = " + plaza.occupied_spots());
					plaza.print_vehicles();
					System.out.println("");
				} else {
					System.out.println("Unvalid operation");
				}
			}
			br.close();

		} catch (IOException e) {
			System.out.println("An error occurred: " + e);
			return;
		}

		plaza.print_enters_exits();
		System.out.println("");
		plaza.print_vehicles();
		System.out.println("");
		plaza.print_vehicles_properties();
		System.out.println("");
		plaza.print_num_vehicle();

	}
}
