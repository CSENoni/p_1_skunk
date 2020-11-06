package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRoll {
	Dice dice = new Dice();
	Roll roll = new Roll(dice);
	
	@Test
	void testScores() {
		assertTrue(roll.getScores() == dice.getLastRoll());
	}
	
	@Test
	void testSkunk() {
		dice.setLastDie1Roll(3);
		dice.setLastDie2Roll(1);
		assertTrue(roll.isSkunk());
		
		dice.setLastDie2Roll(3);
		assertFalse(roll.isSkunk());
		
		dice.setLastDie1Roll(1);
		dice.setLastDie2Roll(2);
		assertFalse(roll.isSkunk());
	}
	
	@Test
	void testDoubleSkunks() {
		dice.setLastDie1Roll(1);
		dice.setLastDie2Roll(1);
		assertTrue(roll.isDoubleSkunk());
		
		dice.setLastDie1Roll(4);
		assertFalse(roll.isDoubleSkunk());
	}
	
	@Test
	void testDeuce() {
		dice.setLastDie1Roll(1);
		dice.setLastDie2Roll(2);
		assertTrue(roll.isDeuce());
		
		dice.setLastDie2Roll(1);
		assertFalse(roll.isDeuce());
	}
}
