package skunk.domain;

import java.util.ArrayList;

import edu.princeton.cs.introcs.StdOut;

public class Player {
	
	private String name;
	
	private ArrayList<Turn> turns;
	
	private int curScore;
	
	private int chip = 50;
	
	public Player(String name) {
		this.name = name;
		turns = new ArrayList<Turn>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void play() {
		turns.add(new Turn());
		Turn curTurn = turns.get(turns.size() - 1);
		Dice dice = new Dice();
		curTurn.createRoll(dice);
		
		curScore = dice.getLastRoll();
//		boolean check = checkPen(dice);
	}
	
	public int getTotalScores() {
		int totalScores = 0;
		for(int i = 0; i < turns.size(); i++) {
			totalScores += turns.get(i).getTurnScores();
		}
 		return totalScores;
	}
	
	public int getCurrentScore() {
		return curScore;
	}
	
//	private boolean checkPen(Dice dice) {
//		if(dice.lastDie1Roll() == 1 || dice.lastDie2Roll() == 1) {
//			chip--;
//			StdOut.println("One Skunk! You lose the turn, zeroing out the turn score and paying 1 chip to the kitty");
//			return false;
//		}else if(dice.lastDie1Roll() == 1 && dice.lastDie2Roll() == 1) {
//			chip -= 4;
//			StdOut.println("Double Skunks! You lose the turn, zeroing out the game score and paying 4 chips to the kitty");
//			return false;
//		}else if( dice.lastDie1Roll() == 1 && dice.lastDie2Roll() == 2 ||
//				dice.lastDie1Roll() == 2 && dice.lastDie2Roll() == 1) {
//			chip -= 2;
//			StdOut.println("Skunks and Deuce! You lose the turn, zeroing out the turn score and paying 2 chips to the kitty");
//			return false;
//		}
//		return true;
//	}
	
	public void zeroGameScores() {
		turns = new ArrayList<Turn>();
		addTurn();
		curScore = 0;
	}
	
	public int getChip() {
		return chip;
	}
	
	private void addTurn() {
		turns.add(new Turn());
	}
}
