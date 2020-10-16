package skunk.domain;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestDie
{
	
	@Test
	public void testRandomRolls()
	{
		Die die = new Die();
		for(int i = 0; i < 30; i++) {
			die.roll();
			assertTrue(die.getLastRoll() > 0 && die.getLastRoll() < 7);
		}
	}
	
	@Test
	public void testPreprogrammedRolls() {
		int dieArrayVals[] = new int[] {5, 4, 6, 1, 2, 3};
		Die die = new Die(dieArrayVals);
		
		assertTrue(die.getIsTestMode());
		
		for(int i = 0; i < dieArrayVals.length; i++) {
			die.roll();
			assertTrue(dieArrayVals[i] == die.getLastRoll());
		}
	}
}
