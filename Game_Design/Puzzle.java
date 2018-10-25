
public class Puzzle {
	Item[] itemsForSolution;
	Item[] itemsInRoom;
	Room roomPuzzle;
	Script[] textSc;
	boolean isDummy; // for easier comparison with a real and a dummy puzzle
	
	Script dummySc;
	int startSc;
	
	public Puzzle(Room roomPuzzle, int sizeOfSc) {
		this.roomPuzzle = roomPuzzle;
		this.itemsForSolution = new Item[roomPuzzle.items.length];
		this.itemsInRoom = new Item[roomPuzzle.items.length];
		for (int i = 0; i < roomPuzzle.items.length; i++) {
			itemsForSolution[i] = roomPuzzle.extracted();
			itemsInRoom[i] = roomPuzzle.extracted();
		}
		this.textSc = new Script[sizeOfSc];
		this.dummySc = new Script("", false);
		for (int j = 0; j < textSc.length; j++) {
			textSc[j] = dummySc;
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
	
	boolean addScript(String text, boolean printImm) {
		for (int i = 0; i < textSc.length; i++) {
			if (textSc[i].equals(dummySc)) {
				textSc[i] = new Script(text, false);
				return true;
			}
		}
		return false;
	}
	
	
}
