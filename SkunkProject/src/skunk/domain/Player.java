package skunk.domain;

public class Player {
	
	private String name;
	
	// only one turn at this time
	private Turn curTurn;
	
	private int totalScores;
	
	private int curScore;
	
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
