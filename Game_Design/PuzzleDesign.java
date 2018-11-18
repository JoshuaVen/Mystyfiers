// a class that aims the same as the room design.. to add another puzzles easier
public class PuzzleDesign {

	int numOfPuzz;
	Puzzle[] puzzDes;
	Puzzle dummy;
	
	// constructor needing the RoomDesign class to coincide the room and puzzle
	public PuzzleDesign() {
		this.numOfPuzz = 10;
		this.puzzDes = new Puzzle[numOfPuzz];
		this.dummy = dummyPuzzle();
		for (int i = 0; i < numOfPuzz; i++) {
			puzzDes[i] = dummy;
		}
		createPuzzle();
	}
	
	// dummy puzzle
	private Puzzle dummyPuzzle() {
		Puzzle dumm = new Puzzle(0, 0);
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
		
		Puzzle puzz1 = new Puzzle(14, 32);
			
		
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
		
		puzz1.addScript(8, "I see a Peace Lily, an Areca Palm, some Birds of Paradise, and a small Bamboo plant", false);
		puzz1.addScript(8, "I can't recognize the others though", false);
		puzz1.addScript(8, "Something smells nice but I can't figure out where its coming from", false);
		
		puzz1.addScript(9, "There's just different types of indoor plants here and some smell I can't find the source of...", false);
		
		puzz1.addScript(10, "I found where the smell's coming from! Yey!", false);
		puzz1.addScript(10, "It's from a scented paper hidden under one of the pots", false);
		puzz1.addScript(10, "The paper states: \"Current code: Take this number, add twelve twice, add 6 thrice, and get 52, nice\"", false);
		puzz1.addScript(10, "Huh? I don't understand...", false);
		puzz1.addScript(10, "Ohh wait... There's a hidden safe right where I got the paper", false);
		puzz1.addScript(10, "Now how do I open this?", false);
		
		puzz1.addScript(35, "The paper states: \"Current code: Take this number, add twelve twice, add 6 thrice, and get 52, nice\"", false);
		
		puzz1.addScript(11, "Yes! It opened!", false);
		puzz1.addScript(11, "Pssh...I knew that was the answer, I was just checking if you know it too...", false);
		puzz1.addScript(11, "Amazing! There's a small box hidden here!", false);
		puzz1.addScript(11, "It sounds like it has something inside it", false);
		puzz1.addScript(11, "But how do I open this? There's no passcode needed or something of the like", false);
		
		puzz1.addScript(12, "Oops! Wrong code! Value is between 6 and 15...", false);
		
		puzz1.addScript(13, "So that was the use of the key!", false);
		puzz1.addScript(13, "Who would have thought that that small key can be used for something in this room", false);
		puzz1.addScript(13, "Huh?? There's nothing inside this box...", false);
		puzz1.addScript(13, "It looks like a paper was recently taken out since I can see a freshly ripped piece of paper", false);	
		
		puzz1.addScript(14, "I found a small key, but what can I use it for?", false);
		
		puzz1.addScript(15, "It's just an empty box aside from a ripped piece of paper: \"Dear E...\"", false);
		
		puzz1.addScript(16, "There's a cup of coffee here", false);
		puzz1.addScript(16, "It's still a bit warm, I wonder if the kidnapper will come back for this", false);
		puzz1.addScript(16, "There's a chair right beside the table", false);
		puzz1.addScript(16, "Wait... Let me check it out...", false);
		puzz1.addScript(16, "Ohh wow! It's a recliner and made of genuine leather!", false);
		puzz1.addScript(16, "I wonder if my kidnapper is rich since he was able to afford this", false);
		
		puzz1.addScript(17, "Not much here except for a recliner made of genuine leather, must be owned by a rich person...", false);
		
		puzz1.addScript(18, "Wow! It's sooo comfortable!", false);
		puzz1.addScript(18, "This makes me want to read a book or sleep", false);
		puzz1.addScript(18, "I know I shouldn't though, so let me unrecline this chair", false);
		puzz1.addScript(18, "Huh? What's this under the handle", false);
		puzz1.addScript(18, "There's a note carved on the leather: \"What is 3/7 chicken, 2/3 cat, and a half goat?\"", false);
		puzz1.addScript(18, "(CHICAGO)", false);
		
		puzz1.addScript(36, "Note carved on the leather: \"What is 3/7 chicken, 2/3 cat, and a half goat?\"", false);
		puzz1.addScript(36, "What does this mean?", false);
		
		puzz1.addScript(19, "Incorrect password... It is also a rock band, a musical, and a state", false);
		
		puzz1.addScript(20, "There's a box hidden inside", false);
		puzz1.addScript(20, "There's so much pictures here and all of it has me in it!", false);
		puzz1.addScript(20, "Some pictures were from high school, but most are just recent photos!", false);
		puzz1.addScript(20, "Why and how did he get these photos?", false);
		puzz1.addScript(20, "What's my relationship with the kidnapper?!", false);
		
		puzz1.addScript(21, "There's pictures here from my high school days until my most recent activities", false);
		puzz1.addScript(21, "How did he get these and how are we connected?", false);
		
		puzz1.addScript(22, "It looks like an image of the Abduction of Psyche", false);
		puzz1.addScript(22, "I love Greek and Roman mythology so I can tell that this is Cupid and Psyche", false);
		puzz1.addScript(22, "Ohh how I love the story of what Cupid did for his loved one", false);
		puzz1.addScript(22, "Despite the choices Psyche did, Cupid kept on loving and helping her all through-out", false);
		puzz1.addScript(22, "Maybe the kidnapper also likes their story...", false);
		
		puzz1.addScript(23, "It's an image of the Abduction of Psyche", false);
		
		puzz1.addScript(24, "*creaking sounds*", false);
		puzz1.addScript(24, "Ohh! There's a broken tile by my foot", false);
		puzz1.addScript(24, "It looks like it's been deliberately removed as if to hide something important", false);
		puzz1.addScript(24, "Hmm...", false);
		puzz1.addScript(24, "I was right! There's a note here:", false);
		puzz1.addScript(24, "\"If 2 + 3 = 5, 3 + 7 = 17, 4 + 5 = 19 and 5 + 8 = 37, then what is 6 + 7?\"", false);
		puzz1.addScript(24, "I wonder what's this for?", false);
		
		puzz1.addScript(37, "The note says: \"If 2 + 3 = 5, 3 + 7 = 17, 4 + 5 = 19 and 5 + 8 = 37, then what is 6 + 7?\"", false);
		puzz1.addScript(37, "The number should be between 40 and 50", false);
		puzz1.addScript(37, "What's this for?", false);
		
		puzz1.addScript(25, "There's a safe behind the portrait and its asking for a fingerprint or a code", false);
		puzz1.addScript(25, "This vault probably contains my kidnapper's secrets", false);
		puzz1.addScript(25, "Let's try to unlock it... but how?", false);
		
		puzz1.addScript(26, "Its asking for a fingerprint or a code", false);
		puzz1.addScript(26, "What code?", false);
		
		puzz1.addScript(27, "It was the wrong code... How do I open this?", false);
		
		puzz1.addScript(28, "It opened! You're a genius!", false);
		puzz1.addScript(28, "How did you figure out the code?...", false);
		puzz1.addScript(28, "Inside the vault is a torn off piece of paper", false);
		puzz1.addScript(28, "It looks like a collection of quotes:", false);
		puzz1.addScript(28, "\"It sucks when you know that you need to let go, but you can't, because you're still waiting for the impossible to happen.", false);
		puzz1.addScript(28, "I will always have this impossible little hope that you'll suddenly wake up one day and realize we're meant to be together.", false);
		puzz1.addScript(28, "I'm at such a dilemma. I want to distance myself from you, but yet, I don't want to lose you.", false);
		puzz1.addScript(28, "It hurts to let go, but sometimes it hurts more to hold on.", false);
		puzz1.addScript(28, "There's a note on the back...", false);
		puzz1.addScript(28, "\"It's now time for me to let you go. I'm sorry for all the things I have done. I kidnapped you so that in some way, you will still remember the good memories we had through the photos. Whatever is surrounding is now yours. You will not see me again. Farewell!\"", false);
		puzz1.addScript(28, "...", false);
		puzz1.addScript(28, "I recognize this handwriting! It's Charley's!", false);
		puzz1.addScript(28, "I can't forgive him yet but maybe time will heal my wounds...", false);
		
		puzz1.addScript(29, "The vault behind the portrait had a list of quotes and a note from Charley...", false);
		
		puzz1.addScript(30, "Note: \"Be ready to be killed at any time!\"", false);
		puzz1.addScript(30, "I wonder how long I've been here...", false);
		
		puzz1.addScript(31, "There's an intercom here and whatever button I press, it keeps repeating: \"What's my name?\"", false);
		puzz1.addScript(31, "Whatever that name is I know that that's my only way out of here!", false);
		
		puzz1.addScript(32, "\"That's not my name!!!\"", false);
		puzz1.addScript(32, "*silence*", false);
		
		puzz1.addScript(38, "Password: \"What's my name?\"", false);
		
		puzz1.addScript(33, "It worked! The intercom responded: \"Yes! That's my name!\"", false);
		puzz1.addScript(33, "The door is opening!", false);
		puzz1.addScript(33, "Thank you! I don't know what I would have done without you!", false);
		
		puzz1.addScript(39, "Great job! You have completed the story and exited the room successfully!", false);

		puzz1.addProblem("isCabinetOpen");
		puzz1.addProblem("isSuitcaseOpen");
		puzz1.addProblem("isRoomExamined");

		
		addPuzzle(puzz1);
		
		Puzzle puzz2 = new Puzzle(15, 40);
		
		puzz2.addScript(1, "Hi", false);
		puzz2.addScript(1, "I found this phone here with your number as the only contact", false);
		puzz2.addScript(1, "I've been kidnapped and locked in a room I'm not familiar with", false);
		puzz2.addScript(1, "Someone was just asking me for directions and next thing you know I'm in this room", false);
		puzz2.addScript(1, "I need your help in escaping this room before the kidnapper kills me!", false);
		puzz2.addScript(1, "> Hello", false);
		puzz2.addScript(1, "> How do you know the kidnapper's going to kill you?", false);
		puzz2.addScript(1, "I found a note beside the phone that says I have a limited time before he kills me", false);
		puzz2.addScript(1, "He didnt say how much time I've got but I have to get out of here fast!", false);
		puzz2.addScript(1, "I'm feelings chills down my spine and I don't know where to start looking for a way out of this room...", false);
		
		puzz2.addScript(2, "There's all sorts of books here, from children's books to professional books", false);
		puzz2.addScript(2, "There are also novels like Harry Potter, the Percy Jackson series, The Kite Runner, Catcher in the Rye and Number the Stars", false);
		puzz2.addScript(2, "But the ones that stand out and looks like it's been read multiple times are A Study in Scarlet, The Hound of Baskervilles, and Hamlet", false);
		
		puzz2.addScript(40, "These books stand out the most: A Study in Scarlet, The Hound of Baskervilles, and Hamlet", false);
		
		puzz2.addScript(3, "I pulled out The Hound of Baskervilles and it opened to a page with highlights on \"That which is clearly known hath less terror than that which is but hinted at and guessed.\"", false);
		puzz2.addScript(3, "What does this even mean?", false);
		puzz2.addScript(3, "Ohh wait...There's a compartment within a book looking for a password...", false);
		puzz2.addScript(3, "And a note fell down: \"Which creature walks on four legs in the morning, two legs in the afternoon, and three legs in the evening?\"", false);
		puzz2.addScript(3, "Huh?! This riddle sounds complicated...", false);
		
		puzz2.addScript(34, "This line of the book was highlighted: \"That which is clearly known hath less terror than that which is but hinted at and guessed.\"", false);
		puzz2.addScript(34, "There's also a note that says: \"Which creature walks on four legs in the morning, two legs in the afternoon, and three legs in the evening?\"", false);
		puzz2.addScript(34, "What does this mean?", false);
		
		puzz2.addScript(4, "That's right! A man uses four limbs as a toddler, two feet as an adult, two feet and a walking stick as an elderly.", false);
		puzz2.addScript(4, "Why did I not think of that earlier?", false);
		puzz2.addScript(4, "There's a small key here", false);
		puzz2.addScript(4, "(auto-get small key)", false);
		puzz2.addScript(4, "I wonder if this has a use somewhere...", false);
		
		puzz2.addScript(5, "No, that doesn't seem to work", false);
		
		puzz2.addScript(6, "Nothing significant about this book except that it's about Sherlock Holmes and Dr. Watson", false);
		
		puzz2.addScript(7, "I opened Hamlet and it went to a page with highlights on \"One may smile, and smile, and be a villain.\"", false);
		puzz2.addScript(7, "This sounds like a hidden note that the kidnapper left me and I'm scared...", false);
		
		puzz2.addScript(30, "Note: \"Be ready to be killed at any time!\"", false);
		puzz2.addScript(30, "I wonder how long I've been here...", false);
		
		
		
		puzz2.addProblem("isHoundChecked");
		puzz2.addProblem("isBottomChecked");
		puzz2.addProblem("isPlantsChecked");
		
		addPuzzle(puzz2);
	}
	
}
