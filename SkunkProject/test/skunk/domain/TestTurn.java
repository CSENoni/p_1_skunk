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
		Roll roll = turn.createRoll(dice);
		int scores = dice.getLastRoll();
		
		if(roll.isDeuce() || roll.isDoubleSkunk() || roll.isSkunk())
			assertTrue(turn.getTurnScores() == 0);
		else
			assertTrue(turn.getTurnScores() == scores);
	}

	@Test
	void testNumbersOfRolls() {
		Turn turn = new Turn();
		turn.createRoll(new Dice());
		turn.createRoll(new Dice());
		turn.createRoll(new Dice());
		assertTrue(turn.numbersOfRolls() == 3);
	}
}
