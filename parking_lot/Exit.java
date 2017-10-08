package parking_lot;

public class Exit {
	private double size;
	private int counter;

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int get_counter() {
		return counter;
	}

	public void inc_num_vehicles() {
		counter++;
	}

	public Exit(double size) {
		this.size = size;
		counter = 0;
	}
}
