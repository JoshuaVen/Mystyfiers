class Item {
    String name;
    String description;
    boolean isGettable;
    
    protected Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.isGettable = false;
    }
}