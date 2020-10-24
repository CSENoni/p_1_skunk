package skunk.domain;

public class Kitty {
	private int chip;
	
	public void add(int num) {
		chip += num;
	}
	
	public void chipDect() {
		chip -= 5;
	}
	
	public int getChip() {
		return chip;
	}
}
