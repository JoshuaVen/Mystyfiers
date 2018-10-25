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
		Puzzle dumm = new Puzzle(new Room(-1), 0);
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
				puzz1 = new Puzzle(roomDes.roomDes[i], 14);
			}
		}
		puzz1.addScript("Hi. Is anyone here?", false);
		puzz1.addScript("How do I even use this thing", false);
		puzz1.addScript("Can anyone hear me?", false);
		puzz1.addScript("*A sudden sound responded to me*", false);
		puzz1.addScript("*Hi!*", false);
		puzz1.addScript("Wow this thing works! And I feared that no one could hear me", false);
		puzz1.addScript("I found a strange device that connected me with you here", false);
		puzz1.addScript("I...I...hmmm... I don't know who I am, I don't know where I am. And I don't remember how I got here", false);
		puzz1.addScript("I came around half an hour ago. I have a terrible headache, and everything is blurred ", false);
		puzz1.addScript("It seems to me that I'm in a patient's room - there are lots of medical devices, an IV, and blue walls ", false);
		puzz1.addScript("Strange, the door is locked", false);
		puzz1.addScript("There is also a mirror hanging opposite to the bed, and I have a feeling that someone is watching me", false);
		puzz1.addScript("Maybe they conduct experiments on patients! ", false);
		puzz1.addScript("I'm scared, and I don't know what to do...", false);
		addPuzzle(puzz1);
	}
	
}
