package boatGame;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Game {
	
	Scanner input = new Scanner(System.in);
	private Player p1;
	private Player p2;
	private River river = new River();
	private String instructions = "This is a 2 player Boat Game, Player 1 is shown above the river tiles, and Player 2 is shown below.\nRoll the dice to play your turn!";
	private Menu menu = new Menu("Boat Game", instructions);

	
	public Game() {
	}
	
	public void start() {
		
		menu.menuCheck(menu.drawMenu());
		
		String winnerName = "";
		int winnerScore = 0;
		int winner = 1;
		System.out.print("Player 1 Name: ");
		setP1Name(input.nextLine());
		System.out.print("Player 2 Name: ");
		setP2Name(input.nextLine());
		
		while ((p1.boat.getLocation() != 99) || (p2.boat.getLocation() != 99)) {
			System.out.println();
			System.out.println(p1.boat.drawBoat());
			System.out.println(river.drawRiver());
			System.out.println(p2.boat.drawBoat());
			
			if (p1.boat.getLocation() != 99) {
				System.out.println();
				System.out.println("Player 1, press Enter to play your turn");
				enterToContinue();
				p1.playTurn();
				System.out.println("You rolled a " + Dice.getDiceNumber() + "!");
				p1CheckTile(p1.boat.getLocation());
			}
			else {
				winner = 1;
				break;
			}
			
			if (p2.boat.getLocation() != 99) {
				System.out.println();
				System.out.println("Player 2, press Enter to play your turn");
				enterToContinue();
				p2.playTurn();
				System.out.println("You rolled a " + Dice.getDiceNumber() + "!");
				p2CheckTile(p2.boat.getLocation());
			}
			else {
				winner = 2;
				break;
			}
		}
		
		System.out.println();
		System.out.println("Game ended. Player " + winner + " wins!");
		
		if (winner == 1) {
			winnerName = p1.getName();
			winnerScore = p1.score.getValue();
		}
		else {
			winnerName = p2.getName();
			winnerScore = p2.score.getValue();
		}
		
		saveScore(winnerName, winnerScore);
		
	}
	
	public void p1CheckTile(int location) {
		String x = river.getTileType(location);
		if (x.equals("trap")) {
			p1.boat.setLocation(location - river.getTileStrength(location));
			System.out.println();
			System.out.println("You hit a trap! You got moved back " + river.getTileStrength(location) + " steps!");
		}
		else if (x.equals("current")) {
			p1.boat.setLocation(location + river.getTileStrength(location));
			System.out.println();
			System.out.println("Lucky! The river pushes you forward " + river.getTileStrength(location) + " steps!");
		}
	}
	
	public void p2CheckTile(int location) {
		String x = river.getTileType(location);
		if (x.equals("trap")) {
			p2.boat.setLocation(location - river.getTileStrength(location));
			System.out.println();
			System.out.println("You hit a trap! You got moved back " + river.getTileStrength(location) + " steps!");
		}
		else if (x.equals("current")) {
			p2.boat.setLocation(location + river.getTileStrength(location));
			System.out.println();
			System.out.println("Lucky! The river pushes you forward " + river.getTileStrength(location) + " steps!");
		}
	}
	
	public void setP1Name(String name) {
		p1 = new Player(name);
	}
	
	public void setP2Name(String name) {
		p2 = new Player(name);
	}
	
	public void enterToContinue() {
		for (int x = 0; x < 2; x++) {
			try {
				System.in.read();
			}
			catch (Exception e) {
				
			}
		}
	}
	
	public void saveScore(String name, int score) {
		try {
			FileWriter fw = new FileWriter("scores.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(name + ": " + score);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

			

	
}
