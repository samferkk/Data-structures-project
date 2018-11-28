import java.util.HashMap;

/**
 * This class represents the entire world that makes up the "Campus of Kings"
 * application. "Campus of Kings" is a very simple, text based adventure game.
 * Users can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 * 
 * This world class creates the world where the game takes place.
 * 
 * @author Maria Jump
 * @version 2015.02.01
 */
public class World {
    /** The rooms in the world. */
    private HashMap<String, Room> rooms;

    /**
     * Constructor for the world.
     */
    public World() {
        rooms = new HashMap<String, Room>();
        createRooms();
        createItems();
    }

    /**
     * This method takes care of creating all of the aspects of the world for
     * the "Campus of Kings" application.
     * 
     * @param name
     *            The provided name of the room.
     * @return The room associated with the provided name
     */
    public Room getRoom(String name) {
        return rooms.get(name.toLowerCase());
    }

    /////////////////////////////////////////////////////////////////////////////////////
    // Start of private helper methods

    /**
     * Helper method for recreating a Room. Ensure that the room is created and
     * installed in to the collection of Rooms
     * 
     * @param theRoom
     *            The room to add to the world.
     */
    private void addRoom(Room theRoom) {
        rooms.put(theRoom.getName().toLowerCase(), theRoom);
    }

    /**
     * Helper method for creating doors between rooms.
     * 
     * @param from
     *            The room where the door originates.
     * @param direction
     *            The direction of the exit.
     * @param theRoom
     *            The room to the north of the originating room.
     */
    private void createDoor(Room from, String direction, Room theRoom) {
        Door theDoor = new Door(theRoom);
        from.setExit(theDoor, direction);
    }

    /**
     * This method creates all of the individual places in this world and all
     * the doors connecting them.
     */
    private void createRooms() {
        // Creating all the rooms.
       //Room room001 = new Room("Tutorial Room 001","This is the first room of the game this one will set up the basics of how the game works through the aid of Ggohrd.");
       Room hardwareSupplies = new Room("Lowes Depot","A hardware supplies store");
       Room westWing = new Room("West Wing","The west wing of the mall.");
       Room womensRoom = new Room("Women's Room","The women's bathroom.");
       Room furniture = new Room("Ikeya","A furniture shop. Known for easy assembly.");
       Room lobby = new Room("Lobby","The Lobby of the mall.");
       Room clothingStore = new Room("American Beagle","America's favorite clothing store.");
       Room candyStore = new Room("Willy Reilley's Candy Emporium","A candy store.");
       Room sweatShop = new Room("Sweat Shop","The #1 gym in the country.");
       Room bookStore = new Room("Noble Barns","A barnyard style bookstore.");
       Room eastWing= new Room("East Wing","The east wing of the mall.");
       Room mensRoom = new Room("Men's Room","The men's bathroom.");
       Room sportsShop = new Room("Rick's","A completely innocently named sporting goods store.");
       Room toyStore = new Room("Toy's R Almost out of business","A struggling toy store.");
       // Adding score to every room.
       //room052.setPoints(1000);
       
       // Adding all the rooms to the world.
       //this.addRoom(room001);
        this.addRoom(hardwareSupplies);
        this.addRoom(westWing);
        this.addRoom(womensRoom);
        this.addRoom(furniture);
        this.addRoom(lobby);
        this.addRoom(clothingStore);
        this.addRoom(candyStore);
        this.addRoom(sweatShop);
        this.addRoom(bookStore);
        this.addRoom(eastWing);
        this.addRoom(mensRoom);
        this.addRoom(sportsShop);
        this.addRoom(toyStore);        
        // Creating all the doors between the rooms.
        
        // Turorial Level
       //this.createDoor(room001,"north",room002);
       //this.createDoor(room002,"south",room001);
       this.createDoor(hardwareSupplies,"east",westWing);
       this.createDoor(westWing,"west",hardwareSupplies);
        
        this.createDoor(westWing,"south",womensRoom);
        this.createDoor(womensRoom,"north",westWing);
        
        this.createDoor(westWing,"north",furniture);
        this.createDoor(furniture,"south",westWing);
        
        this.createDoor(lobby,"west",westWing);
        this.createDoor(westWing,"east",lobby);
        
        this.createDoor(lobby,"northwest",candyStore);
        this.createDoor(candyStore,"southeast",lobby);
        
        this.createDoor(lobby,"southwest",clothingStore);
        this.createDoor(clothingStore,"northeast",lobby);
        
        this.createDoor(lobby,"southeast",sweatShop);
        this.createDoor(sweatShop,"northwest",lobby);
        
        this.createDoor(lobby,"northeast",bookStore);
        this.createDoor(bookStore,"southwest",lobby);
        
        this.createDoor(lobby,"east",eastWing);
        this.createDoor(eastWing,"west",lobby);
        
        this.createDoor(eastWing,"south",mensRoom);
        this.createDoor(mensRoom,"north",eastWing);
        
        this.createDoor(eastWing,"north",sportsShop);
        this.createDoor(sportsShop,"south",eastWing);
        
        this.createDoor(eastWing,"east",toyStore);
        this.createDoor(toyStore,"west",eastWing);
       
       
       // One direction exits.
       
       //Level Tutoiral - 1
       //this.createDoor(room010,"north",room012);
       // Level 1 - 2
       
       
       
    }
    
    /**
     * This method is responsible for greating the items in the world.
     */
    public void createItems() {
        // Creating of Items
        //Item smallHealthPotion = new Item("small heatlh potion", "heals 10 health points", 5, 1.0);
        
        
        //Creating Keys
        //Item key007 = new Item("key 007", "This key unlocks the norht door in Room 007", 10, 0.1);
        
        
        // Creating Containers
        //Container chest006 = new Container("chest","This is a chests",0,11.0);
        
        
        // Putting items into a container.
        //chest006.addItem(smallHealthPotion);
        
        
        //Adding items to the world
       // this.getRoom("Tutorial Room 006").addItem(chest006);
        
        //this.getRoom("").addItem();
        
        // Lock some doors
       //this.getRoom("Tutorial Room 007").getExit("north").setLocked(true);
       
       
       // Setting keys to doors
       //this.getRoom("Tutorial Room 007").getExit("north").setKey(key007.getName());
       
    }
}
