package skunk.domain;

public class Roll {
	
	private Dice dice;
	
	public Roll(Dice dice) {
		this.dice = dice;
		dice.roll();
	}
	
	public int getScores() {
		return dice.getLastRoll();
	}
	
	public boolean isSkunk() {
		return dice.lastDie1Roll() == 1 && dice.lastDie2Roll() != 1 && dice.lastDie2Roll() != 2 ||
				dice.lastDie1Roll() != 1 && dice.lastDie1Roll() != 2 && dice.lastDie2Roll() == 1;
	}
	
	public boolean isDoubleSkunk() {
		return dice.lastDie1Roll() == 1 && dice.lastDie2Roll() == 1;
	}
	
	public boolean isDeuce() {
		return dice.lastDie1Roll() == 1 && dice.lastDie2Roll() == 2 || 
				dice.lastDie1Roll() == 2 && dice.lastDie2Roll() == 1;
	}
}
