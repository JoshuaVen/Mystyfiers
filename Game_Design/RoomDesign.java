class RoomDesign {
	static int noOfRooms; // no of Rooms/Level in the game
	public Room[] roomDes; // array of Rooms/Levels in the game
	Room dummy;
	
	// constructor for creating rooms
	RoomDesign(int totalRooms) {
		this.dummy = dummyRoom();
		RoomDesign.noOfRooms = totalRooms;
		this.roomDes = new Room[noOfRooms];
		for (int i = 0; i < noOfRooms; i++) {
			roomDes[i] = dummy;
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
		room1.addItem("Bookshelf", "Books of different genres are placed in it. Some letters are more clear than the others");
		room1.addItem("Small Table", "Old, mini table.");
		room1.addItem("Two withered plants", "The two, same kind, but withered plants can be found by the corner");
		room1.addItem("Bag", "Bit of dusty but useful bag for carrying things");
		room1.addItem("Chair", "A tattered and almost destroyed chair");
		room1.addItem("Wooden Table", "Old but sturdy table that has written notes on top of it");
		room1.addItem("Painting", "Dull and colorless painting of a plant hanged in a durable thread in a wall");
		room1.addItem("Vault", "Locked vault that can be opened using with a letter combinations");
		addRoom(room1);
	}
}
