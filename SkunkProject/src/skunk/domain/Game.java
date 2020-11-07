package skunk.domain;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Game {
	private int numOfPlayers;
	private ArrayList<Player> players;
	private Kitty kitty;
	private int pos = 0;
	
	public Game(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
		players = new ArrayList<Player>();
		kitty = new Kitty();
	}
	
	public void addPlayer() {
		for(int i = 0; i < numOfPlayers; i++) {
			StdOut.println("Please enter player name:");
			String name = StdIn.readString();
			players.add(new Player(name));
		}
	}
	
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void play() {
		while(true) {
			Player curPlayer = players.get(pos);
			curPlayer.addTurn();
			
			StdOut.println();
			StdOut.println("Player: " + curPlayer.getName());
			StdOut.println("Roll?[y/n]");
			String read = StdIn.readString();
			
			while (read.equalsIgnoreCase("y")) {
				Roll roll = curPlayer.roll();
				
				if(roll.isSkunk()) {
					StdOut.println("One Skunk! You lose the turn, zeroing out the turn score and paying 1 chip to the kitty");
					curPlayer.removeChip(1);
					kitty.add(1);
					break;
				}else if(roll.isDoubleSkunk()) {
					StdOut.println("Double Skunks! You lose the turn, zeroing out the game score and paying 4 chips to the kitty");
					curPlayer.removeChip(4);
					kitty.add(4);
					curPlayer.zeroGameScores();
					break;
				}else if(roll.isDeuce()) {
					StdOut.println("Skunks and Deuce! You lose the turn, zeroing out the turn score and paying 2 chips to the kitty");
					curPlayer.removeChip(2);
					kitty.add(2);
					break;
				}else {
					StdOut.println(roll.getDice());
				}
				
				StdOut.println("Roll again?[y/n]");
				read = StdIn.readString();
			}
			
			StdOut.println("End of turn for " + curPlayer.getName());
			StdOut.println("Score for this turn is " + curPlayer.getCurrentScore());
			StdOut.println("Previous Game Score: " + (curPlayer.getTotalScores() - curPlayer.getCurrentScore()));
			StdOut.println("New Game Score: " + curPlayer.getTotalScores());
			
			printScoreBoard();
			
			pos++;
			curPlayer = players.get((pos >= players.size() ? pos = 0 : pos));
		}
	}
	
	public void printScoreBoard() {
		StdOut.println();
		StdOut.println("Scoreboard:");
		StdOut.println("Kitty has " + kitty.getChip() + " chips");
		StdOut.println("Player name -- Turn score -- Game Score -- Total Chips");
		StdOut.println("----------------------------");
		
		for(int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			StdOut.println(player.getName() + " -- " + player.getTotalScores() + " -- " + player.getTotalScores() + " -- "
					+ player.getChip());
		}
	}
}
