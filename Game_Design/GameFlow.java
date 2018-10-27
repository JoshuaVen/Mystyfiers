import java.util.Scanner;
// a class that contains the choices and how the game progresses
public class GameFlow {
	RoomDesign rooms;
	PuzzleDesign puzzles;
	int current;

	GameFlow() {
		this.rooms = new RoomDesign(1);
		this.puzzles = new PuzzleDesign(rooms);
		this.current = 0;
		start();
	}

	private void start() {
		Scanner in = new Scanner(System.in);
		for (int i = current; rooms.roomDes[i].roomNumber != -1; i++) {
			
			for (int j = 0; j < puzzles.puzzDes[i].numberOfSc; j++) {
				for (int k = 0; k < puzzles.puzzDes[i].actualSizeOfSc(j); k++) {
					System.out.print(puzzles.puzzDes[i].textSc[j][k].read());
					in.nextLine();
				}
			}
			choices(i);
		}
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
		/*if (isRead == false) {
			//script3
		} else {
			//script5
		}*/
		
		//for (int i=0; i < puzzles.puzzDes[1].actualSizeOfSc(3); i++) {
		//	System.out.print(puzzles.puzzDes[1].textSc[3][i]);
		//}
		System.out.println("(Go back to the bed) (Try to take it off)");
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "go back to the bed":
			bed();
			break;
		case "try to take it off":
			/*if (isRead == false) {
				//script6
			} else {
				//script7
			}*/
			mirror();
			break;
		default:
			System.out.println("That's not a verb I recognize.");
			mirror();
			break;		
		}
		in.close();
	}
	
	private void bed() {
		//script4
		choices(1);
	}
	
	private void door() {
		/*if (isRead == false) {
			//script8
		} else {
			//script9
		}*/
		System.out.println("(Go back to the bed) (Telephone)");
		Scanner in = new Scanner(System.in);
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
		/*if (isRead == false) {
			//script10
		} else {
			//script11
		}*/
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
		/*if (isRead == false) {
			//script12
		} else {
			//script13
		}*/
		System.out.println("Enter text message: ");	
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		
		/*command = command.toLowerCase();
		if (command != "") {
			bed();
		} else if (command != "viva" ) {
			//script14
			speak();
		} else if (command == "viva" ) {
			//script15
			System.out.println("Room Escaped");
			System.exit(0);
		} else {
			bed();
		}*/
		
		switch (command.toLowerCase()) {
		case "viva":
			//Script15
			System.out.println("Room Escaped");
			System.exit(0);
			break;
		case " ":        //still needs to handle anything not equal to viva
			//script14
			
			speak();
			break;
		default:
			bed();
			break;		
		}
		in.close();
	}

	private void examine() {
		/*if (isRead == false) {
			//script16
		} else {
			//script17
		}*/
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
			break;		
		}
		in.close();
	}
	
	//problem: if already opened, need to display script22 instead
	private void cabinet() {
		/*if (isRead == false) {
			//script18
		} else {
			//script19
		}*/
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
			//script21
			examine();
		} else if (code != 12) {
			//script20
			cabinet();
		} else {      //expected for no input, not yet working
			examine();
		}
		in.close();
	}
	
	//problem1: if already unlocked but didnt proceed until the end, would require user to reopen it and go thru each step again
	//problem2: if already signed needs a way to proceed to displaying script 32
	private void suitcase() {
		/*if (isRead == false) {
			//script23
		} else {
			//script24
		}*/
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
			//script26
			openedSuitcase();
		} else if (code != 807) {
			//script25
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
		/*if (isRead == false) {
			//script27
		} else {
			//script28
		}*/
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
		/*if (isRead == false) {
			//script29
		} else {
			//script30
		}*/
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
