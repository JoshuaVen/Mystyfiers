// a class that aims the same as the room design.. to add another puzzles easier
public class PuzzleDesign {

	int numOfPuzz;
	Puzzle[] puzzDes;
	RoomDesign roomDes;
	
	// constructor needing the RoomDesign class to coincide the room and puzzle
	public PuzzleDesign(RoomDesign roomDes) {
		this.roomDes = roomDes;
		this.numOfPuzz = roomDes.roomDes.length;
		this.puzzDes = new Puzzle[numOfPuzz];
		for (int i = 0; i < numOfPuzz; i++) {
			puzzDes[i] = dummyPuzzle();
		}
		createPuzzle();
	}
	
	// dummy puzzle
	private Puzzle dummyPuzzle() {
		Puzzle dumm = new Puzzle(new Room(-1));
		dumm.isDummy = true; // isDummy is set to true for easier comparison later
		return dumm;
	}
	
	// adding a puzzle to the array of puzzles
	private boolean addPuzzle(Puzzle newPuzzle) {
		for (int i = 0; i < numOfPuzz; i++) {
			if (dummyPuzzle().isDummy) {
				puzzDes[i] = newPuzzle;
				return true;
			}
		}
		return false;
	}
	
	// create a puzzle
	protected void createPuzzle() {
		Puzzle puzz1 = dummyPuzzle();
		for (int i = 0; i < roomDes.roomDes.length; i++) {
			if (roomDes.roomDes[i].roomNumber != -1) {
				puzz1 = new Puzzle(roomDes.roomDes[i]);
			}
		}
		puzz1.addScript("You have been kidnapped!!!!");
		puzz1.addScript("You are locked inside a room with things around...");
		puzz1.addScript("There will a series of rooms that you need to get out in order to win this game!");
	//	puzz1.addScript("Take a look around the room by entering \"look\"");
		puzz1.addScript("[Don't know how to get started? Type \"help\" and then hit enter.]");
		addPuzzle(puzz1);	
	}
	
}
