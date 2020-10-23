package skunk.domain;

import java.util.ArrayList;
import java.util.List;

public class Turn {
	
	// Keep track of multiple rolls
	private List<Roll> rolls;
	
	private int turnScores;
	
	public Turn() {
		rolls = new ArrayList<Roll>();
	}
	
	public void createRoll(Dice dice) {
		Roll roll = new Roll(dice);
		rolls.add(roll);
		turnScores += roll.getScores();
	}
	
	public int numbersOfRolls() {
		return rolls.size();
	}
	
	public int getTurnScores() {
		return turnScores;
	}
}
