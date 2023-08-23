package boatGame;

import java.util.Scanner;

public class Menu {

	// Class Variables
	Scanner input = new Scanner(System.in);
	private String name;
	private String instructions;
	
	// Constructor
	public Menu(String n, String i) {
		setName(n);
		setInstructions(i);
	}
	
	// Setters / Getters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	public int drawMenu() {
		System.out.println(name);
		System.out.println("Type 's' to Start. Type 'i' for Instructions");
		String x = input.nextLine();
		if (x.equalsIgnoreCase("s")) {
			return 1;
		}
		else if (x.equalsIgnoreCase("i")) {
			return 2;
		}
		else {
			System.out.println("Invalid input");
			drawMenu();
			return 0;
		}
	}
	
	public void menuCheck(int i) {
		if (i == 1) {
			return;
		}
		else if (i == 2) {
			System.out.println(instructions);
			System.out.println();
			menuCheck(drawMenu());
		}
	}
	
}