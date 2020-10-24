package skunk.domain;

import java.util.Scanner;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp {
	
	// Only one turn and one player for this phase
	public static void main(String[] args) {
		StdOut.println("Welcome to Skunk game");
		StdOut.println("Please enter player name:");
		String read = StdIn.readLine();
		Player player = new Player(read, new Turn());
		StdOut.println("Player name is " + player.getName());
		
		StdOut.println("Do you want to start a game?[y/n]");
		read = StdIn.readLine();
		
		
		if(read.equals("y") || read.equals("Y")) {
			StdOut.println("Roll?[y/n]");
			
			read = StdIn.readLine();
			Kitty kitty = new Kitty();
			while(read.equals("y") || read.equals("Y")) {
				boolean check = player.play();
				if( !check) {
					player.loseTheTurn();
					kitty.add(50 - player.getChip());
					break;
				}
				StdOut.println("Roll of Dice with last roll: " + player.getCurrentScore() + 
						", gives new turn score of " + player.getTotalScores());
				StdOut.println("Roll again?[y/n]");
				read = StdIn.readLine();
			}
			StdOut.println("End of turn for 1");
			StdOut.println("Score for this turn is " + player.getTotalScores());
			StdOut.println("Scoreboard:");
			StdOut.println("Kitty has " + kitty.getChip() + " chips");
			StdOut.println("Player name -- Turn score -- Game Score -- Total Chips");
			StdOut.println("----------------------------");
			StdOut.println(player.getName() + " -- " + 
					player.getTotalScores() + " -- " + 
					player.getTotalScores() + " -- " + 
					player.getChip());
		}
	}

}
