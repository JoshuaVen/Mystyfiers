
public class Puzzle {
	Room roomPuzzle;
	Script[][] textSc;
	boolean isDummy; // for easier comparison with a real and a dummy puzzle
	Problem[] prob;

	Script dummySc;
	Problem dummyProb;
	int sizeOfSc;
	int numberOfSc;
	int startSc;
	
	public Puzzle(Room roomPuzzle, int sizeOfSc, int numberOfSc) {
		this.roomPuzzle = roomPuzzle;
		this.sizeOfSc = sizeOfSc;
		this.numberOfSc = numberOfSc;
		this.textSc = new Script[numberOfSc][sizeOfSc];
		this.dummySc = new Script("", false);
		this.dummyProb = new Problem("", false);
		for (int j = 0; j < numberOfSc; j++) {
			for (int k = 0; k < sizeOfSc; k++) {
				textSc[j][k] = dummySc;
			}
		}
		
		this.prob = new Problem[10]; //for problems in a puzzle that requires true or false
		for (int i = 0; i < prob.length; i++) {
			prob[i] = dummyProb;
		}
		this.isDummy = false;
		this.startSc = 0;
	}
	
	boolean changeToSolved(String problem) {
		for (int i = 0; i < prob.length; i++) {
			if (prob[i].problemName.matches(problem)) {
				if (prob[i].getIsSolved() == false) {
					prob[i].changetoSolved();
					return true;
				}
			}
		}
		return false;
	}
	
	boolean checkProblemIfSolved(String problem) {
		for (int i = 0; i < prob.length; i++) {
			if (prob[i].problemName.matches(problem)) {
				if (prob[i].getIsSolved()) {
					return true;
				}
			}
		}
		return false;
	}

	boolean addProblem(String problem) {
		Problem newProb = new Problem(problem, false);
		for (int i = 0; i < prob.length; i++) {
			if (prob[i].equals(dummyProb)) {
				prob[i] = newProb;
				return true;
			}
		}
		return false;
	}
	
	boolean addScript(int script, String text, boolean printImm) {
		int part = script - 1;
		for (int i = 0; i < sizeOfSc; i++) {
			if (textSc[part][i].equals(dummySc)) {
				textSc[part][i] = new Script(text, printImm);
				return true;
			}
		}
		return false;
	}
	
	int actualSizeOfSc(int scriptNum) {
		int i;
		int script = scriptNum - 1;
		for (i = 0; !textSc[script][i].equals(dummySc);) {
			i++;
		}
		return i;
	}
}
