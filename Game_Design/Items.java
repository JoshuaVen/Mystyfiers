class Items {
    String name;
    String description;
    boolean isASolution;
    Room assignedRoomToBeSolution;

    private Items(String name, String description, boolean isASolution, int roomNumber) {
        this.name = name;
        this.description = description;
        this.isASolution = isASolution;
        this.assignedRoomToBeSolution = new Room(roomNumber);
    }

    private Items(String name, String desc, boolean isASolution) {
        this.name = name;
        this.description = desc;
        this.isASolution = isASolution;
        this.assignedRoomToBeSolution = new Room(0);
    }

    public static void main(String[] args) {
        Items sample1 = new Items("laddle", "Rusted but still usable in cooking." , false);
        Items sample2 = new Items("Key", "Can be used to open the cabinet", true, 2);
        Items[] items = new Items[2];
        items[0] = sample1;
        items[1] = sample2;

        System.out.println(items[0].name + "---" + items[0].description);
    }
        
    
}