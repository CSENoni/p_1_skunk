package skunk.domain;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Game {
	private ArrayList<Player> players;
	private Kitty kitty;
	private int pos = 0;
	private static int SCORE_FOR_FINAL_ROLL = 50;
	private Player curPlayer;
	private String msg;
	private Dice curDice;
	private int checkPoint = -1;
	
	public Game() {
		players = new ArrayList<Player>();
		kitty = new Kitty();
	}
	
	public void addPlayer(String name) {
		players.add(new Player(name));
		System.out.println(name);
	}
	
	public int getNumOfPlayers() {
		return players.size();
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void play() {
		curPlayer = players.get(pos);
		curPlayer.addTurn();
	}
	
	public Player getCurPlayer() {
		return curPlayer;
	}
	
	public boolean roll() {
		Roll roll = curPlayer.roll();
		curDice = roll.getDice();
		return checkAndPrintPenalty(roll, curPlayer);
	}
	
	public void pass() {
		pos++;
		pos = (pos >= getNumOfPlayers()) ? pos = 0 : pos;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public Dice getDice() {
		return curDice;
	}
	
	private boolean checkAndPrintPenalty(Roll roll, Player curPlayer) {
		if(roll.isSkunk()) {
			msg = "One Skunk! You lose the turn, zeroing out the turn score and paying 1 chip to the kitty";
			curPlayer.removeChip(1);
			kitty.add(1);
			return true;
		}else if(roll.isDoubleSkunk()) {
			msg = "Double Skunks! You lose the turn, zeroing out the game score and paying 4 chips to the kitty";
			curPlayer.removeChip(4);
			kitty.add(4);
			curPlayer.zeroGameScores();
			return true;
		}else if(roll.isDeuce()) {
			msg = "Skunks and Deuce! You lose the turn, zeroing out the turn score and paying 2 chips to the kitty";
			curPlayer.removeChip(2);
			kitty.add(2);
			return true;
		}else {
			msg = "";
			return false;
		}
	}
	
	
	public Player winner() {
		Player winner = null;
		int max = 0;
		for(int i = 0; i < getNumOfPlayers(); i++) {
			Player player = players.get(i);
			if(player.getTotalScores() > max) {
				max = player.getTotalScores();
				winner = player;
				pos = i;
			}
		}
		return winner;
	}
	
	public boolean isLastTurn() {
		if (curPlayer.getTotalScores() >= SCORE_FOR_FINAL_ROLL) {
			checkPoint = pos;
			return true;
		}
		return false;
	}
	
	public boolean isFinished() {
		return checkPoint == pos;
	}
	
	public Kitty getKitty() {
		return kitty;
	}
}
