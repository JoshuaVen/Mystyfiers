import java.util.Scanner;
// a class that contains the choices and how the game progresses
public class GameFlow {
	PuzzleDesign puzzles;
	int current;

	GameFlow() {
		this.puzzles = new PuzzleDesign();
		this.current = 1;
		start2();
	}
	
	private void display(int scriptNum) {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < puzzles.puzzDes[0].actualSizeOfSc(scriptNum); i++) {
			System.out.print(puzzles.puzzDes[0].textSc[scriptNum - 1][i].read());
			in.nextLine();
		}
		System.out.println(puzzles.puzzDes[0].updateCounter());
	}

	private void branchDisplay(int ifScript, int elseScript) {
		if (puzzles.puzzDes[0].textSc[ifScript - 1][0].isRead == false) {
			display(ifScript);
		} else {
			display(elseScript);
		}
	}
	
	private void start2() {
		Scanner in = new Scanner(System.in);
		
		display(1);
		options(1);
		
		in.close();
	}
	
	private void options(int i) {
		System.out.println("(P - go near the portrait) (B - go near the bookshelf) (C - check the plants) (T - go to coffee table) (D - come closer to the door)");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String com = in.nextLine();
		switch (com.toUpperCase()) {
		case "P":
			portrait();
			break;
		case "B":
			bookshelf();
			break;
		case "C":
			plants();
			break;
		case "T":
			coffee();
			break;
		case "D":
			//door();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			options(i);
			break;		
		}
		in.close();
	} 
	
	private void bookshelf() {
		Scanner in = new Scanner(System.in);
		branchDisplay(2, 40);
		System.out.println("(S - check 'A Study in Scaret') (B- check 'The Hound of Baskervilles') (H - check 'Hamlet') (G - go back to table)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "S":
			scarlet();
			break;
		case "B":
			basker();
			break;
		case "H":
			hamlet();
			break;
		case "G":
			goBack();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			bookshelf();
			break;		
		}
		in.close();
	}
	
	private void scarlet() {
		Scanner in = new Scanner(System.in);
		display(6);
		System.out.println("(C - continue searching bookshelf) (G - go back to table)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			bookshelf();
			break;
		case "G":
			goBack();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			bookshelf();
			break;		
		}
		in.close();
	}
	
	private void basker() {
		if (puzzles.puzzDes[0].checkProblemIfSolved("isHoundChecked") == false) {
			branchDisplay(3, 34);
		} else {
			display(14);
			goBack();
		}
		Scanner in = new Scanner(System.in);
		System.out.println("(C - continue searching bookshelf) (E - enter solution) (G - go back to table)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			bookshelf();
			break;
		case "E":
			pass1();
			break;
		case "G":
			goBack();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			bookshelf();
			break;		
		}
		in.close();
	}
	
	private void pass1() {
		System.out.println("Enter text message: ");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		String pass = new String("man");
		command = command.toLowerCase();
		if (!command.matches(pass) ) {
			display(5);
			basker();
		} else if (command.matches(pass)) {
			display(4);
			puzzles.puzzDes[0].changeToSolved("isHoundChecked");
			goBack();
		} else {
			basker();
		}
		in.close();
	}
	
	private void hamlet() {
		Scanner in = new Scanner(System.in);
		display(7);
		System.out.println("(C - continue searching bookshelf) (G - go back to table)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			bookshelf();
			break;
		case "G":
			goBack();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			bookshelf();
			break;		
		}
		in.close();
	}
	
	private void plants() {
		if (puzzles.puzzDes[0].checkProblemIfSolved("isPlantsChecked") == false) {
			branchDisplay(8, 9);
		} else {
			display(15);
			goBack();
		}
		Scanner in = new Scanner(System.in);
		System.out.println("(C - check bottom of pots)(G - go back to table)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			bottom();
			break;
		case "G":
			goBack();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			plants();
			break;		
		}
		in.close();
	}
	
	private void bottom() {
		branchDisplay(10, 35);
		Scanner in = new Scanner(System.in);
		System.out.println("(E - enter solution) (G - go back to table)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "E":
			pass2();
			break;
		case "G":
			goBack();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			bottom();
			break;		
		}
		in.close();
	}
	
	private void pass2() {
		System.out.println("Enter code: ");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		int code = in.nextInt();
		if (code == 10) {
			display(11);
			puzzles.puzzDes[0].changeToSolved("isBottomChecked");
			goBack();
		} else if (code != 10) {
			display(12);
			bottom();
		} else {      //expected for no input, not yet working
			goBack();
		}
		in.close();
	}
	
	private void pass3() {
		System.out.println("(U - Use key) (G - Go back to the table)");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "U":
			display(13);
			break;
		case "G":
			goBack();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			pass3();
			break;		
		}
		in.close();
		
	}
	
	private void coffee() {
		if (puzzles.puzzDes[0].checkProblemIfSolved("isCoffeeChecked") == false) {
			branchDisplay(16, 17);
		} else {
			display(21);
			goBack();
		}
		Scanner in = new Scanner(System.in);
		System.out.println("(R - recline the chair)(G - go back to table)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "R":
			recline();
			break;
		case "G":
			goBack();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			coffee();
			break;		
		}
		in.close();
	}
	
	private void recline() {
		branchDisplay(18, 36);
		Scanner in = new Scanner(System.in);
		System.out.println("(T - type password) (G - go back to table)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "T":
			pass4();
			break;
		case "G":
			goBack();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			recline();
			break;		
		}
		in.close();
	}
	
	private void pass4() {
		System.out.println("Enter the answer: ");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		String pass = new String("Chicago");
		command = command.toLowerCase();
		if (!command.matches(pass) ) {
			display(19);
			recline();
		} else if (command.matches(pass)) {
			display(20);
			puzzles.puzzDes[0].changeToSolved("isCoffeeChecked");
			goBack();
		} else {
			coffee();
		}
		in.close();
	}
	
	private void portrait() {
		if (puzzles.puzzDes[0].checkProblemIfSolved("isPortraitChecked") == false) {
			branchDisplay(22, 23);
		} else {
			display(29);
			goBack();
		}
		Scanner in = new Scanner(System.in);
		System.out.println("(T - try to take it off)(G - go back to table)(C - Check broken tile)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "T":
			take();
			break;
		case "G":
			goBack();
			break;
		case "C":
			brokenTile();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			portrait();
			break;		
		}
		in.close();
	}
	
	private void take() {
		branchDisplay(25, 26);
		Scanner in = new Scanner(System.in);
		System.out.println("(E - enter code) (G - go back to table)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "E":
			pass5();
			break;
		case "G":
			goBack();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			take();
			break;		
		}
		in.close();
	}
	
	private void pass5() {
		System.out.println("Enter code: ");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		int code = in.nextInt();
		if (code == 41) {
			display(28);
			puzzles.puzzDes[0].changeToSolved("isPortraitChecked");
			goBack();
		} else if (code != 41) {
			display(27);
			take();
		} else {      //expected for no input, not yet working
			goBack();
		}
		in.close();
	}
	
	private void brokenTile() {
		branchDisplay(24, 37);
		Scanner in = new Scanner(System.in);
		System.out.println("(C - Continue cheking the portrait) (G - go back to table)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "C":
			portrait();
			break;
		case "G":
			goBack();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			brokenTile();
			break;		
		}
		in.close();
	}
	
	private void door() {
		branchDisplay(31, 38);
		Scanner in = new Scanner(System.in);
		System.out.println("(S - Say the name) (G - go back to table)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toUpperCase()) {
		case "S":
			pass6();
			break;
		case "G":
			goBack();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			door();
			break;		
		}
		in.close();
	}
	
	private void pass6() {
		System.out.println("Enter the answer: ");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		String pass = new String("Charley");
		command = command.toLowerCase();
		if (!command.matches(pass) ) {
			display(32);
			pass4();
		} else if (command.matches(pass)) {
			display(33);
			puzzles.puzzDes[0].changeToSolved("isDoorChecked");
			display(39);
		} else {
			door();
		}
		in.close();
	}
	
	
	private void goBack() {
		display(30);
		options(1);
	}
	
	private void start() {
		Scanner in = new Scanner(System.in);

			display(1);
			display(2);
			choices(0);
		
			in.close();
	}

	private void choices(int i) {
		System.out.println("(Come closer to the mirror) (Come closer to the door) (Examine the room)");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "come closer to the mirror":
			mirror();
			break;
		case "come closer to the door":
			door();
			break;
		case "examine the room":
			examine();
			break;

			/*case "help":
			System.out.println("Help: Basic Commands are look, examine, inventory, get, read, open, and help.");
			choices(i);
			break;*/
		case "exit":
			System.out.println("Thanks for playing!");
			System.exit(0);
			break;
		default:
			System.out.println("That's not a command I recognize.");
			choices(i);
			break;		
		}
		in.close();

	}


	private void mirror() {
		Scanner in = new Scanner(System.in);
		branchDisplay(3, 5);
		System.out.println("(Go back to the bed) (Try to take it off)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "go back to the bed":
			bed();
			break;
		case "try to take it off":
			remove();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			mirror();
			break;		
		}
		in.close();
	}

	private void remove() {
		Scanner in = new Scanner(System.in);
		branchDisplay(6, 7);
		mirror();
		in.close();
	}


	private void bed() {
		display(4);
		choices(0);
	}

	private void entrance() {
		Scanner in = new Scanner(System.in);
		branchDisplay(8, 9);
		System.out.println("(Go back to the bed) (Telephone)");
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "go back to the bed":
			bed();
			break;
		case "telephone":
			telephone();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			door();
			break;		
		}
		in.close();
	}

	private void telephone() {
		branchDisplay(10, 11);
		System.out.println("(Go back to the bed) (Speak into the phone)");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "go back to the bed":
			bed();
			break;
		case "speak into the phone":
			speak();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			telephone();
			break;		
		}
		in.close();
	}

	private void speak() {
		branchDisplay(12, 13);
		System.out.println("(Enter text message) (Go back to the bed)");	
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "enter text message": 
			msg();
			break;
		case "go back to the bed":
			bed();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			speak();
			break;		
		}
		in.close();
	}
	
	private void msg() {
		System.out.println("Enter text message: ");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		String pass = new String("viva");
		command = command.toLowerCase();
		if (!command.matches(pass) ) {
			display(14);
			speak();
		} else if (command.matches(pass)) {
			display(15);
			System.out.println("Room Escaped");
			System.exit(0);
		} else {
			speak();
		}
		in.close();
	}

	private void examine() {
		branchDisplay(16, 17);
		System.out.println("(Go back to the bed) (Examine the cabinet) (Open the suitcase) (Go to the door)");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "go back to the bed":
			bed();
			break;
		case "examine the cabinet":
			cabinet();
			break;
		case "open the suitcase":
			suitcase();
			break;
		case "go to the door":
			door();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			examine();
			break;		
		}
		in.close();
	}

	//problem: if already opened, need to display script22 instead
	private void cabinet() {
		if (puzzles.puzzDes[0].checkProblemIfSolved("isCabinetOpen") == false) {
			branchDisplay(18, 19);
		} else {
			display(22);
			examine();
		}
		System.out.println("(Go back to examining the room) (Enter code)");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "go back to examining the room":
			examine();
			break;
		case "enter code":
			code();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			cabinet();
			break;		
		}
		in.close();
	}

	private void code() {
		System.out.println("Enter code: ");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		int code = in.nextInt();
		if (code == 12) {
			display(21);
			puzzles.puzzDes[0].changeToSolved("isCabinetOpen");
			examine();
		} else if (code != 12) {
			display(20);
			cabinet();
		} else {      //expected for no input, not yet working
			examine();
		}
		in.close();
	}

	//problem1: if already unlocked but didnt proceed until the end, would require user to reopen it and go thru each step again
	//problem2: if already signed needs a way to proceed to displaying script 32
	private void suitcase() {
		if (puzzles.puzzDes[0].checkProblemIfSolved("isSuitcaseOpen") == false) {
			branchDisplay(23, 24);
		} else {
			display(32);
			examine();
		}
		System.out.println("(Enter code) (Continue searching the room) ");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "enter code":
			code2();
			break;
		case "continue searching the room":
			examine();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			suitcase();
			break;		
		}
		in.close();
	}

	private void code2() {
		System.out.println("Enter code: ");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		int code = in.nextInt();
		if (code == 807) {
			display(26);
			openedSuitcase();
		} else if (code != 807) {
			display(25);
			suitcase();
		} else {       //expected for no input, not yet working
			examine();
		}
		in.close();
	}

	private void openedSuitcase() {
		System.out.println("(Diary) (Continue searching the room) ");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "diary":
			diary();
			break;
		case "continue searching the room":
			examine();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			openedSuitcase();
			break;		
		}
		in.close();
	}

	private void diary() {
		branchDisplay(27, 28);
		System.out.println("(Sign) (Continue searching the room)");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "sign":
			sign();
			break;
		case "continue searching the room":
			examine();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			diary();
			break;		
		}
		in.close();
	}

	private void sign() {
		branchDisplay(29, 30);
		if (puzzles.puzzDes[0].checkProblemIfSolved("isCabinetOpen")) {
			System.out.println("(Use ballpoint pen) (Continue searching the room)");
		} else {
			System.out.println("(Continue searching the room)");
		}
		
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "use ballpoint pen":
			display(31);
			puzzles.puzzDes[0].changeToSolved("isSuitcaseOpen");
			examine();
			break;
		case "continue searching the room":
			examine();
			break;
		default:
			System.out.println("That's not a command I recognize.");
			sign();
			break;		
		}
		in.close();
	}

	public static void main(String[] args) {
		new GameFlow();	
	}
}
