package skunk.domain;

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
	
	public void play() {
		Dice dice = new Dice();
		curTurn.createRoll(dice);
		
		if(dice.lastDie1Roll() == 1 || dice.lastDie1Roll() == 1) {
			chip--;
		}else if(dice.lastDie1Roll() == 1 && dice.lastDie1Roll() == 1) {
			chip -= 4;
		}
		curScore = dice.getLastRoll();
		totalScores = curTurn.getTurnScores();
	}
	
	public int getTotalScores() {
		return totalScores;
	}
	
	public int getCurrentScore() {
		return curScore;
	}
}
