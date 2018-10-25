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
	}

	private void choices(int i) {
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "look":
			System.out.println("The room consists of:");
			rooms.roomDes[i].viewItems();
			choices(i);
			break;
		case "examine":
			System.out.println("There's a note on the table saying 'You must escape the room or else...'");
			choices(i);
			break;
		case "inventory":
			System.out.println("You have: ");
			choices(i);
			break;
		case "get":
			System.out.println("You have gotten the object");
			choices(i);
			break;
		case "read":
			System.out.println("You are reading...");
			choices(i);
			break;
		case "open":
			System.out.println("You opened...");
			choices(i);
			break;
		case "help":
			System.out.println("Help: Basic Commands are look, examine, inventory, get, read, open, and help.");
			choices(i);
			break;
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

	public static void main(String[] args) {
		new GameFlow();	
	}
}
