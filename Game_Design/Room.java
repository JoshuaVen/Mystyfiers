class Room {
    int roomNumber;
    private Item[] items;
    
    private Room(int roomNumber, int numOfItemsForRoom) {
        this.roomNumber = roomNumber;
        this.items = new Item[numOfItemsForRoom];
        Item dummyItem = extracted();
        for (int i = 0; i < items.length; i++) {
            items[i] = dummyItem;
        }
    }

    private Item extracted() {
        Item dummy= new Item("", "");
        return dummy;
    }

    private void addItem(String name, String desc) {
        Item newItem = new Item(name, desc);
		for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals(extracted().name) && items[i].description.equals(extracted().description)) {
                items[i] = newItem;
                return;
            }
        }
    }

    public void viewItems() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(extracted().name) && !items[i].description.equals(extracted().description)) {
                System.out.println(items[i].name + ": " + items[i].description);
            }
        }
    }

     // test in the class
     private void test() {
        addItem("LADDLE", "Rusted but still in good quality!");
        viewItems();
    }

    public static void main(String[] args) {
        Room sample = new Room(0, 3);
        sample.test();
    }
}
