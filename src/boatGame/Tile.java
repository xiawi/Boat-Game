package boatGame;

public class Tile {

	// Class Variables
	private final String type = "default";
	private final int strength = 0;
	
	// Constructor
	public Tile() {
	}
		
	// Getter
	public String getType() {
		return type;
	}
	
	public int getStrength() {
		return strength;
	}
	
	// Methods
	public String drawTile() {
		return "[_]";
	}
	
}
