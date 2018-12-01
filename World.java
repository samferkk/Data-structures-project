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
        Room tradeStore = new Room("Trader Bill's","America's favorite random item store.");
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
        this.addRoom(tradeStore);
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

        this.createDoor(lobby,"southwest",tradeStore);
        this.createDoor(tradeStore,"northeast",lobby);

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
        Item hammer = new Item("Hammer", "Steel headed Hammer for smashing nails and junk.",0,0.0);
        Item drill = new Item("Electric Drill", "Electronic Drill to put in screws or whatever.",0,0.0);
        Item tableSaw = new Item("Table Saw", "Just a big, electronic saw... on a table.",0,0.0);
        Item handSaw = new Item("Hand Saw", "A handheld saw, watch your fingers.",0,0.0);
        // Furniture store items
        Item futon = new Item("Futon", "You can either kick it with the homies or take a nap on this jawn, your choice, homie.",0,0.0);
        Item loveSeat = new Item("Love Seat", "Don't let the name fool you, this jawn only has room for one.",0,0.0);
        Item lamp = new Item("Lamp", "Nothing will light your day up like this jawn will.",0,0.0);
        Item firePlace = new Item("Fireplace", "Cold? Maybe buy one of these jawns.",0,0.0);
        //Trade shop items
        Item rabitsFoot = new Item("Rabbits Foot", "This thing is lucky!",0,0.0);
        Item candle = new Item("Candle", "Smells like spring time!",0,0.0);
        Item woolSocks = new Item("Wool Socks", "Your feet will never feel so warm!",0,0.0);
        Item soap = new Item("Soap", "You'll be the cleanest wherever you go when you use this soap!",0,0.0);
        // Sweat shop items
        Item greenJacket = new Item("Green Jacket", "Just a green jacket, nothing too crazy.",0,0.0);
        Item redSweatPants = new Item("Red Sweatpants", "Not everyone can pull these off, but maybe you can.",0,0.0);
        Item brownSweater = new Item("Brown Sweater", "Just a brown sweater, man.",0,0.0);
        Item brownJacket = new Item("Brown Jacket", "Like the brown sweater, but this one has a zipper and a hood.",0,0.0);
        // Candy store items
        Item turtles = new Item("Turtles", "Crunchy, chewy, pecan filled goodness.",0,0.0);
        Item chocCoveredRaisins = new Item("Chocolate Covered Raisins", "Chewy and delicious!",0,0.0);
        Item boxOfChocolate = new Item("Box of Chocolate", "Perfect blend of all sorts of cocoa infused goods.",0,0.0);
        Item molassesPaddals = new Item("Molasses Paddals", "The chewiest of them all! Don't eat before bed or you may wind up with a cavity.",0,0.0);
        //Book Store Items
        Item it = new Item("IT", "Stephen King's 'IT'.",0,0.0);
        Item greenEggsNHam = new Item("Green Eggs & Ham", "Dr. Seuss' 'Green Eggs & Ham'.",0,0.0);
        Item milkweed = new Item("Milkweed", "Jerry Spinelli's 'Milkweed'.",0,0.0);
        Item petCemetary = new Item("Pet Cemetary", "Stephen King's 'Pet Cemetary'.",0,0.0);
        Item catInHat = new Item("Cat in the Hat", "Dr. Seuss' 'Cat in the Hat'.",0,0.0);
        //Sports store items
        Item basketBall = new Item("Basketball", "Big, orange bouncy ball.",0,0.0);
        Item footBall = new Item("Football", "A classic pigskin.",0,0.0);
        Item hockeyStick = new Item("Hockey Stick", "Wicked tool to slap some pucks.",0,0.0);
        Item tennisBall = new Item("Tennis Ball", "Dogs love 'em.",0,0.0);
        // Toy store items
        Item spiderman = new Item("Spider-Man Action Figure", "Only the coolest web slinging dude ever.",0,0.0);
        Item batman = new Item("Bat-Man Action Figure", "World's greatest detective.",0,0.0);
        Item smallBasketball = new Item("Small Basketball", "Just about half the size of your average basketball.",0,0.0);
        Item xbox = new Item("Xbox", "Now you can definetely have some fun with this, if you can afford it.",0,0.0);

        this.getRoom("Lowes Depot").addItem(hammer);
        this.getRoom("Lowes Depot").addItem(drill);
        this.getRoom("Lowes Depot").addItem(tableSaw);
        this.getRoom("Lowes Depot").addItem(handSaw);

        this.getRoom("Trader Bill's").addItem(rabitsFoot);
        this.getRoom("Trader Bill's").addItem(candle);
        this.getRoom("Trader Bill's").addItem(woolSocks);
        this.getRoom("Trader Bill's").addItem(soap);
        
        this.getRoom("Ikeya").addItem(futon);
        this.getRoom("Ikeya").addItem(loveSeat);
        this.getRoom("Ikeya").addItem(lamp);
        this.getRoom("Ikeya").addItem(firePlace);

        this.getRoom("Sweat Shop").addItem(greenJacket);
        this.getRoom("Sweat Shop").addItem(redSweatPants);
        this.getRoom("Sweat Shop").addItem(brownSweater);
        this.getRoom("Sweat Shop").addItem(brownJacket);

        this.getRoom("Willy Reilley's Candy Emporium").addItem(turtles);
        this.getRoom("Willy Reilley's Candy Emporium").addItem(chocCoveredRaisins);
        this.getRoom("Willy Reilley's Candy Emporium").addItem(boxOfChocolate);
        this.getRoom("Willy Reilley's Candy Emporium").addItem(molassesPaddals);

        this.getRoom("Noble Barns").addItem(it);
        this.getRoom("Noble Barns").addItem(greenEggsNHam);
        this.getRoom("Noble Barns").addItem(milkweed);
        this.getRoom("Noble Barns").addItem(petCemetary);
        this.getRoom("Noble Barns").addItem(catInHat);

        this.getRoom("Rick's").addItem(basketBall);
        this.getRoom("Rick's").addItem(footBall);
        this.getRoom("Rick's").addItem(hockeyStick);
        this.getRoom("Rick's").addItem(tennisBall);

        this.getRoom("Toy's R Almost out of business").addItem(spiderman);
        this.getRoom("Toy's R Almost out of business").addItem(batman);
        this.getRoom("Toy's R Almost out of business").addItem(smallBasketball);
        this.getRoom("Toy's R Almost out of business").addItem(xbox);

        
    }
}
