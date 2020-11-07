package skunk.domain;

import java.util.ArrayList;

public class Player {
	
	private String name;
	
	private ArrayList<Turn> turns;
	
	private int curTurnScore;
	
	private int prevTurnScore;
	
	private int chip = 50;
	
	public Player(String name) {
		this.name = name;
		turns = new ArrayList<Turn>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Roll roll() {
		prevTurnScore = curTurnScore;
		Turn curTurn = turns.get(turns.size() - 1);
		Dice dice = new Dice();
		Roll roll = curTurn.createRoll(dice);
		
		curTurnScore = curTurn.getTurnScores();
		return roll;
	}
	
	public int getTotalScores() {
		int totalScores = 0;
		for(int i = 0; i < turns.size(); i++) {
			totalScores += turns.get(i).getTurnScores();
		}
 		return totalScores;
	}
	
	public int getCurrentScore() {
		return curTurnScore;
	}
	
	public int getPrevScore() {
		return prevTurnScore;
	}
	
	public void zeroGameScores() {
		turns = new ArrayList<Turn>();
		addTurn();
		curTurnScore = 0;
	}
	
	public int getChip() {
		return chip;
	}
	
	public void removeChip(int num) {
		chip -= num;
	}
	
	public void addChip(int num) {
		chip += num;
	}
	
	public void addTurn() {
		turns.add(new Turn());
	}
}
