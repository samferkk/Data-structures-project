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
        Room hardwareSupplies = new Room("lowes depot","A hardware supplies store");
        Room westWing = new Room("west wing","The west wing of the mall.");
        Room womensRoom = new Room("women's room","The women's bathroom.");
        Room furniture = new Room("ikea","A furniture shop. Known for easy assembly.");
        Room lobby = new Room("lobby","The Lobby of the mall.");
        Room clothingStore = new Room("american beagle","America's favorite clothing store.");
        Room candyStore = new Room("willy reilley's candy emporium","A candy store.");
        Room sweatShop = new Room("sweat shop","The #1 gym in the country.");
        Room bookStore = new Room("noble barns","A barnyard style bookstore.");
        Room eastWing= new Room("east wing","The east wing of the mall.");
        Room mensRoom = new Room("men's room","The men's bathroom.");
        Room sportsShop = new Room("rick's","A completely innocently named sporting goods store.");
        Room toyStore = new Room("toy's r almost out of business","A struggling toy store.");
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
        //Hardware store items
        Item hammer = new Item("Hammer", "Steel headed Hammer for smashing nails and junk.");
        Item drill = new Item("Electric Drill", "Electronic Drill to put in screws or whatever.");
        Item tableSaw = new Item("Table Saw", "Just a big, electronic saw... on a table.");
        Item handSaw = new Item("Hand Saw", "A handheld saw, watch your fingers.");
        // Furniture store items
        Item futon = new Item("Futon", "You can either kick it with the homies or take a nap on this jawn, your choice, homie.");
        Item loveSeat = new Item("Love Seat", "Don't let the name fool you, this jawn only has room for one.");
        Item lamp = new Item("Lamp", "Nothing will light your day up like this jawn will.");
        Item firePlace = new Item("Fireplace", "Cold? Maybe buy one of these jawns.");
        //Trade shop items
        Item rabitsFoot = new Item("Rabbits Foot", "This thing is lucky!");
        Item candle = new Item("Candle", "Smells like spring time!");
        Item woolSocks = new Item("Wool Socks", "Your feet will never feel so warm!");
        Item soap = new Item("Soap", "You'll be the cleanest wherever you go when you use this soap!");
        // Sweat shop items
        Item greenJacket = new Item("Green Jacket", "Just a green jacket, nothing too crazy.");
        Item redSweatPants = new Item("Red Sweatpants", "Not everyone can pull these off, but maybe you can.");
        Item brownSweater = new Item("Brown Sweater", "Just a brown sweater, man.");
        Item brownJacket = new Item("Brown Jacket", "Like the brown sweater, but this one has a zipper and a hood.");
        // Candy store items
        Item turtles = new Item("Turtles", "Crunchy, chewy, pecan filled goodness.");
        Item chocCoveredRaisins = new Item("Chocolate Covered Raisins", "Chewy and delicious!");
        Item boxOfChocolate = new Item("Box of Chocolate", "Perfect blend of all sorts of cocoa infused goods.");
        Item molassesPaddals = new Item("Molasses Paddals", "The chewiest of them all! Don't eat before bed or you may wind up with a cavity.");
        //Book Store Items
        Item it = new Item("IT", "Stephen King's 'IT'.");
        Item greenEggsNHam = new Item("Green Eggs & Ham", "Dr. Seuss' 'Green Eggs & Ham'.");
        Item milkweed = new Item("Milkweed", "Jerry Spinelli's 'Milkweed'.");
        Item petCemetary = new Item("Pet Cemetary", "Stephen King's 'Pet Cemetary'.");
        Item catInHat = new Item("Cat in the Hat", "Dr. Seuss' 'Cat in the Hat'.");
        //Sports store items
        Item basketBall = new Item("Basketball", "Big, orange bouncy ball.");
        Item footBall = new Item("Football", "A classic pigskin.");
        Item hockeyStick = new Item("Hockey Stick", "Wicked tool to slap some pucks.");
        Item tennisBall = new Item("Tennis Ball", "Dogs love 'em.");
        // Toy store items
        Item spiderman = new Item("Spider-Man Action Figure", "Only the coolest web slinging dude ever.");
        Item batman = new Item("Bat-Man Action Figure", "World's greatest detective.");
        Item smallBasketball = new Item("Small Basketball", "Just about half the size of your average basketball.");
        Item xbox = new Item("Xbox", "Now you can definetely have some fun with this, if you can afford it.");

        this.getRoom("lowes depot").addItem(hammer);
        this.getRoom("lowes depot").addItem(drill);
        this.getRoom("lowes depot").addItem(tableSaw);
        this.getRoom("lowes depot").addItem(handSaw);
        
        this.getRoom("ikea").addItem(futon);
        this.getRoom("ikea").addItem(loveSeat);
        this.getRoom("ikea").addItem(lamp);
        this.getRoom("ikea").addItem(firePlace);
        
        this.getRoom("sweat shop").addItem(greenJacket);
        this.getRoom("sweat shop").addItem(redSweatPants);
        this.getRoom("sweat shop").addItem(brownSweater);
        this.getRoom("sweat shop").addItem(brownJacket);
        
        this.getRoom("willy reiley's candy emporium").addItem(turtles);
        this.getRoom("willy reiley's candy emporium").addItem(chocCoveredRaisins);
        this.getRoom("willy reiley's candy emporium").addItem(boxOfChocolate);
        this.getRoom("willy reiley's candy emporium").addItem(molassesPaddals);
        
        this.getRoom("noble barns").addItem(it);
        this.getRoom("noble barns").addItem(greenEggsNHam);
        this.getRoom("noble barns").addItem(milkweed);
        this.getRoom("noble barns").addItem(petCemetary);
        this.getRoom("noble barns").addItem(catInHat);
        
        this.getRoom("ricks").addItem(basketBall);
        this.getRoom("ricks").addItem(footBall);
        this.getRoom("ricks").addItem(hockeyStick);
        this.getRoom("ricks").addItem(tennisBall);
        
        this.getRoom("toy's r almost out of busines").addItem(spiderman);
        this.getRoom("toy's r almost out of busines").addItem(batman);
        this.getRoom("toy's r almost out of busines").addItem(smallBasketball);
        this.getRoom("toy's r almost out of busines").addItem(xbox);
        
        
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
