package skunk.domain;

public class Player {
	
	private String name;
	
	// only one turn at this time
	private Turn curTurn;
	
	private int totalScores;
	
	public Player(String name) {
		this.name = name;
		curTurn = new Turn();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void play() {
		curTurn.createRoll(new Dice());
	}
	
	public void stop() {
		totalScores += curTurn.getTurnScores();
	}
	
	public int getTotalScores() {
		return totalScores;
	}
}
