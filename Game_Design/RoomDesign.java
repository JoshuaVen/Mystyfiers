class RoomDesign {
	int noOfRooms; // no of Rooms/Level in the game
	public Room[] roomDes; // array of Rooms/Levels in the game
	
	// constructor for creating rooms
	RoomDesign(int totalRooms) {
		this.noOfRooms = totalRooms;
		this.roomDes = new Room[noOfRooms];
		for (int i = 0; i < noOfRooms; i++) {
			roomDes[i] = dummyRoom();
		}
		createRooms();
	}
	
	private Room dummyRoom() {
		Room dumm = new Room(-1);
		return dumm;
	}
	
	// adding a room to the game which helps adding rooms/level easier
	protected boolean addRoom(Room newRoom) {
		for (int i = 0; i < noOfRooms; i++) {
			if (roomDes[i].roomNumber == -1) {
				roomDes[i] = newRoom;
				return true;
			}
		}
		return false;
	}
	
	// create the rooms for the game and add it to the room arrays
	protected void createRooms() {
		Room room1 = new Room(1);
		room1.addItem("Small key", "For a padlock");
		room1.addItem("Paper", "Note");
		room1.addItem("Book", "Hard-bound Harry Potter book 1");
		room1.addItem("Plastic Bottle", "Half full and contains dirty water");
		room1.addItem("Key", "Small key that opens a cabinet in the Sala");
		addRoom(room1);
	}
}
