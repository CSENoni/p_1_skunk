package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayer {

	@Test
	void testName() {
		String name = "Tom";
		Player player = new Player(name);
		assertTrue(player.getName().equals(name));
	}
	
//	@Test
//	void testPlay() {
//		Player player = new Player("Tom");
//		player.play();
//		assertTrue(player.getTotalScores());
//	}
//	
//	@Test
//	void testTotalScores() {
//		Turn turn = new Turn();
//		Player player = new Player("Tom", turn);
//		player.play();
//		player.play();
//		player.play();
//		assertTrue(turn.getTurnScores() == player.getTotalScores());
//	}
}
