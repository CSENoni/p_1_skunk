package skunk.domain;

import java.util.Scanner;

import edu.princeton.cs.introcs.StdOut;

public class SkunkApp {
	
	// Only one turn and one player for this phase
	// No chip and kitty implemented yet
	public static void main(String[] args) {
		StdOut.println("Welcome to Skunk game");
		Scanner input = new Scanner(System.in);
		StdOut.println("Please enter player name:");
		String read = input.next();
		Player player = new Player(read, new Turn());
		StdOut.println("Player name is " + player.getName());
		
		StdOut.println("Do you want to start a game?[y/n]");
		read = input.next();
		
		
		if(read.equals("y") || read.equals("Y")) {
			StdOut.println("Roll?[y/n]");
			
			read = input.next();
			while(read.equals("y") || read.equals("Y")) {
				player.play();
				StdOut.println("Roll of Dice with last roll: " + player.getCurrentScore() + 
						", gives new turn score of " + player.getTotalScores());
				StdOut.println("Roll again?[y/n]");
				read = input.next();
			}
			StdOut.println("End of turn for 1");
			StdOut.println("Score for this turn is " + player.getTotalScores());
		}
	}

}
