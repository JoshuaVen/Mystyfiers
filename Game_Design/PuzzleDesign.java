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
		Puzzle puzz2 = new Puzzle(20, 55);
		
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
		
		puzz2.addScript(8, "I see a Peace Lily, an Areca Palm, some Birds of Paradise, and a small Bamboo plant", false);
		puzz2.addScript(8, "I can't recognize the others though", false);
		puzz2.addScript(8, "Something smells nice but I can't figure out where its coming from", false);
		
		puzz2.addScript(9, "There's just different types of indoor plants here and some smell I can't find the source of...", false);
		
		puzz2.addScript(10, "I found where the smell's coming from! Yey!", false);
		puzz2.addScript(10, "It's from a scented paper hidden under one of the pots", false);
		puzz2.addScript(10, "The paper states: \"Current code: Take this number, add twelve twice, add 6 thrice, and get 52, nice\"", false);
		puzz2.addScript(10, "Huh? I don't understand...", false);
		puzz2.addScript(10, "Ohh wait... There's a hidden safe right where I got the paper", false);
		puzz2.addScript(10, "Now how do I open this?", false);
		
		puzz2.addScript(35, "The paper states: \"Current code: Take this number, add twelve twice, add 6 thrice, and get 52, nice\"", false);
		
		puzz2.addScript(11, "Yes! It opened!", false);
		puzz2.addScript(11, "Pssh...I knew that was the answer, I was just checking if you know it too...", false);
		puzz2.addScript(11, "Amazing! There's a small box hidden here!", false);
		puzz2.addScript(11, "It sounds like it has something inside it", false);
		puzz2.addScript(11, "But how do I open this? There's no passcode needed or something of the like", false);
		
		puzz2.addScript(12, "Oops! Wrong code! Value is between 6 and 15...", false);
		
		puzz2.addScript(13, "So that was the use of the key! ", false);
		puzz2.addScript(13, "Who would have thought that that small key can be used for something in this room", false);
		puzz2.addScript(13, "Huh?? There's nothing inside this box...", false);
		puzz2.addScript(13, "It looks like a paper was recently taken out since I can see a freshly ripped piece of paper", false);
		
		puzz2.addScript(14, "I found a small key, but what can I use it for?", false);
		
		puzz2.addScript(15, "It's just an empty box aside from a ripped piece of paper: \"Dear D...\"", false);
		
		puzz2.addScript(16, "There's a cup of coffee here", false);
		puzz2.addScript(16, "It's still a bit warm, I wonder if the kidnapper will come back for this", false);
		puzz2.addScript(16, "There's a chair right beside the table", false);
		puzz2.addScript(16, "Wait... Let me check it out...", false);
		puzz2.addScript(16, "Ohh wow! It's a recliner and made of genuine leather!", false);
		puzz2.addScript(16, "I wonder if my kidnapper is rich since he was able to afford this", false);
		
		puzz2.addScript(17, "Not much here except for a recliner made of genuine leather, must be owned by a rich person...", false);
		
		puzz2.addScript(18, "Wow! It's sooo comfortable!", false);
		puzz2.addScript(18, "This makes me want to read a book or sleep", false);
		puzz2.addScript(18, "I know I shouldn't though, so let me unrecline this chair", false);
		puzz2.addScript(18, "Huh? What's this under the handle", false);
		puzz2.addScript(18, "There's a note carved on the leather: \"What is 3/7 chicken, 2/3 cat, and a half goat?\"", false);
		
		puzz2.addScript(36, "Note carved on the leather: \"What is 3/7 chicken, 2/3 cat, and a half goat?\"", false);
		puzz2.addScript(36, "What does this mean?", false);
		
		puzz2.addScript(19, "Incorrect password... It is also a rock band, a musical, and a state", false);
		
		puzz2.addScript(20, "There's a box hidden inside", false);
		puzz2.addScript(20, "There's so much pictures here and all of it has me in it!", false);
		puzz2.addScript(20, "Some pictures were from high school, but most are just recent photos!", false);
		puzz2.addScript(20, "Why and how did he get these photos?", false);
		puzz2.addScript(20, "What's my relationship with the kidnapper?!", false);
		
		puzz2.addScript(21, "There's pictures here from my high school days until my most recent activities", false);
		puzz2.addScript(21, "How did he get these and how are we connected?", false);
		
		puzz2.addScript(22, "It looks like an image of the Abduction of Psyche", false);
		puzz2.addScript(22, "I love Greek and Roman mythology so I can tell that this is Cupid and Psyche", false);
		puzz2.addScript(22, "Ohh how I love the story of what Cupid did for his loved one", false);
		puzz2.addScript(22, "Despite the choices Psyche did, Cupid kept on loving and helping her all through-out", false);
		puzz2.addScript(22, "Maybe the kidnapper also likes their story...", false);
		
		puzz2.addScript(23, "It's an image of the Abduction of Psyche", false);
		
		puzz2.addScript(24, "*creaking sounds*", false);
		puzz2.addScript(24, "Ohh! There's a broken tile by my foot", false);
		puzz2.addScript(24, "It looks like it's been deliberately removed as if to hide something important", false);
		puzz2.addScript(24, "Hmm...", false);
		puzz2.addScript(24, "I was right! There's a note here:", false);
		puzz2.addScript(24, "\"If 2 + 3 = 5, 3 + 7 = 17, 4 + 5 = 19 and 5 + 8 = 37, then what is 6 + 7?\"", false);
		puzz2.addScript(24, "I wonder what's this for?", false);
		
		puzz2.addScript(37, "The note says: \"If 2 + 3 = 5, 3 + 7 = 17, 4 + 5 = 19 and 5 + 8 = 37, then what is 6 + 7?\"", false);
		puzz2.addScript(37, "The number should be between 40 and 50", false);
		puzz2.addScript(37, "What's this for?", false);
		
		puzz2.addScript(25, "There's a safe behind the portrait and its asking for a fingerprint or a code", false);
		puzz2.addScript(25, "This vault probably contains my kidnapper's secrets", false);
		puzz2.addScript(25, "Let's try to unlock it... but how?", false);
		
		puzz2.addScript(26, "Its asking for a fingerprint or a code", false);
		puzz2.addScript(26, "What code?", false);
		
		puzz2.addScript(27, "It was the wrong code... How do I open this?", false);
		
		puzz2.addScript(28, "It opened! You're a genius!", false);
		puzz2.addScript(28, "How did you figure out the code?...", false);
		puzz2.addScript(28, "Inside the vault is a torn off piece of paper", false);
		puzz2.addScript(28, "It looks like a collection of quotes:", false);
		puzz2.addScript(28, "\"It sucks when you know that you need to let go, but you can't, because you're still waiting for the impossible to happen.", false);
		puzz2.addScript(28, "I will always have this impossible little hope that you'll suddenly wake up one day and realize we're meant to be together.", false);
		puzz2.addScript(28, "I'm at such a dilemma. I want to distance myself from you, but yet, I don't want to lose you.", false);
		puzz2.addScript(28, "It hurts to let go, but sometimes it hurts more to hold on.", false);
		puzz2.addScript(28, "There's a note on the back...", false);
		puzz2.addScript(28, "\"It's now time for me to let you go. I'm sorry for all the things I have done. I kidnapped you so that in some way, you will still remember the good memories we had through the photos. Whatever is surrounding is now yours. You will not see me again. Farewell!\"", false);
		puzz2.addScript(28, "...", false);
		puzz2.addScript(28, "I recognize this handwriting! It's Charley's!", false);
		puzz2.addScript(28, "I can't forgive him yet but maybe time will heal my wounds...", false);
		
		puzz2.addScript(29, "The vault behind the portrait had a list of quotes and a note from Charley...", false);
		
		puzz2.addScript(31, "There's an intercom here and whatever button I press, it keeps repeating: \"What's my name?\"", false);
		puzz2.addScript(31, "Whatever that name is I know that that's my only way out of here!", false);
		
		puzz2.addScript(32, "\"That's not my name!!!\"", false);
		puzz2.addScript(32, "*silence*", false);
		
		puzz2.addScript(38, "Password: \"What's my name?\"", false);
		
		puzz2.addScript(33, "It worked! The intercom responded: \"Yes! That's my name!\"", false);
		puzz2.addScript(33, "The door is opening!", false);
		puzz2.addScript(33, "(A sudden sound caught you in surprise)", false);
		puzz2.addScript(33, "(You hear someone knocking on the door)", false);
		puzz2.addScript(33, "Wait what?! Was it just a dream?!", false);
		puzz2.addScript(33, "Thank god, it was just a dream!!! ", false);
		
		puzz2.addScript(39, "Great job! You have completed the first part of the story.", false);
		
		
		puzz2.addProblem("isHoundChecked");
		puzz2.addProblem("isPlantsChecked");
		puzz2.addProblem("isCoffeeChecked");
		puzz2.addProblem("isPortraitChecked");
		//puzz2.addProblem("isDoorChecked");
		
		puzz2.addScript(41, "My mom is knocking on the door.", false);
		puzz2.addScript(41, "(Door suddenly opens)", false);
		puzz2.addScript(41, "\"Charley's mom called. She said to check your email as soon as possible. I should go to work, bye.\"", false);
		puzz2.addScript(41, "(Mom leaves and closes the door)", false);
		
		puzz2.addScript(41, "Wait let me check my email...", false);
		puzz2.addScript(41, "My mom was right!", false);
		puzz2.addScript(41, "There's an email from Charley's mom!", false);
		puzz2.addScript(41, "It says:", false);
		puzz2.addScript(41, "\"I need your help. Do you know where Charley is?", false);
		puzz2.addScript(41, "He said he will go camping with you in the woods.", false);
		puzz2.addScript(41, "I'm worried for him. He has not texted or called me since yesterday.", false);
		puzz2.addScript(41, "He just left this note by his bed. I dont know what he meant about this.", false);
		puzz2.addScript(41, "Please come by our house once you read this!\"", false);
		
		puzz2.addScript(42, "The note attached in the email says:", false);
		puzz2.addScript(42, "\"CALCULATE CAREFULLY... 55-25-(5-95)=?", false);
		puzz2.addScript(42, "YOU MAY NOT BELIEVE IT, BUT THIS EQUALS 5!\"", false);
		
		puzz2.addScript(43, "It feels so nice to be at my own bed.", false);
		puzz2.addScript(43, "I wonder if there's a continuation to my dream earlier?", false);
		
		puzz2.addScript(44, "You're right, maybe I should go to Charley's house first.", false);
		puzz2.addScript(44, "(At Charley's house)", false);
		puzz2.addScript(44, "There's no answer when I ring the doorbell...", false);
		puzz2.addScript(44, "The door is open so I'll just go in", false);
		puzz2.addScript(44, "Ohh, there's a note here by the entrance: ", false);
		puzz2.addScript(44, "\"Just check Charley's bedroom. - Charley's mom\"", false);

		puzz2.addScript(45, "There's nothing unusual in his room.", false);
		puzz2.addScript(45, "Things are as I remember them...", false);
		puzz2.addScript(45, "Except for the box in his bed!", false);
		puzz2.addScript(45, "Oh! Something is needed to open this box.", false);
		puzz2.addScript(45, "It's looking for a code", false);
		
		puzz2.addScript(46, "I need a code to open the box", false);
		puzz2.addScript(46, "I wonder what it is...", false);
		
		puzz2.addScript(47, "Incorrect password...", false);
		
		puzz2.addScript(48, "Ahaahh!! It opened.", false);
		puzz2.addScript(48, "There is a paper that has an address in it.", false);
		puzz2.addScript(48, "Maybe this is were Charley is.", false);
		puzz2.addScript(48, "ADDRESS: Paravinci's Italian Bistro, 2802 Colorado Avenue, Colorado Springs, CO 80904, United States", false);
		puzz2.addScript(48, "It's not that far from here.", false);
		puzz2.addScript(48, "I should head for it immediately.", false);
		puzz2.addScript(48, "(Paravinci's Italian Bistro)", false);
		puzz2.addScript(48, "I can't find him... Let me ask the waiter", false);
		puzz2.addScript(48, "Hi! I'm looking for Charley. Is he here?", false);
		puzz2.addScript(48, "Waiter: \"Hello! Sorry he's not here but he told me to give this if ever someone looks for him. Here you go\"", false);
		puzz2.addScript(48, "The waiter handed me a suitcase with a lock and a note.", false);
		puzz2.addScript(48, "The note says: \"If Mercury=1167, Venus=2145, Earth=3165, Mars=4164, Saturn=6246, then Jupiter=?\"", false);
		
		puzz2.addScript(49, "I got the suitcase with a lock.", false);
		puzz2.addScript(49, "The note says: \"If Mercury=1167, Venus=2145, Earth=3165, Mars=4164, Saturn=6246, then Jupiter=?\"", false);
		
		puzz2.addScript(50, "Wrong answer... ", false);
		
		puzz2.addScript(51, "Finally it opened. ", false);
		puzz2.addScript(51, "There is a piece of paper here that says \"Pikes Peak, High Point, El Paso County, Colorado, United States\"", false);
		puzz2.addScript(51, "Is he playing games with me now? What is he up to? ", false);
		puzz2.addScript(51, "I should go directly so that my questions would be answered.", false);
		puzz2.addScript(51, "(Pikes Peak)", false);
		puzz2.addScript(51, "\"Surprise!!!\"", false);
		puzz2.addScript(51, "It's Charley.", false);
		puzz2.addScript(51, "What is this all about Charley?", false);
		puzz2.addScript(51, "We are worried sick about you. Don't you realize that?", false);
		puzz2.addScript(51, "\"Oh I'm sorry. I just find this place as the perfect one to do this.\"", false);
		puzz2.addScript(51, "To do what?!", false);
		puzz2.addScript(51, "(Charley kneels down on one knee)", false);
		puzz2.addScript(51, "\"I've known you my whole life. We experienced many things together. Even the challenges of life, we surpassed it together.\"", false);
		puzz2.addScript(51, "\"You brought color in my darkest times. You gave meaning to my life.\"", false);
		puzz2.addScript(51, "\"And now I know this is the right time for this.\"", false);
		puzz2.addScript(51, "\"Demetria Devonne Jonas, will you spend the rest of your life with me? Will you marry me?\"", false);
		puzz2.addScript(51, "Yess!! A hundred times yes!", false);
		puzz2.addScript(51, "Why do I have to go through a lot of challenges and riddles just to be engaged to someone I love?", false);
		puzz2.addScript(51, "\"HAHAHAHA! I bet  you'd say that :)\"", false);
		
		puzz2.addScript(52, "Congratulations!! You've finished the story.", false);

	    puzz2.addScript(53, "Do you want to play again", false);
	    
	    puzz2.addScript(54, "Do you want to continue the story?", false);

	    addPuzzle(puzz2);
		
	}
	
}
