package boatGame;

public class Trap extends Tile{
	
	// Class Variables
	private final String type = "trap";
	private int strength;
	
	// Constructor
	public Trap() {
		setStrength(1);
	}
	
	public Trap(int strength) {
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
		return "[#]";
	}
	
}
