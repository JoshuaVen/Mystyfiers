// a class that aims the same as the room design.. to add another puzzles easier
public class PuzzleDesign {

	int numOfPuzz;
	Puzzle[] puzzDes;
	RoomDesign roomDes;
	Puzzle dummy;
	
	// constructor needing the RoomDesign class to coincide the room and puzzle
	public PuzzleDesign(RoomDesign roomDes) {
		this.roomDes = roomDes;
		this.numOfPuzz = roomDes.roomDes.length;
		this.puzzDes = new Puzzle[numOfPuzz];
		this.dummy = dummyPuzzle();
		for (int i = 0; i < numOfPuzz; i++) {
			puzzDes[i] = dummyPuzzle();
		}
		createPuzzle();
	}
	
	// dummy puzzle
	private Puzzle dummyPuzzle() {
		Puzzle dumm = new Puzzle(new Room(-1), 0, 0);
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
		Puzzle puzz1 = dummy;
		for (int i = 0; i < roomDes.roomDes.length; i++) {
			if (roomDes.roomDes[i].roomNumber != -1) {
				puzz1 = new Puzzle(roomDes.roomDes[i], 14, 32);
			}
		}
		//System.out.println(puzz1.sizeOfSc);
		puzz1.addScript(1, "Hi. Is anyone here?", false);
		puzz1.addScript(1, "How do I even use this thing", false);
		puzz1.addScript(1, "Can anyone hear me?", false);
		puzz1.addScript(1, "*A sudden sound responded to me*", false);
		puzz1.addScript(1, "*Hi!*", false);
		puzz1.addScript(2, "Wow this thing works! And I feared that no one could hear me", false);
		puzz1.addScript(2, "I found a strange device that connected me with you here", false);
		puzz1.addScript(2, "I...I...hmmm... I don't know who I am, I don't know where I am. And I don't remember how I got here", false);
		puzz1.addScript(2, "I came around half an hour ago. I have a terrible headache, and everything is blurred ", false);
		puzz1.addScript(2, "It seems to me that I'm in a patient's room - there are lots of medical devices, an IV, and blue walls ", false);
		puzz1.addScript(2, "Strange, the door is locked", false);
		puzz1.addScript(2, "There is also a mirror hanging opposite to the bed, and I have a feeling that someone is watching me", false);
		puzz1.addScript(2, "Maybe they conduct experiments on patients! ", false);
		puzz1.addScript(2, "I'm scared, and I don't know what to do...", false);
		
		puzz1.addScript(3, "Oh my... I sure don't look all that great", false);
		puzz1.addScript(3, "I must have been here for a long time", false);
		
		puzz1.addScript(4, "I wonder for how long have I been lying here?", false);
		
		puzz1.addScript(5, "Who are these people, and why are they watching me?!", false);
		
		puzz1.addScript(6, "How do I do it? There is nothing to cling to here!", false);
		puzz1.addScript(6, "Why did they even put me here? For experiments? Or for something else? ", false);
		puzz1.addScript(6, "Hey, you there! Let me out!", false);
		puzz1.addScript(6, "What do you want from me?", false);
		puzz1.addScript(6, "Wow, now that's weird, When I screamed, some sort of writing showed up from my breathing", false);
		puzz1.addScript(6, "Yes, here it is. It says 807", false);
		puzz1.addScript(6, "What does it mean?", false);
		
		puzz1.addScript(7, "The code on the mirror is 807", false);
		
		puzz1.addScript(8, "It's locked. Well, this door isn't that easy to kick down. They're definitely not eager to let me out", false);
		puzz1.addScript(8, "Hmmm... There is no handle, no keyhole", false);
		puzz1.addScript(8, "There is a phone hanging next to the door. I wonder hwat is it for?", false);
		
		puzz1.addScript(9, "The code on the mirror is 807I've already tried opening the door. I failed", false);
		
		puzz1.addScript(10, "Hello? Who are you?", false);
		puzz1.addScript(10, "The voice keeps repeating the same phrase, it doesn't react to my words", false);
		puzz1.addScript(10, "It's a record of some famous expression; I understand this language, and it seems to be Latin: \"A friend of my friend is my my friend...", false);
		
		puzz1.addScript(11, "Yes, it's definitely Latin, it means something like... \"A friend of my fried is my friend...\" ...So strange...", false);
		puzz1.addScript(11, "Where the hell do I even know it from?!", false);
		
		puzz1.addScript(12, "Do you suggest talking to the answering machine? Well, ok, let's give it a try", false);
		puzz1.addScript(12, "What should I say?", false);
		
		puzz1.addScript(13, "Let's try again", false);
		
		puzz1.addScript(14, "Nothing happened, the voice keeps repaeting the same message", false);
		
		puzz1.addScript(15, "Something changed...Yeah! Right!", false);
		puzz1.addScript(15, "The voice on the phone stopped for a while and said: rectam responsum", false);
		puzz1.addScript(15, "I can hear the sound somewhere in the door, some kind of mechanical gnashing", false);
		puzz1.addScript(15, "The door is opening!", false);
		puzz1.addScript(15, "I don't believe my eyes! Thanks, I have no idea what I would do without you!", false);
		
		puzz1.addScript(16, "Am I a prisoner here?! There are rusty gratings on the windows, and a cabinet next to the bed. It must be night right now. It's raining outside", false);
		puzz1.addScript(16, "I'll look under the bed now", false);
		puzz1.addScript(16, "Interesting, there is a dusty suitcase. It should be mine, since it lies under my bed!", false);
		puzz1.addScript(16, "Damn, for how long long have I been here?", false);
		
		puzz1.addScript(17, "I've already searched all around. I don't have much choice, but I'll try to figure something out", false);
		
		puzz1.addScript(18, "The cabinet is digitally locked", false);
		puzz1.addScript(18, "I need some kind of a code to open it", false);
		puzz1.addScript(18, "Do you have any ideas?", false);
		puzz1.addScript(18, "I noticed a piece of paper sticking out from under the cabinet", false);
		puzz1.addScript(18, "Perhaps I can find something useful on it", false);
		puzz1.addScript(18, "There is only one handwritten note: \"Current code: the number of months in a year that have 28 days...\"", false);
		puzz1.addScript(18, "Seems to be a hint...", false);
		
		puzz1.addScript(19, "The following is written on the piece of paper I've found: \"Current code: the number of months in a year that have 28 days...\"", false);
		
		puzz1.addScript(20, "No, this code doesn't work!", false);
		
		puzz1.addScript(21, "I did it, I opened it!", false);
		puzz1.addScript(21, "It smells really strange. There are empty medicine bottles on the upper shelf...", false);
		puzz1.addScript(21, "Mnemosyne...Hypnotheryne...Oneurovite... Never heard of these", false);
		puzz1.addScript(21, "There's a ballpoint pen and a flashlight on the lower shelf", false);
		puzz1.addScript(21, "(auto-get pen)", false);
		puzz1.addScript(21, "(auto-get flashlight)", false);
		puzz1.addScript(21, "Batteries still work, it works", false);
		
		puzz1.addScript(22, "I've searched all the shelves and corners, there is nothing more", false);
		
		puzz1.addScript(23, "I'll try opening it", false);
		puzz1.addScript(23, "There is a combination lock, and if it's my suitcase, I should know the code...but I don't remember anything", false);
		puzz1.addScript(23, "You know, it's hard to describe...", false);
		puzz1.addScript(23, "It's like a tune that keeps playing in my mind, or an author whose name is on the tip of my tongue, but my brain just refuses to remember it", false);
		
		puzz1.addScript(24, "How do I open it?! I can't remember the code from the lock", false);
		
		puzz1.addScript(25, "It doesn't open", false);
		
		puzz1.addScript(26, "I opened it, my friend! I guess I had a vague idea of what they were gonna do to me when they dragged me here", false);
		puzz1.addScript(26, "That they would erase my memories...", false);
		puzz1.addScript(26, "And I left a note for myself on the mirror. I can't imagine what would I have done if you hadn't figured it out?!", false);
		puzz1.addScript(26, "Let's see what do we have here", false);
		puzz1.addScript(26, "Warm clothes, a small stack of clean notebooks...", false);
		puzz1.addScript(26, "There is a photo of a girl with a red umbrella... She is very beautiful, and has a nice smile. I think I know her...", false);
		puzz1.addScript(26, "It's signed: \"Paris, Summer\"", false);
		puzz1.addScript(26, "I have to try and remember her...", false);
		puzz1.addScript(26, "There is a book as well... No, I think it's my diary!", false);
		
		puzz1.addScript(27, "The paper is crumpled. Let's have a look...", false);
		puzz1.addScript(27, "\"May 12, 2005. I've finally found some information about her. That's why we'll have to fly to France on holidays. The three of us will manage, we just have to think everything through!\"", false);
		puzz1.addScript(27, "\"December 25, 2005. I can't fall asleep because it's so cold here. There are only stars and endless memories of her. I'm lucky to have a friend here with me, or else I would probably go crazy\"", false);
		puzz1.addScript(27, "I can't understand any other entries...", false);
		puzz1.addScript(27, "I managed to decipher only the last one: Identification of the signature is required", false);
		
		puzz1.addScript(28, "I've already looked through all the entries", false);		
		
		puzz1.addScript(29, "But I don't remember who I am!", false);
		puzz1.addScript(29, "What if I can't make it?", false);
		puzz1.addScript(29, "And what can I use to sign...", false);
		
		puzz1.addScript(30, "I guess I have to sign in this diary...", false);
		
		puzz1.addScript(31, "It worked! My hands remember it! The first letter seems to be L...", false);
		puzz1.addScript(31, "Now there's another entry!", false);
		puzz1.addScript(31, "T\"April 15, 2006. Huh, I'm back in the game! The key of all doors- \"viva\"", false);
		puzz1.addScript(31, "I don't understand a thing", false);
		puzz1.addScript(31, "Friend, there are no more entries. I must've gotten so engaged in the game that I had no time to keep writing in my diary...", false);
		puzz1.addScript(31, "But why did I hide this entry?", false);
		
		puzz1.addScript(32, "The last entry in the diary: \"Huh, I'm back in the game! Viva!\"", false);

		addPuzzle(puzz1);
	}
	
}
