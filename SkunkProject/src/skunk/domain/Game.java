package skunk.domain;

import java.util.ArrayList;

public class Game {
	private int numOfPlayers;
	private ArrayList<Player> players;
	private Kitty kitty;
	
	public Game(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
		players = new ArrayList<Player>();
		kitty = new Kitty();
	}
	
	public void addPlayer(String name) {
		players.add(new Player(name));
	}
	
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
}
