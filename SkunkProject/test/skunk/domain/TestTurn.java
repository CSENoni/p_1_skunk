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

}
