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
}
