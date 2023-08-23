package boatGame;

import java.util.ArrayList;
import java.util.Random;

public class River {

	// Class Variables
	private ArrayList<Tile> board = new ArrayList<Tile>();
	
	// Constructor
	public River() {
		generateRiver();
	}
	
	// Methods
	public void generateRiver() {
		int y;
		int z;
		Tile tile = new Tile();	// First tile needs to be a defaul tile
		board.add(tile);
		for (int x = 0; x < 98; x++) {
			Random randnum = new Random();
			y = randnum.nextInt(5);
			z = 1 + randnum.nextInt(3);
			Trap trap = new Trap(z);
			Current current = new Current(z);
			if (y <= 2) {
				board.add(tile);
			}
			else if (y == 3) {
				board.add(current);
			}
			else {
				board.add(trap);
			}
		}
		board.add(tile);	// Last tile needs to be a default tile
	}
	
	/* Fist and last tiles need to be default so that players can play the game. If
	 	first tile is a current tile, the game will start from a different tile from the
	 	first; if the last tile is a trap tile, the game can never end*/
	
	public String drawRiver() {
		String board = "";
		for (int x = 0; x < this.board.size(); x++) {
			board += this.board.get(x).drawTile();
		}
		return board;
	}
	
	public String getTileType(int pos) {
		return board.get(pos).getType();
	}
	
	public int getTileStrength(int pos) {
		return board.get(pos).getStrength();
	}
}
