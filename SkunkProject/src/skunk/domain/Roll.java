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
	
}
