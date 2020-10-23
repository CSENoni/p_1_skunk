package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestKitty {

	@Test
	void addChip() {
		Kitty kit = new Kitty();
		
		assertTrue(kit.getChip() == 0);
	}

}
