
public class Puzzle {
	Item[] itemsForSolution;
	Item[] itemsInRoom;
	Room roomPuzzle;
	Script[][] textSc;
	boolean isDummy; // for easier comparison with a real and a dummy puzzle
	
	Script dummySc;
	int sizeOfSc;
	int numberOfSc;
	int startSc;
	
	public Puzzle(Room roomPuzzle, int sizeOfSc, int numberOfSc) {
		this.roomPuzzle = roomPuzzle;
		this.sizeOfSc = sizeOfSc;
		this.numberOfSc = numberOfSc;
		this.itemsForSolution = new Item[roomPuzzle.items.length];
		this.itemsInRoom = new Item[roomPuzzle.items.length];
		for (int i = 0; i < roomPuzzle.items.length; i++) {
			itemsForSolution[i] = roomPuzzle.extracted();
			itemsInRoom[i] = roomPuzzle.extracted();
		}
		this.textSc = new Script[numberOfSc][sizeOfSc];
		this.dummySc = new Script("", false);
		for (int j = 0; j < numberOfSc; j++) {
			for (int k = 0; k < sizeOfSc; k++) {
				textSc[j][k] = dummySc;
			}
		}
		this.isDummy = false;
		this.startSc = 0;
	}
	
	boolean partOfSoln(Item contributor) {
		for (int i = 0; i < itemsForSolution.length; i++) {
			if (contributor.equals(itemsForSolution[i])) {
				return true;
			}
		}
		return false;
	}
	
	boolean theSoln(Item solution) {
		for (int i = 0; i < itemsForSolution.length; i++) {
			if (solution.equals(itemsForSolution[i])) {
				return true;
			}
		}
		return false;
	}
	
	boolean addScript(int script, String text, boolean printImm) {
		int part = script - 1;
		for (int i = 0; i < sizeOfSc; i++) {
			if (textSc[part][i].equals(dummySc)) {
				textSc[part][i] = new Script(text, false);
				return true;
			}
		}
		return false;
	}
	
	int actualSizeOfSc(int scriptNum) {
		int i;
		int script = scriptNum;
		for (i = 0; !textSc[script][i].equals(dummySc);) {
			i++;
		}
		return i;
	}
}
