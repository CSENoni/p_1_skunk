package skunk.domain;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Game {
	private int numOfPlayers;
	private ArrayList<Player> players;
	private Kitty kitty;
	private int pos = 0;
	private static int SCORE_FOR_FINAL_ROLL = 100;
	
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
		Player curPlayer = players.get(pos);
		while(true) {
			curPlayer.addTurn();
			
			StdOut.println();
			StdOut.println("Player: " + curPlayer.getName());
			StdOut.println("Roll?[y/n]");
			String read = StdIn.readString();
			
			while (read.equalsIgnoreCase("y")) {
				Roll roll = curPlayer.roll();
				
				if(checkAndPrintPenalty(roll, curPlayer)) break;
				
				StdOut.println("Roll again?[y/n]");
				read = StdIn.readString();
			}
			
			StdOut.println("End of turn for " + curPlayer.getName());
			StdOut.println("Score for this turn is " + curPlayer.getCurrentScore());
			StdOut.println("Previous Game Score: " + (curPlayer.getTotalScores() - curPlayer.getCurrentScore()));
			StdOut.println("New Game Score: " + curPlayer.getTotalScores());
			
			printScoreBoard();
			
			pos++;
			if(isLastTurn(curPlayer)) break;
			curPlayer = players.get((pos >= players.size() ? pos = 0 : pos));
		}
	}
	
	private boolean checkAndPrintPenalty(Roll roll, Player curPlayer) {
		if(roll.isSkunk()) {
			StdOut.println("One Skunk! You lose the turn, zeroing out the turn score and paying 1 chip to the kitty");
			curPlayer.removeChip(1);
			kitty.add(1);
			return true;
		}else if(roll.isDoubleSkunk()) {
			StdOut.println("Double Skunks! You lose the turn, zeroing out the game score and paying 4 chips to the kitty");
			curPlayer.removeChip(4);
			kitty.add(4);
			curPlayer.zeroGameScores();
			return true;
		}else if(roll.isDeuce()) {
			StdOut.println("Skunks and Deuce! You lose the turn, zeroing out the turn score and paying 2 chips to the kitty");
			curPlayer.removeChip(2);
			kitty.add(2);
			return true;
		}else {
			StdOut.println(roll.getDice());
			return false;
		}
	}
	
	public void playFinalTurn() {
		StdOut.println();
		StdOut.println("---- Last turn for all ----");
		Player curPlayer = players.get((pos >= players.size() ? pos = 0 : pos));
		while(curPlayer.getTotalScores() < SCORE_FOR_FINAL_ROLL) {
			curPlayer.addTurn();
			
			StdOut.println();
			StdOut.println("Player: " + curPlayer.getName());
			StdOut.println("Roll?[y/n]");
			String read = StdIn.readString();
			
			while (read.equalsIgnoreCase("y")) {
				Roll roll = curPlayer.roll();
				
				if(checkAndPrintPenalty(roll, curPlayer)) break;
				
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
		
		StdOut.println();
		Player winner = null;
		int max = 0;
		for(int i = 0; i < numOfPlayers; i++) {
			Player player = players.get(i);
			StdOut.println("Final game score for " + player.getName() + " is " + player.getTotalScores());
			if(player.getTotalScores() > max) {
				max = player.getTotalScores();
				winner = player;
				pos = i;
			}
		}
		
		if(winner != null) {
			StdOut.println("Game winner is " + winner.getName() + " with score of " + winner.getTotalScores());
			int chipEarned = 0;
			
			for(int i = 0; i < numOfPlayers; i++) {
				if(i == pos) continue;
				Player player = players.get(i);
				
				
				if(player.getTotalScores() == 0) {
					StdOut.println("Game winner earns 10 chips from " + player.getName() + " with zero score");
					chipEarned += 10;
					player.removeChip(10);
				}else {
					StdOut.println("Game winner earns 5 chips from " + player.getName() + " with losing score");
					chipEarned += 5;
					player.removeChip(5);
				}
			}
			StdOut.println("Game winner earns " + kitty.getChip() + " chips from kitty");
			chipEarned += kitty.getChip();
			
			winner.addChip(chipEarned);
			StdOut.println("Game winner has total " + winner.getChip() + " chips");
			
			StdOut.println();
			StdOut.println("Final Scoreboard:");
			StdOut.println("Player name -- Game Score -- Total Chips");
			StdOut.println();
			StdOut.println("----------------------------");
			
			for(int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				StdOut.println(player.getName() + " -- " + player.getTotalScores() + " -- "
						+ player.getChip());
			}
		}
	}
	
	private void printScoreBoard() {
		StdOut.println();
		StdOut.println("Scoreboard:");
		StdOut.println("Kitty has " + kitty.getChip() + " chips");
		StdOut.println("Player name -- Turn score -- Game Score -- Total Chips");
		StdOut.println("----------------------------");
		
		for(int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			StdOut.println(player.getName() + " -- " + player.getCurrentScore() + " -- " + player.getTotalScores() + " -- "
					+ player.getChip());
		}
	}
	
	private boolean isLastTurn(Player player) {
		return player.getTotalScores() >= SCORE_FOR_FINAL_ROLL;
	}
}
