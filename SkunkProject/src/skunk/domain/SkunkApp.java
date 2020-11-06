package skunk.domain;

import java.util.Scanner;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp {

	// Only one turn and one player for this phase
	public static void main(String[] args) {
		StdOut.println("Welcome to Skunk game!");
		StdOut.println("How many players?");
		int numOfPlayers = StdIn.readInt();
		
		StdOut.println("Please enter player name:");
		String read = StdIn.readLine();
		Player player = new Player(read, new Turn());
		StdOut.println("Player name is " + player.getName());

		StdOut.println("Do you want to read the game rule?[y/n]");
		read = StdIn.readLine();

		if (read.equalsIgnoreCase("y")) {
			StdOut.println("DIRECTIONS FOR PLAYING\n\n" +

					"The object of the game is to accumulate a score of 100 points or more. A score is made by rolling the dice and combining the points on the two dice.\n\n"
					+ "For example: A 4 and 5 would be 9 points - if the player decides to take another roll of the dice and turns up a 3 and 5 (8 points),\n"
					+ "he would then have an accumulated total of 17 points for the two rolls. The player has the privilege of continuing to shake to increase his score or of passing the dice to wait for the next series,\n"
					+ "thus preventing the possibility of rolling a Skunk and losing his score.\n\n" + "PENALTIES:\n\n"
					+ "A skunk in any series voids the score for that series only and draws a penalty of 1 chip placed in the \"kitty\", and loss of dice.\n\n"
					+ "A skunk and a deuce voids the score for that series only and draws a penalty of 2 chips placed in the \"kitty\", and loss of dice.\n\n"
					+ "TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty\", and loss of dice. Player must again start to score from scratch.\n\n"
					+ "Any number can play. [Assume at least two players!] The suggested number of chips to start is 50. There are sufficient chips in the box to allow 8 players to start with 50 chips by placing a par value of \"one\" on white chips, "
					+ "5 for 1 on red chips and 10 for 1 on the blue chips.\n\n"
					+ "The first player to accumulate a total of 100 or more points can continue to score as many points over 100 as he believes is needed to win. When he decides to stop, his total score is the \"goal\". "
					+ "Each succeeding player receives one more chance to better the goal and end the game.\n\n"
					+ "The winner of each game collects all chips in \"kitty\" and in addition ﬁve chips from each losing player or 10 chips from any player without a score.\n");

		}

		StdOut.println("Roll?[y/n]");

		read = StdIn.readLine();
		Kitty kitty = new Kitty();
		while (read.equals("y") || read.equals("Y")) {
			boolean check = player.play();
			if (!check) {
				player.loseTheTurn();
				kitty.add(50 - player.getChip());
				break;
			}
			StdOut.println("Roll of Dice with last roll: " + player.getCurrentScore() + ", gives new turn score of "
					+ player.getTotalScores());
			StdOut.println("Roll again?[y/n]");
			read = StdIn.readLine();
		}
		StdOut.println("End of turn for 1");
		StdOut.println("Score for this turn is " + player.getTotalScores());
		StdOut.println("Scoreboard:");
		StdOut.println("Kitty has " + kitty.getChip() + " chips");
		StdOut.println("Player name -- Turn score -- Game Score -- Total Chips");
		StdOut.println("----------------------------");
		StdOut.println(player.getName() + " -- " + player.getTotalScores() + " -- " + player.getTotalScores() + " -- "
				+ player.getChip());

	}

}
