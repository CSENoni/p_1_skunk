package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

public class SkunkApp {

	public static void main(String[] args) {
		StdOut.println("Welcome");
		Dice dice = new Dice();
		dice.roll();
		StdOut.println(dice.toString());
	}

}
