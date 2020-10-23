package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRoll {

	@Test
	void testScores() {
		Dice dice = new Dice();
		Roll roll = new Roll(dice);
		
		assertTrue(roll.getScores() == dice.getLastRoll());
	}

}
