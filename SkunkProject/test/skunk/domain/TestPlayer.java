package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayer {

	@Test
	void testName() {
		String name = "Tom";
		Player player = new Player(name, new Turn());
		assertTrue(player.getName().equals(name));
	}
	
	@Test
	void testPlay() {
		Turn turn = new Turn();
		Player player = new Player("Tom", turn);
		player.play();
		assertTrue(turn.getTurnScores() == player.getTotalScores());
	}
	
	@Test
	void testTotalScores() {
		Turn turn = new Turn();
		Player player = new Player("Tom", turn);
		player.play();
		int scores = turn.getTurnScores();
		player.play();
		scores += turn.getTurnScores();
		player.play();
		scores += turn.getTurnScores();
		assertTrue(scores == player.getTotalScores());
	}
}
