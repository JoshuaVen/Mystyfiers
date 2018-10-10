import java.util.Scanner;

public class Room {
	int roomNumber;
	private Item[] items;
	    
	private Room(int roomNumber) {
		this.roomNumber = roomNumber;
		int MAXNumofItems = 5;
		this.items = new Item[MAXNumofItems];
	    Item dummyItem = extracted();
	    for (int i = 0; i < items.length; i++) {
	    	items[i] = dummyItem;
	    }
	}

	private Item extracted() {
	    Item dummy= new Item("", "");
	    return dummy;
	}

	private void addItem(String name, String desc) throws ArrayIndexOutOfBoundsException {
	    Item newItem = new Item(name, desc);
	    for (int i = 0; i < items.length; i++) {
	        if (items[i].name.equals(extracted().name) && items[i].description.equals(extracted().description)) {
	            items[i] = newItem;
	            return;
	        }
	    }
	}
	
	public void choices() {
		Scanner in = new Scanner(System.in);
		System.out.print("> ");
		String command = in.nextLine();
		switch (command.toLowerCase()) {
		case "look":
			System.out.println("The room consists of a working table, book shelf, etc...");
			break;
		case "examine":
			System.out.println("There's a note on the table saying 'You must escape the room or else...'");
			break;
		case "inventory":
			System.out.println("You have: ");
			viewItems();
			choices();
			break;
		case "get":
			System.out.println("You have gotten the object");
			break;
		case "read":
			System.out.println("You are reading...");
			break;
		case "help":
			System.out.println("Help Basic Commands are look, examine, inventory, get, read...");
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
	}

	public void viewItems() {
	    for (int i = 0; i < items.length; i++) {
	        if (!items[i].name.equals(extracted().name) && !items[i].description.equals(extracted().description)) {
	            System.out.println("\t" + items[i].name);
	        }
	    }
	}

	// test in the class
	private void test() {
	    addItem("LADDLE", "Rusted but still in good quality!");
	    addItem("Key", "Small key that opens a cabinet in the Sala");
	    addItem("Plastic Bottle", "Half full and contains dirty water");
	    addItem("Book", "Hard-bound Harry Potter book 1");
	    addItem("Paper", "Note");
	    addItem("Small key", "For a padlock");
	  //viewItems();
	 // choices();
	}
	
	public static void main(String[] args) {
	    Room start = new Room(0);
	    start.test();
	    System.out.println("Introduction: You have been kidnapped...");
	    System.out.println();
		start.choices();
	}
}
