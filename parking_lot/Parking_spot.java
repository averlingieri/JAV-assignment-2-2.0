package parking_lot;

public class Parking_spot {

	private double occupied_area;
	private int number;

	public double getOccupied_area() {
		return occupied_area;
	}

	public void setOccupied_area(double occupied_area) {
		this.occupied_area = occupied_area;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Parking_spot(int number) {
		this.occupied_area = 0.0;
		this.number = number;
	}

}
