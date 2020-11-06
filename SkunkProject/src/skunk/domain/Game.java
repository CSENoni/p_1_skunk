package skunk.domain;

import java.util.ArrayList;

public class Game {
	private int numOfPlayers;
	private ArrayList<Player> players;
	
	public Game(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(String name) {
		players.add(new Player(name));
	}
	
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
}
