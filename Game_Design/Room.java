class Room {
    int roomNumber;
    int numOfItemsForRoom;
    Items[] items;
    
    protected Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.items = new Items[numOfItemsForRoom];
    }

}