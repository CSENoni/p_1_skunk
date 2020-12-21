package skunk.domain;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp {
	
	// SkunkApp is a controller which connect Domain and UI
	public static void main(String[] args) {
		
		Game game = new Game();
		SkunkGUI skunkgui = new SkunkGUI(game);
		skunkgui.setVisible(true);
	}
}
