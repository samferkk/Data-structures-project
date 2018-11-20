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
       Room room001 = new Room("Tutorial Room 001","This is the first room of the game this one will set up the basics of how the game works through the aid of Ggohrd.");
       Room room002 = new Room("Tutorial Room 002","Welcome to the second room on the tutorial dungeon. Back Story of the dungeon is given here.");
       Room room003 = new Room("Tutorial Room 003","Now for some full movement testing. Please go East to continue the tutorial");
       Room room004 = new Room("Tutorial Room 004","Congrats on moving in the east direction and nice job following instruction. Please Continue north.");
       Room room005 = new Room("Tutorial Room 005","“EAST! I though you said WEEST!” congrats on following directions you have moved in the west direction. Continue North.");
       Room room006 = new Room("Tutorial Room 006","This room contains a chest. Chests are scattered about the dungeon and will contain that levels gear. Finding these quickly will be key as it will make fighting monsters easier.");
       Room room007 = new Room("Tutorial Room 007","beyond this door lies the rest of the dungeon.");
       Room room008 = new Room("Tutorial Room 008","This is a monster room. Monsters exist all throughout the dungeon. They get stronger as the level of the dungeon progress. Monsters also come in hordes of between 1-3 of a single kind of monster. There are 5 different kinds of monsters. Get ready for your first monster fight.");
       Room room009 = new Room("Tutorial Room 009","This is the boss room of the Tutorial level. There is a boss battle at the end of every dungeon level. Defeating the boss is required to progress further into the dungeon.");
       Room room010 = new Room("Tutorial Room 010","This room exists solely to congratulate you on completing the Tutorial level. Good luck after this because the dungeon is much worse.");
       Room room011 = new Room("Dungeon Room 011","This is a monster fight room. Fight will start immediately upon first entrance. Afterwards displays what monster was killed.");
       Room room012 = new Room("Dungeon Room 012","Entrance Room. Here exist the Dungeon in all her glory. Outside of this room lies many pearls as well as untold riches. If you can survive long enough. ");
       Room room013 = new Room("Dungeon Room 013","This is the laundry room. Sitting in the cobble stone room is a laundry machine. Not quite sure how it got there or what it does but it’s definitely out of place. ");
       Room room014 = new Room("Dungeon Room 014","The dungeon still yields no notion of who created it, or what its houses, or why it was built. Strange markings liter the wall, but it is impossible to know what they say, and the markings are foreign themselves. ");
       Room room015 = new Room("Dungeon Room 015","This is a monster fight room. Fight will start immediately upon first entrance. Afterwards displays what monster was killed.");
       Room room016 = new Room("Dungeon Room 016","there appears to be some sort of images etched into the wall. Try as you might to wipe the dust off, nothing gives way. Still nothing to go on. This dungeon is living in mystery. ");
       Room room017 = new Room("Dungeon Room 017","This is chest room. This chest contains level 2 helmet, torso, leggings, and boots. There’s is also a level 2 sword and bow. The is also 2 heal potions, 1 mana potions, and 10 fire arrows. ");
       Room room018 = new Room("Dungeon Room 018","This is a monster fight room. Fight will start immediately upon first entrance. Afterwards displays what monster was killed.");
       Room room019 = new Room("Dungeon Room 019","This is the shop room where you can purchase good you may need on your quest. ");
       Room room020 = new Room("Dungeon Room 020","Boss Room. This is a boss battle. This rooms boss is tide pod");
       Room room021 = new Room("Dungeon Room 021","This is a monster fight room. Fight will start immediately upon first entrance. Afterwards displays what monster was killed.");
       Room room022 = new Room("Dungeon Room 022","A hard and sickle is painted on the wall in what you can only hope if red paint. A small sign reads “Добро пожаловать в советский блок” (welcome to the soviet bloc) The sound of muffled hard bass rings through the room. ");
       Room room023 = new Room("Dungeon Room 023","This is a monster fight room. Fight will start immediately upon first entrance. Afterwards displays what monster was killed. ");
       Room room024 = new Room("Dungeon Room 024","The hard bass grows louder the more you move into this bloc. Scrawled on the wall is a recipe for mayonnaise. odd. ");
       Room room025 = new Room("Dungeon Room 025","This is chest room. This chest contains level 3 helmet, torso, leggings, and boots. There’s is also a level 3 sword and bow. The is also 3 heal potions, 2 mana potions, and 6 fire arrows. ");
       Room room026 = new Room("Dungeon Room 026","Cyka Blyat! These Gopniks are getting annoying with their hard bass, and vodka, and adidas, and blin this and blyat that! ");
       Room room027 = new Room("Dungeon Room 027","This is the shop room where you can purchase good you may need on your quest ");
       Room room028 = new Room("Dungeon Room 028","This is a monster fight room. Fight will start immediately upon first entrance. Afterwards displays what monster was killed.");
       Room room029 = new Room("Dungeon Room 029","This is free parking. The car in the room welcomes you and say that you may stay as long as you want. ");
       Room room030 = new Room("Dungeon Room 030","Borat boss fight.");
       Room room031 = new Room("Dungeon Room 031","Upon entering the room you encounter Hank Hill standing in a T-pose. Speaking to him only yields the same response, “I sell propane and propane accessories.” ");
       Room room032 = new Room("Dungeon Room 032","You enter the third level. Once your ears stop ringing form the hard bass everything starts to grow quiet…. Too quiet. Then you hear it faintly. Somewhere, the is a clicking. ");
       Room room033 = new Room("Dungeon Room 033","This is a monster fight room. Fight will start immediately upon first entrance. Afterwards displays what monster was killed.");
       Room room034 = new Room("Dungeon Room 034","This is the shop room where you can purchase good you may need on your quest. ");
       Room room035 = new Room("Dungeon Room 035","This is a monster fight room. Fight will start immediately upon first entrance. Afterwards displays what monster was killed.");
       Room room036 = new Room("Dungeon Room 036","in the corner of the room stands a small girl. You approach her and ask her what her name is. She responds with “Kanna Kamui.” As soon as she gets the last syllable out a thunderous roar lets out. “MY QUEEN” rings through the dungeon. ");
       Room room037 = new Room("Dungeon Room 037","This is chest room. This chest contains level 4 helmet, torso, leggings, and boots. There’s is also a level 4 sword and bow. The is also 2 heal potions, 2 mana potions, and 6 fire arrows. ");
       Room room038 = new Room("Dungeon Room 038","as the door swings open to an uncomfortably bright room. The only contrast being a small red figure stands in the middle of the room. You question him as to where you are. HE responds “You do not know de wae. I will show you de wae … tO HEAVEN!” his voice fades out as he ascends. As you return you head to a normal viewing angle you notice a door as appeared in front of you. ");
       Room room039 = new Room("Dungeon Room 039","This is a monster fight room. Fight will start immediately upon first entrance. Afterwards displays what monster was killed.");
       Room room040 = new Room("Dungeon Room 040","Ugandan Knuckles boss fight.");
       Room room041 = new Room("Dungeon Room 041","You here a muffled chant breaches the wall of the dungeon. You poke you finger through some mortar. You peek out to see a group of people erecting a wall and you hear more clearly their chants of ‘Built that wall!’ but why were they building a wall all the way down here. ");
       Room room042 = new Room("Dungeon Room 042","This is it, the fourth level of the dungeon. After that last boss fight what could be worse as you step out of the staircase the light flick on. Out of the depths of the dungeon a voice rings out “GET THOSE LIGHTS OFF!” ");
       Room room043 = new Room("Dungeon Room 043","a small man is curled in the corner he is muttering some thing almost impossible to hear. As you lean in closer to hear what he is saying he flips around, grabs you by the collar and screams ‘Make America Great Again!’ and the sprints off into the dungeon. ");
       Room room044 = new Room("Dungeon Room 044","This is a monster fight room. Fight will start immediately upon first entrance. Afterwards displays what monster was killed.");
       Room room045 = new Room("Dungeon Room 045","This is the shop room where you can purchase good you may need on your quest. ");
       Room room046 = new Room("Dungeon Room 046","This is a monster fight room. Fight will start immediately upon first entrance. Afterwards displays what monster was killed. ");
       Room room047 = new Room("Dungeon Room 047","This is a monster fight room. Fight will start immediately upon first entrance. Afterwards displays what monster was killed.");
       Room room048 = new Room("Dungeon Room 048","This is chest room. This chest contains level 5 helmet, torso, leggings, and boots. There’s is also a level 5 sword and bow. The is also 3 heal potions, 1 mana potions, and 12 fire arrows. ");
       Room room049 = new Room("Dungeon Room 049","Scrawled on the wall it what is hopefully ketchup are the words ‘DON’T DRINK THE COVFEFE!’ ");
       Room room050 = new Room("Dungeon Room 050","Trump Boss");
       Room room051 = new Room("Dungeon Room 051","This is the second to last room of the dungeon. It is a chest room and a shop room. ");
       Room room052 = new Room("Dungeon Room 052","This is the final boss battle of the game. The boss fight is against Pmujrd.");
       // Adding score to every room.
       room001.setPoints(10);
       room002.setPoints(10);
       room003.setPoints(10);
       room004.setPoints(10);
       room005.setPoints(10);
       room006.setPoints(15);
       room007.setPoints(10);
       room008.setPoints(20);
       room009.setPoints(50);
       room010.setPoints(10);
       room011.setPoints(20);
       room012.setPoints(10);
       room013.setPoints(25);
       room014.setPoints(10);
       room015.setPoints(20);
       room016.setPoints(10);
       room017.setPoints(15);
       room018.setPoints(20);
       room019.setPoints(10);
       room020.setPoints(50);
       room021.setPoints(20);
       room022.setPoints(10);
       room023.setPoints(20);
       room024.setPoints(10);
       room025.setPoints(15);
       room026.setPoints(10);
       room027.setPoints(10);
       room028.setPoints(20);
       room029.setPoints(25);
       room030.setPoints(50);
       room031.setPoints(10);
       room032.setPoints(10);
       room033.setPoints(20);
       room034.setPoints(10);
       room035.setPoints(20);
       room036.setPoints(10);
       room037.setPoints(15);
       room038.setPoints(10);
       room039.setPoints(20);
       room040.setPoints(50);
       room041.setPoints(10);
       room042.setPoints(10);
       room043.setPoints(10);
       room044.setPoints(20);
       room045.setPoints(10);
       room046.setPoints(20);
       room047.setPoints(20);
       room048.setPoints(15);
       room049.setPoints(10);
       room050.setPoints(50);
       room051.setPoints(10);
       room052.setPoints(1000);
       
       // Adding all the rooms to the world.
       this.addRoom(room001);
       this.addRoom(room002);
       this.addRoom(room003);
       this.addRoom(room004);
       this.addRoom(room005);
       this.addRoom(room006);
       this.addRoom(room007);
       this.addRoom(room008);
       this.addRoom(room009);
       this.addRoom(room010);
       this.addRoom(room011);
       this.addRoom(room012);
       this.addRoom(room013);
       this.addRoom(room014);
       this.addRoom(room015);
       this.addRoom(room016);
       this.addRoom(room017);
       this.addRoom(room018);
       this.addRoom(room019);
       this.addRoom(room020);
       this.addRoom(room021);
       this.addRoom(room022);
       this.addRoom(room023);
       this.addRoom(room024);
       this.addRoom(room025);
       this.addRoom(room026);
       this.addRoom(room027);
       this.addRoom(room028);
       this.addRoom(room029);
       this.addRoom(room030);
       this.addRoom(room031);
       this.addRoom(room032);
       this.addRoom(room033);
       this.addRoom(room034);
       this.addRoom(room035);
       this.addRoom(room036);
       this.addRoom(room037);
       this.addRoom(room038);
       this.addRoom(room039);
       this.addRoom(room040);
       this.addRoom(room041);
       this.addRoom(room042);
       this.addRoom(room043);
       this.addRoom(room044);
       this.addRoom(room045);
       this.addRoom(room046);
       this.addRoom(room047);
       this.addRoom(room048);
       this.addRoom(room049);
       this.addRoom(room050);
       this.addRoom(room051);
       this.addRoom(room052);
        // Creating all the doors between the rooms.
        
        // Turorial Level
       this.createDoor(room001,"north",room002);
       this.createDoor(room002,"south",room001);
       
       this.createDoor(room002,"north",room003);
       this.createDoor(room003,"south",room002);
       
       this.createDoor(room003,"east",room004);
       this.createDoor(room004,"west",room003);
       
       this.createDoor(room003,"west",room005);
       this.createDoor(room005,"east",room003);
       
       this.createDoor(room005,"north",room006);
       this.createDoor(room006,"south",room005);
       
       this.createDoor(room004,"north",room008);
       this.createDoor(room008,"south",room004);
       
       this.createDoor(room006,"east",room007);
       this.createDoor(room007,"west",room006);
       
       this.createDoor(room007,"east",room008);
       this.createDoor(room008,"west",room007);
       
       this.createDoor(room007,"north",room009);
       this.createDoor(room009,"south",room007);
       
       this.createDoor(room009,"north",room010);
       this.createDoor(room010,"south",room009);
       
       // Level 1 Rooms
       
       this.createDoor(room011,"east",room012);
       this.createDoor(room012,"west",room011);
       
       this.createDoor(room012,"east",room013);
       this.createDoor(room013,"west",room012);
       
       this.createDoor(room011,"north",room014);
       this.createDoor(room014,"south",room011);
       
       this.createDoor(room012,"north",room015);
       this.createDoor(room015,"south",room012);
       
       this.createDoor(room013,"north",room016);
       this.createDoor(room016,"south",room013);
       
       this.createDoor(room014,"east",room015);
       this.createDoor(room015,"west",room014);
       
       this.createDoor(room015,"east",room016);
       this.createDoor(room016,"west",room015);
       
       this.createDoor(room014,"north",room017);
       this.createDoor(room017,"south",room014);
       
       this.createDoor(room015,"north",room018);
       this.createDoor(room018,"south",room015);
       
       this.createDoor(room016,"north",room019);
       this.createDoor(room019,"south",room016);
       
       this.createDoor(room017,"east",room018);
       this.createDoor(room018,"west",room017);
       
       this.createDoor(room018,"east",room019);
       this.createDoor(room019,"west",room018);
       
       this.createDoor(room018,"north",room020);
       this.createDoor(room020,"south",room018);
       
       // Level 2 Rooms
       
       this.createDoor(room021,"east",room022);
       this.createDoor(room022,"west",room021);
       
       this.createDoor(room022,"east",room023);
       this.createDoor(room023,"west",room022);
       
       this.createDoor(room021,"north",room024);
       this.createDoor(room024,"south",room021);
       
       this.createDoor(room022,"north",room025);
       this.createDoor(room025,"south",room022);
       
       this.createDoor(room023,"north",room026);
       this.createDoor(room026,"south",room023);
       
       this.createDoor(room024,"east",room025);
       this.createDoor(room025,"west",room024);
       
       this.createDoor(room025,"east",room026);
       this.createDoor(room026,"west",room025);
       
       this.createDoor(room024,"north",room027);
       this.createDoor(room027,"south",room024);
       
       this.createDoor(room025,"north",room028);
       this.createDoor(room028,"south",room025);
       
       this.createDoor(room026,"north",room029);
       this.createDoor(room029,"south",room026);
       
       this.createDoor(room027,"east",room028);
       this.createDoor(room028,"west",room027);
       
       this.createDoor(room028,"east",room029);
       this.createDoor(room029,"west",room028);
       
       this.createDoor(room028,"north",room030);
       this.createDoor(room030,"south",room028);
       
       // Level 3 Rooms
       
       this.createDoor(room031,"east",room032);
       this.createDoor(room032,"west",room031);
       
       this.createDoor(room032,"east",room033);
       this.createDoor(room033,"west",room032);
       
       this.createDoor(room031,"north",room034);
       this.createDoor(room034,"south",room031);
       
       this.createDoor(room032,"north",room035);
       this.createDoor(room035,"south",room032);
       
       this.createDoor(room033,"north",room036);
       this.createDoor(room036,"south",room033);
       
       this.createDoor(room034,"east",room035);
       this.createDoor(room035,"west",room034);
       
       this.createDoor(room035,"east",room036);
       this.createDoor(room036,"west",room035);
       
       this.createDoor(room034,"north",room037);
       this.createDoor(room037,"south",room034);
       
       this.createDoor(room035,"north",room038);
       this.createDoor(room038,"south",room035);
       
       this.createDoor(room036,"north",room039);
       this.createDoor(room039,"south",room036);
       
       this.createDoor(room037,"east",room038);
       this.createDoor(room038,"west",room037);
       
       this.createDoor(room038,"east",room039);
       this.createDoor(room039,"west",room038);
       
       this.createDoor(room038,"north",room040);
       this.createDoor(room040,"south",room038);
       
       // Level 4 Rooms
       
       this.createDoor(room041,"east",room042);
       this.createDoor(room042,"west",room041);
       
       this.createDoor(room042,"east",room043);
       this.createDoor(room043,"west",room042);
       
       this.createDoor(room041,"north",room044);
       this.createDoor(room044,"south",room041);
       
       this.createDoor(room042,"north",room045);
       this.createDoor(room045,"south",room042);
       
       this.createDoor(room043,"north",room046);
       this.createDoor(room046,"south",room043);
       
       this.createDoor(room044,"east",room045);
       this.createDoor(room045,"west",room044);
       
       this.createDoor(room045,"east",room046);
       this.createDoor(room046,"west",room045);
       
       this.createDoor(room044,"north",room047);
       this.createDoor(room047,"south",room044);
       
       this.createDoor(room045,"north",room048);
       this.createDoor(room048,"south",room045);
       
       this.createDoor(room046,"north",room049);
       this.createDoor(room049,"south",room046);
       
       this.createDoor(room047,"east",room048);
       this.createDoor(room048,"west",room047);
       
       this.createDoor(room048,"east",room049);
       this.createDoor(room049,"west",room048);
       
       this.createDoor(room048,"north",room050);
       this.createDoor(room050,"south",room048);
       
       // Level 5 Rooms
       this.createDoor(room051,"north",room052);
       
       // One direction exits.
       
       //Level Tutoiral - 1
       this.createDoor(room010,"north",room012);
       // Level 1 - 2
       this.createDoor(room020,"north",room022);
       // Level 2 - 3
       this.createDoor(room030,"north",room032);
       // Level 3 - 4
       this.createDoor(room040,"north",room042);
       // Level 4 - 5
       this.createDoor(room050,"north",room051);
       
       
    }
    
    /**
     * This method is responsible for greating the items in the world.
     */
    public void createItems() {
        // Creating of Items
        Item smallHealthPotion = new Item("small heatlh potion", "heals 10 health points ", 5, 1.0);
        Item largeHealthPotion = new Item("large health potion", "heals 25 health points ", 7, 1.0);
        Item smallManaPotion = new Item("small mana potion","adds 7 mana points ", 5, 1.0);
        Item largeManaPotion = new Item("large mana potion", "used to buy things in the shop ", 7, 1.0);
        Item coin = new Item("coin", "used to buy things in the shop ", 1, 0.0);
        Item fireArrow = new Item("fire arrow", "Set enemies ablaze with fire arrows does 15 over X combat turns where X is your box level. ", 1, 0.1);
        
        //Creating Keys
        Item key007 = new Item("key 007", "This key unlocks the norht door in Room 007", 10, 0.1);
        Item key018 = new Item("key 018", "This key unlocks the norht door in Room 018", 10, 0.1);
        Item key028 = new Item("key 028", "This key unlocks the norht door in Room 028", 10, 0.1);
        Item key038 = new Item("key 038", "This key unlocks the norht door in Room 038", 10, 0.1);
        Item key048 = new Item("key 048", "This key unlocks the norht door in Room 048", 10, 0.1);
        
        // Creating Containers
        Container chest006 = new Container("chest","This is a chests",0,11.0);
        Container chest017 = new Container("chest","This is a chests",0,11.0);
        Container chest025 = new Container("chest","This is a chests",0,11.0);
        Container chest037 = new Container("chest","This is a chests",0,11.0);
        Container chest048 = new Container("chest","This is a chests",0,11.0);
        Container chest051 = new Container("chest","This is a chests",0,11.0);
        
        // Putting items into a container.
        chest006.addItem(smallHealthPotion);
        chest006.addItem(smallManaPotion);
        chest006.addItem(coin);
        chest006.addItem(fireArrow);
        chest006.addItem(key007);
        
        chest017.addItem(smallHealthPotion);
        chest017.addItem(smallManaPotion);
        chest017.addItem(coin);
        chest017.addItem(fireArrow);
        chest017.addItem(key018);
        
        chest025.addItem(smallHealthPotion);
        chest025.addItem(smallManaPotion);
        chest025.addItem(coin);
        chest025.addItem(fireArrow);
        chest025.addItem(key028);
        
        chest037.addItem(smallHealthPotion);
        chest037.addItem(smallManaPotion);
        chest037.addItem(coin);
        chest037.addItem(fireArrow);
        chest037.addItem(key038);
        
        chest048.addItem(smallHealthPotion);
        chest048.addItem(smallManaPotion);
        chest048.addItem(coin);
        chest048.addItem(fireArrow);
        chest048.addItem(key048);
        
        chest051.addItem(smallHealthPotion);
        chest051.addItem(smallManaPotion);
        chest051.addItem(coin);
        chest051.addItem(fireArrow);
        
        //Adding items to the world
        this.getRoom("Tutorial Room 006").addItem(chest006);
        this.getRoom("Dungeon Room 017").addItem(chest017);
        this.getRoom("Dungeon Room 025").addItem(chest025);
        this.getRoom("Dungeon Room 037").addItem(chest037);
        this.getRoom("Dungeon Room 048").addItem(chest048);
        this.getRoom("Dungeon Room 051").addItem(chest051);
        //this.getRoom("").addItem();
        
        // Lock some doors
       this.getRoom("Tutorial Room 007").getExit("north").setLocked(true);
       this.getRoom("Dungeon Room 018").getExit("north").setLocked(true);
       this.getRoom("Dungeon Room 028").getExit("north").setLocked(true);
       this.getRoom("Dungeon Room 038").getExit("north").setLocked(true);
       this.getRoom("Dungeon Room 048").getExit("north").setLocked(true);
       
       // Setting keys to doors
       this.getRoom("Tutorial Room 007").getExit("north").setKey(key007.getName());
       this.getRoom("Dungeon Room 018").getExit("north").setKey(key018.getName());
       this.getRoom("Dungeon Room 028").getExit("north").setKey(key028.getName());
       this.getRoom("Dungeon Room 038").getExit("north").setKey(key038.getName());
       this.getRoom("Dungeon Room 048").getExit("north").setKey(key048.getName());
    }
}
