
public class Problem {
	String problemName;
	boolean isSolved;
	
	public Problem(String problemName, boolean isSolved) {
		this.problemName = problemName;
		this.isSolved = isSolved;
	}
	
	protected boolean changetoSolved() {
		this.isSolved = true;
		return true;
	}
	
	protected boolean getIsSolved() {
		return isSolved;
	}
}
