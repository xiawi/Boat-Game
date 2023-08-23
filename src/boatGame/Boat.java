package boatGame;

public class Boat {

	// Class Variables
	private int location;
	
	// Constructor
	public Boat() {
		setLocation(0);
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	public int getLocation() {
		return location;
	}
	
	public String drawBoat() {
		String space = "";
		if (location == 0) {
			return "\\_/";
		}
		else {
			for (int x = 0; x < location; x++) {
				space = space + "   ";
			}
			return space + "\\_/";
		}
	}
}
