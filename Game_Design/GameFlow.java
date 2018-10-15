import java.util.Scanner;
// a class that contains the choices and how the game progresses
public class GameFlow {
	RoomDesign rooms;
	PuzzleDesign puzzles;
	int current;

	GameFlow() {
		this.rooms = new RoomDesign(5);
		this.puzzles = new PuzzleDesign(rooms);
		this.current = 0;
		choices();
	}

	private void choices() {
		for (int i = current; rooms.roomDes[i].roomNumber != -1; i++) {
			System.out.println(puzzles.puzzDes[i].viewScript());
			Scanner in = new Scanner(System.in);
			System.out.print("> ");
			String command = in.nextLine();
			switch (command.toLowerCase()) {
			case "look":
				System.out.println("The room consists of:");
				rooms.roomDes[i].viewItems();
				choices();
				break;
			case "examine":
				System.out.println("There's a note on the table saying 'You must escape the room or else...'");
				choices();
				break;
			case "inventory":
				System.out.println("You have: ");
				choices();
				break;
			case "get":
				System.out.println("You have gotten the object");
				choices();
				break;
			case "read":
				System.out.println("You are reading...");
				choices();
				break;
			case "open":
				System.out.println("You opened...");
				choices();
				break;
			case "help":
				//More details to be added in the following sprint/s
				
				//System.out.println("Need help? \n\nTopics you can get help on are: ");
				//System.out.println("\"help basics\": Commands you can do for the story to progress.");
				//System.out.println("\"help system\": Saving, quitting, and other system commands.");
				//System.out.println("\"help strategy\": Figuring out what to do, when you're stuck."\n);
				//System.out.println("Type \"help hint\" for a single hint on what to try next.");
				System.out.println("Help: Basic Commands are look, examine, inventory, get, read, open, and help.");
				choices();
				break;
			case "":
				System.out.println("I beg your pardon?");
				choices();
				break;
			default:
				System.out.println("That's not a verb I recognize.");
				choices();
				break;		
			}
			in.close();
			this.current = current + 1;
		}
	}

	public static void main(String[] args) {
		new GameFlow();	
	}
}
