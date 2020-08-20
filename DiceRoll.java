package version1;

public class DiceRoll {
	public int value, rolls;
	
	public DiceRoll(int n) {
		value = n;
		rolls = 0;
	}
	
	public void increase() {
		if (rolls < 10)
			rolls++;
	}
	
	public void increase(int n) {
		if (rolls + n <= 10)
			rolls+=n;
		else
			rolls = 10;
	}
	
	public Result rollIt() {
		Result temp = new Result();
		while (rolls > 0) {
			int r = (int)(Math.random()*value)+1;
			temp.append(""+r);
			temp.addToTotal(r);
		}
		return temp;
	}
}
