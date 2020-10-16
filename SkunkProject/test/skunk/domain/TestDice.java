package skunk.domain;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestDice {
	
	@Test
	public void testRandomRolls() {
		Die die1 = new Die();
		Die die2 = new Die();
		
		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertTrue(dice.getLastRoll() == die1.getLastRoll() + die2.getLastRoll());
	}
}
