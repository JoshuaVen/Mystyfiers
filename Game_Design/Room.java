public class Room {
	int roomNumber;
	protected Item[] items;
	    
	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
		int MAXNumofItems = 10;
		this.items = new Item[MAXNumofItems];
	    Item dummyItem = extracted();
	    for (int i = 0; i < items.length; i++) {
	    	items[i] = dummyItem;
	    }
	}

	protected Item extracted() {
	    Item dummy= new Item("", "");
	    return dummy;
	}

	protected boolean addItem(String name, String desc) throws ArrayIndexOutOfBoundsException {
	    Item newItem = new Item(name, desc);
	    for (int i = 0; i < items.length; i++) {
	        if (items[i].name.equals(extracted().name) && items[i].description.equals(extracted().description)) {
	            items[i] = newItem;
	            return true;
	        }
	    }
	    return false;
	}
	
	protected void viewItems() {
	    for (int i = 0; i < items.length; i++) {
	        if (!items[i].name.equals(extracted().name) && !items[i].description.equals(extracted().description)) {
	            System.out.println("\t" + items[i].name + "-->> " + items[i].description);
	        }
	    }
	}
}
