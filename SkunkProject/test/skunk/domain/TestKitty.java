package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestKitty {

	@Test
	void testAddChip() {
		Kitty kit = new Kitty();
		
		assertTrue(kit.getChip() == 0);
		
		kit.add(3);
		
		assertTrue(kit.getChip() == 3);
	}

	@Test
	void testChipDect() {
		Kitty kit = new Kitty();
		
		kit.add(50);
		kit.chipDect();
		assertTrue(kit.getChip() == 45);
	}
	
	@Test
	void testGetChip() {
		Kitty kit = new Kitty();
		
		kit.add(50);
		assertTrue(kit.getChip() == 50);
	}
}
