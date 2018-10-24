
public class Puzzle {
	Item[] itemsForSolution;
	Item[] itemsInRoom;
	Room roomPuzzle;
	String[] script;
	boolean isDummy; // for easier comparison with a real and a dummy puzzle
	boolean isShown; // to avoid the same printing of text
	
	public Puzzle(Room roomPuzzle) {
		this.roomPuzzle = roomPuzzle;
		this.itemsForSolution = new Item[roomPuzzle.items.length];
		this.itemsInRoom = new Item[roomPuzzle.items.length];
		for (int i = 0; i < roomPuzzle.items.length; i++) {
			itemsForSolution[i] = roomPuzzle.extracted();
			itemsInRoom[i] = roomPuzzle.extracted();
		}
		this.script = new String[100];
		for (int j = 0; j < script.length; j++) {
			script[j] = "";
		}
		this.isDummy = false;
		this.isShown = false;
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
	
	boolean addScript(String dialog) {
		for (int i = 0; i < script.length; i++) {
			if (script[i].equals("")) {
				script[i] = dialog;
				return true;
			}
		}
		return false;
	}
	
	String viewScript() {
		String text = new String();
		for (int i = 0; i < script.length; i++) {
			if (!script[i].equals("") && !isShown) {
				text = text + script[i] + "\n";
			}
		}
		isShown = true; // isShown is changed to true if it is already displayed
		return text;
	}
	
}
