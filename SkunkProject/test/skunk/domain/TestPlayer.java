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
	
	@Test
	void testAddChip() {
		Player player = new Player("Tom");
		player.addChip(1);
		assertTrue(player.getChip() == 51);
	}
	
	@Test
	void testRemoveChip() {
		Player player = new Player("Tom");
		player.removeChip(1);
		assertTrue(player.getChip() == 49);
	}
	
	@Test
	void testGetChip() {
		Player player = new Player("Tom");
		assertTrue(player.getChip() == 50);
	}
	
	@Test
	void testAddTurn() {
		Player player = new Player("Tom");
		player.addTurn();
		assertTrue(player.roll() != null);
	}
	
	@Test
	void testGetTotalScore() {
		Player player = new Player("Tom");
		player.addTurn();
		Roll roll = player.roll();
		
		assertTrue(roll.getScores() == player.getTotalScores());
	}
	
	@Test
	void testZeroGameScore() {
		Player player = new Player("Tom");
		player.addTurn();
		player.roll();
		
		player.zeroGameScores();
		assertTrue(player.getTotalScores() == 0);
	}
}
