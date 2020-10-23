package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTurn {

	@Test
	void testRolls() {
		Turn turn = new Turn();
		turn.createRoll(new Dice());
		assertTrue(turn.numbersOfRolls() > 0);
		turn.createRoll(new Dice());
		assertTrue(turn.numbersOfRolls() > 1);
	}
	
	@Test
	void testScores() {
		Dice dice = new Dice();
		Turn turn = new Turn();
		turn.createRoll(dice);
		int scores = dice.getLastRoll();
		assertTrue(turn.getTurnScores() == scores);
		dice = new Dice();
		turn.createRoll(dice);
		scores += dice.getLastRoll();
		assertTrue(turn.getTurnScores() == scores);
	}

}
