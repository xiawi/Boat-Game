package boatGame;

public class Current extends Tile{
	
	// Class Variables
	private final String type = "current";
	private int strength;
	
	// Constructor
	public Current() {
		setStrength(1);
	}
	
	public Current(int strength) {
		setStrength(strength);
	}
	
	// Setters/Getters
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	@Override
	public int getStrength() {
		return strength;
	}
	
	@Override
	public String getType() {
		return type;
	}

	// Other Methods
	@Override
	public String drawTile() {
		return "[C]";
	}
	
}
