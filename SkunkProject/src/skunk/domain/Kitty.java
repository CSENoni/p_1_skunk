package skunk.domain;

public class Kitty {
	private int chip;
	
	public void add(int num) {
		chip += num;
	}
	
	public void removeChip(int num) {
		chip -= num;
	}
	
	public int getChip() {
		return chip;
	}
}
