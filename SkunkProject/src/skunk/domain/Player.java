package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

public class Player {
	
	private String name;
	
	// only one turn at this time
	private Turn curTurn;
	
	private int totalScores;
	
	private int curScore;
	
	private int chip = 50;
	
	// second aug is just for test
	public Player(String name, Turn turn) {
		this.name = name;
		curTurn = turn;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean play() {
		Dice dice = new Dice();
		curTurn.createRoll(dice);
		
		curScore = dice.getLastRoll();
		boolean check = checkPen(dice);
		totalScores = curTurn.getTurnScores();
		return check;
	}
	
	public int getTotalScores() {
		return totalScores;
	}
	
	public int getCurrentScore() {
		return curScore;
	}
	
	private boolean checkPen(Dice dice) {
		if(dice.lastDie1Roll() == 1 || dice.lastDie1Roll() == 1) {
			chip--;
			StdOut.println("One Skunk! You lose the turn, zeroing out the turn score and paying 1 chip to the kitty");
			return false;
		}else if(dice.lastDie1Roll() == 1 && dice.lastDie1Roll() == 1) {
			chip -= 4;
			StdOut.println("Double Skunks! You lose the turn, zeroing out the game score and paying 4 chips to the kitty");
			return false;
		}else if( dice.lastDie1Roll() == 1 && dice.lastDie2Roll() == 2 ||
				dice.lastDie1Roll() == 2 && dice.lastDie2Roll() == 1) {
			chip -= 2;
			StdOut.println("Skunks and Deuce! You lose the turn, zeroing out the turn score and paying 2 chips to the kitty");
			return false;
		}
		return true;
	}
}
