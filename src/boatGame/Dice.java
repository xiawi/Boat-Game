package boatGame;

import java.util.Random;

public class Dice {

	private static int diceNumber;
	
	// Constructors
	public Dice() {
		diceNumber = 1;
	}
	
	public Dice(int num) {
		if ((num >= 1) && (num <= 6)) {
			diceNumber = num;
		}
		else {
			diceNumber = 1;
		}
	}
	
	// Getters
	public static int getDiceNumber() {
		return diceNumber;
	}
	
	// Methods
	public static void rollDice() {
		Random rand = new Random();
		diceNumber = 1 + rand.nextInt(6);
	}
}
