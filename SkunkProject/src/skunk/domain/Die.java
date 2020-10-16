package skunk.domain;

import edu.princeton.cs.introcs.StdOut;

public class Die
{
	private int lastRoll;
	private boolean isTestMode = false;
	private int dieArrayVal[];
	private int pos;
	
	public Die() {}
	
	public Die(int[] dieArrayVal) {
		isTestMode = true;
		pos = 0;
		this.dieArrayVal = dieArrayVal;
	}

	public boolean getIsTestMode() {
		return isTestMode;
	}
	
	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		if(isTestMode) {
			if(pos > dieArrayVal.length) {
				StdOut.println("End of roll");
				return;
			}
			pos++;
			this.lastRoll = dieArrayVal[pos - 1];
		}else {
			this.lastRoll = (int) (Math.random() * 6 + 1);
		}
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}
}
