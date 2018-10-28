import java.util.Scanner;
// a class that contains the choices and how the game progresses
public class GameFlow {
	RoomDesign rooms;
	PuzzleDesign puzzles;
	boolean isCabinetOpen; //temporary placement... to be added in the puzzle class in solutions array
	boolean isRoomExamined;
	int current;

	GameFlow() {
		this.rooms = new RoomDesign(1);
		this.puzzles = new PuzzleDesign(rooms);
		this.current = 0;
		this.isCabinetOpen = false;
		this.isRoomExamined = false;
		start();
	}
	
	private void display(int scriptNum) {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < puzzles.puzzDes[0].actualSizeOfSc(scriptNum); i++) {
			System.out.print(puzzles.puzzDes[0].textSc[scriptNum - 1][i].read());
			in.nextLine();
		}
	}

	private void branchDisplay(int ifScript, int elseScript) {
		if (puzzles.puzzDes[0].textSc[ifScript - 1][0].isRead == false) {
			display(ifScript);
		} else {
			display(elseScript);
		}
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
			System.out.println("That's not a verb I recognize.");
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
			System.out.println("That's not a verb I recognize.");
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

	private void door() {
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
			System.out.println("That's not a verb I recognize.");
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
			System.out.println("That's not a verb I recognize.");
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
			System.out.println("That's not a verb I recognize.");
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
			System.out.println("That's not a verb I recognize.");
			examine();
			break;		
		}
		in.close();
	}

	//problem: if already opened, need to display script22 instead
	private void cabinet() {
		if (isCabinetOpen == false) {
			branchDisplay(18, 19);
		} else {
			display(22);
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
			System.out.println("That's not a verb I recognize.");
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
		branchDisplay(23, 24);
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
			System.out.println("That's not a verb I recognize.");
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
			System.out.println("That's not a verb I recognize.");
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
			System.out.println("That's not a verb I recognize.");
			diary();
			break;		
		}
		in.close();
	}

	private void sign() {
		branchDisplay(29, 30);
		System.out.println("(Use ballpoint pen) (Continue searching the room)");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "use ballpoint pen":
			//script 31
			examine();
			break;
		case "continue searching the room":
			examine();
			break;
		default:
			System.out.println("That's not a  I recognize.");
			sign();
			break;		
		}
		in.close();
	}

	public static void main(String[] args) {
		new GameFlow();	
	}
}
