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
		
		puzz1.addScript(8, "It's locked. Well, this door isn't that easy to kick down. They're definitely not eager to let me out", false);
		puzz1.addScript(8, "Hmmm... There is no handle, no keyhole", false);
		puzz1.addScript(8, "There is a phone hanging next to the door. I wonder hwat is it for?", false);
		
		puzz1.addScript(9, "I've already tried opening the door. I failed", false);
		
		puzz1.addScript(10, "Hello? Who are you?", false);
		puzz1.addScript(10, "The voice keeps repeating the same phrase, it doesn't react to my words", false);
		puzz1.addScript(10, "It's a record of some famous expression; I understand this language, and it seems to be Latin: \"A friend of my friend is my my friend...", false);
		
		puzz1.addScript(11, "Yes, it's definitely Latin, it means something like... \"A friend of my fried is my friend...\" ...So strange...", false);
		puzz1.addScript(11, "Where the hell do I even know it from?!", false);
		
		puzz1.addScript(12, "Do you suggest talking to the answering machine? Well, ok, let's give it a try", false);
		puzz1.addScript(12, "What should I say?", false);
		
		puzz1.addScript(13, "Let's try again", false);
		
		puzz1.addScript(14, "Nothing happened, the voice keeps repeating the same message", false);
		
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
		puzz1.addScript(31, "\"April 15, 2006. Huh, I'm back in the game! The key of all doors- \"viva\"", false);
		puzz1.addScript(31, "I don't understand a thing", false);
		puzz1.addScript(31, "Friend, there are no more entries. I must've gotten so engaged in the game that I had no time to keep writing in my diary...", false);
		puzz1.addScript(31, "But why did I hide this entry?", false);
		
		puzz1.addScript(32, "The last entry in the diary: \"Huh, I'm back in the game! Viva!\"", false);

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
		
		
		addPuzzle(puzz2);
		
		Puzzle puzz3 = new Puzzle(15, 40);
		
		puzz3.addScript(1, "My mom is knocking on the door.", false);
		puzz3.addScript(1, "(Door suddenly opens)", false);
		puzz3.addScript(1, "\"Charley's mom called. She said to check your email as soon as possible. I should go to work, bye.\"", false);
		puzz3.addScript(1, "(Mom leaves and closes the door)", false);
		
		puzz3.addScript(2, "Wait let me check my email...", false);
		puzz3.addScript(2, "My mom was right!", false);
		puzz3.addScript(2, "There's an email from Charley's mom!", false);
		puzz3.addScript(2, "It says:", false);
		puzz3.addScript(2, "\"I need your help. Do you know where Charley is?", false);
		puzz3.addScript(2, "He said he will go camping with you in the woods.", false);
		puzz3.addScript(2, "I'm worried for him. He has not texted or called me since yesterday.", false);
		puzz3.addScript(2, "He just left this note by his bed. I dont know what he meant about this.", false);
		puzz3.addScript(2, "Please come by our house once you read this!\"", false);
		puzz3.addScript(2, "The note says:", false);
		puzz3.addScript(2, "\"...\"", false);
		
		puzz3.addScript(3, "It feels so nice to be at my own bed.", false);
		puzz3.addScript(3, "I wonder if there's a continuation to my dream earlier?", false);
		
		puzz3.addScript(4, "You're right, maybe I should go to Charley's house first.", false);
		puzz3.addScript(4, "(At Charley's house)", false);
		puzz3.addScript(4, "There's no answer when I ring the doorbell...", false);
		puzz3.addScript(4, "The door is open so I'll just go in", false);
		puzz3.addScript(4, "Ohh, there's a note here by the entrance: ", false);
		puzz3.addScript(4, "\"Just check Charley's bedroom. - Charley's mom\"", false);
		
		puzz3.addScript(5, "There's nothing unusual in his room.", false);
		puzz3.addScript(5, "Things are as I remember them...", false);
		puzz3.addScript(5, "Except for the box in his bed!", false);
		puzz3.addScript(5, "Oh! Something is needed to open this box.", false);
		
		puzz3.addScript(6, "Incorrect password...", false);
		
		puzz3.addScript(7, "Ahaahh!! It opened.", false);
		puzz3.addScript(7, "There is a paper that has an address in it.", false);
		puzz3.addScript(7, "Maybe this is were Charley is.", false);
		puzz3.addScript(7, "ADDRESS: Paravinci's Italian Bistro, 2802 Colorado Avenue, Colorado Springs, CO 80904, United States", false);
		puzz3.addScript(7, "It's not that far from here.", false);
		puzz3.addScript(7, "I should head for it immediately.", false);
		puzz3.addScript(7, "(Paravinci's Italian Bistro)", false);
		puzz3.addScript(7, "I can't find him... Let me ask the waiter", false);
		puzz3.addScript(7, "Hi! I'm looking for Charley. Is he here?", false);
		puzz3.addScript(7, "Waiter: \"Hello! Sorry he's not here but he told me to give this if ever someone looks for him. Here you go\"", false);
		puzz3.addScript(7, "The waiter handed me a suitcase with a lock and a note.", false);
		
		puzz3.addScript(8, "Incorrect password...", false);
		
		puzz3.addScript(9, "Wrong answer...", false);
		
		puzz3.addScript(10, "Finally it opened. ", false);
		puzz3.addScript(10, "There is a piece of paper here that says \"Pikes Peak, High Point, El Paso County, Colorado, United States\"", false);
		puzz3.addScript(10, "Is he playing games with me now? What is he up to? ", false);
		puzz3.addScript(10, "I should go directly so that my questions would be answered.", false);
		puzz3.addScript(10, "(Pikes Peak)", false);
		puzz3.addScript(10, "\"Surprise!!!\"", false);
		puzz3.addScript(10, "It's Charley.", false);
		puzz3.addScript(10, "What is this all about Charley?", false);
		puzz3.addScript(10, "We are worried sick about you. Don't you realize that?", false);
		puzz3.addScript(10, "\"Oh I'm sorry. I just find this place as the perfect one to do this.\"", false);
		puzz3.addScript(10, "To do what?!", false);
		puzz3.addScript(10, "(Charley kneels down on one knee)", false);
		puzz3.addScript(10, "\"I've known you my whole life. We experienced many things together. Even the challenges of life, we surpassed it together.\"", false);
		puzz3.addScript(10, "\"You brought color in my darkest times. You gave meaning to my life.\"", false);
		puzz3.addScript(10, "\"And now I know this is the right time for this.\"", false);
		puzz3.addScript(10, "\"Demetria Devonne Jonas, will you spend the rest of your life with me? Will you marry me?\"", false);
		puzz3.addScript(10, "Yess!! A hundred times yes!", false);
		puzz3.addScript(10, "Why do I have to go through a lot of challenges and riddles just to be engaged to someone I love?", false);
		puzz3.addScript(10, "\"HAHAHAHA! I bet  you'd say that :)\"", false);
		
		puzz3.addScript(11, "Congratulations!! You've finished the story.", false);
		
	}
	
}
