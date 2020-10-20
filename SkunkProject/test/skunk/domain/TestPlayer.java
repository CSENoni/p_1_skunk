package skunk.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayer {

	@Test
	void testName() {
		String name = "Tom";
		Player player = new Player(name);
		assertTrue(player.getName().equals(name));
	}

}
