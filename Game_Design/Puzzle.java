
public class Puzzle {
	Room roomPuzzle;
	Script[][] textSc;
	boolean isDummy; // for easier comparison with a real and a dummy puzzle
	
	Script dummySc;
	int sizeOfSc;
	int numberOfSc;
	int startSc;
	boolean[] solutions;
	
	public Puzzle(Room roomPuzzle, int sizeOfSc, int numberOfSc) {
		this.roomPuzzle = roomPuzzle;
		this.sizeOfSc = sizeOfSc;
		this.numberOfSc = numberOfSc;
		this.textSc = new Script[numberOfSc][sizeOfSc];
		this.dummySc = new Script("", false);
		for (int j = 0; j < numberOfSc; j++) {
			for (int k = 0; k < sizeOfSc; k++) {
				textSc[j][k] = dummySc;
			}
		}
		this.solutions = new boolean[10]; //for problems in a puzzle that requires true or false
		for (int i = 0; i < solutions.length; i++) {
			solutions[i] = false;
		}
		this.isDummy = false;
		this.startSc = 0;
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
		int script = scriptNum;
		for (i = 0; !textSc[script - 1][i].equals(dummySc);) {
			i++;
		}
		return i;
	}
}
