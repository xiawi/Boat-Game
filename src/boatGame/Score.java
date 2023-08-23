package boatGame;

public class Score {

	// Scores should only be determined by the number of moves taken to finish the game.
	// If the number of turns it takes to finish the game exceeds 100, the player will 
	// have a score of 0.
	
	// Class variables
	private int turns;
	private int value;
	
	// Constructors
	public Score() {
		setTurns(0);
	}
	
	// Setters/Getters
	public void setTurns(int turns) {
		this.turns = turns;
		value = 100 - turns;
	}
	
	public int getTurns() {
		return turns;
	}
	
	public int getValue() {
		return value;
	}
}
