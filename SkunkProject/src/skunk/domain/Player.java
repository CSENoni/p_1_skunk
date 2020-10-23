package skunk.domain;

public class Player {
	
	private String name;
	
	// only one turn at this time
	private Turn curTurn;
	
	private int totalScores;
	
	// second aug is just for test
	public Player(String name, Turn turn) {
		this.name = name;
		curTurn = turn;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void play() {
		curTurn.createRoll(new Dice());
		totalScores += curTurn.getTurnScores();
	}
	
	public int getTotalScores() {
		return totalScores;
	}
}
