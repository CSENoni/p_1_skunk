package skunk.domain;

import java.util.ArrayList;
import java.util.List;

public class Turn {
	
	// Keep track of multiple rolls
	private List<Roll> rolls;
	
	private int turnScores;
	
	private int curRollScore;
	
	public Turn() {
		rolls = new ArrayList<Roll>();
	}
	
	public Roll createRoll(Dice dice) {
		Roll roll = new Roll(dice);
		rolls.add(roll);
		
		if(roll.isSkunk() || roll.isDeuce() || roll.isDeuce()) {
			turnScores = 0;
		}else {
			curRollScore = roll.getScores();
			turnScores += curRollScore;
		}
		
		return roll;
	}
	
	public int numbersOfRolls() {
		return rolls.size();
	}
	
	public int getTurnScores() {
		return turnScores;
	}
	
	public int getCurRollScore() {
		return curRollScore;
	}
}
