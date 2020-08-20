package version1;

public class Result {
	public String sequence = "";
	public int total;
	
	public Result() {
		
	}
	
	public void append(String n) {
		sequence += " " +n;
	}
	
	public void setTotal(int n) {
		total = n;
	}
	
	public void addToTotal(int n) {
		total += n;
	}
	
	public String toString() {
		return sequence +"\ntotal: " + total;
	}
}
