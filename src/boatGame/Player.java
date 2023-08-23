package boatGame;

public class Player {

	// Class Variables
	private String name;
	Score score = new Score();
	Boat boat = new Boat();
	
	// Constructor
	public Player(String name) {
		setName(name);
	}
	
	// Setter/Getter
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	// Methods
	public void playTurn() {
		Dice.rollDice();
		boat.setLocation(boat.getLocation()+Dice.getDiceNumber());
		
		if (boat.getLocation() < 0) {
			boat.setLocation(0);
		}
		if (boat.getLocation()>99) {
			boat.setLocation(99);
		}
		
		score.setTurns(score.getTurns()+1);
	}
	
	
}
