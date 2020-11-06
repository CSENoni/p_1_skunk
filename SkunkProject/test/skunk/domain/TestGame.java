package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGame {

	@Test
	void testNumOfPlayers() {
		Game game = new Game(3);
		assertTrue(game.getNumOfPlayers() == 3);
	}
	
	@Test
	void testAddPlayer() {
		Game game = new Game(2);
		game.addPlayer("Tom");
		assertTrue(game.getPlayers().get(0).getName().equals("Tom"));
	}

}
