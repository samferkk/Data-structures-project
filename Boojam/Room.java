import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 * 
 * This class is part of the "Campus of Kings" application. "Campus of Kings" is a
 * very simple, text based adventure game.
 * 
 * A "Room" represents one location in the scenery of the game. It is connected
 * to other rooms via doors. The doors are labeled north, east, south, west.
 * For each direction, the room stores a reference to an instance of door.
 * 
 * @author Maria Jump
 * @version 2015.02.01
 */
public class Room {
    /** Counter for the total number of rooms created in the world. */
    private static int counter;
    /** The name of this room.  Room names should be unique. */
    private String name;
    /** The description of this room. */
    private String description;
    /** 
     * This feild is for storing the ponits awarded for entering a room.
     */
    private int points;
    /**
     * This feild  is a hashmap of all the directions.
     */
    private HashMap<String, Door> exits;
    /**
     * This is the feild for store thye collectio of items in the room.
     */
    private HashSet<Item> roomItems;

    /**
     * Static initializer.
     */
    static {
        counter = 0;
    }
    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "a kitchen" or "an open court yard".
     * 
     * @param name  The room's name.
     * @param description
     *            The room's description.
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new HashMap<String, Door>();
        roomItems = new HashSet<Item>();
        counter++;
    }
    
    /**
     * This is the getter for the points. this iwll also set the points to zero after retreiving.
     * @return the point for the room.
     */
    public int getPoints() {
        int tempPoints = points;
        points = 0;
        return tempPoints;
    }
    
    /**
     * Returns the name of this room.
     * 
     * @return The name of this room.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of this room.
     * 
     * @return The description of this room.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the number of rooms that have been created in the world.
     * @return The number of rooms that have been created in the world.
     */
    public static int getCounter() {
        return counter;
    }

    /**
     * This is the accessor for the specified Exit.
     * @param direction is the direction of the exit.
     * @return the north exit.
     * 
     */
    public Door getExit(String direction) {
        return exits.get(direction);   
    }
    
    /**
     * This is the mutator for the points feild.
     * @param pointValue is the the amount of points to be awarded.
     */
    public void setPoints(int pointValue) {
        points = pointValue;
    }
    
    /**
     * This is the mutator for the specific Exit.
     * @param theDoor is the specific exit.
     * @param theDirection is the direciton of the exit.
     */
    public void setExit(Door theDoor, String theDirection) {
        exits.put(theDirection,theDoor);
    }

    /**
     * Return the string description including all the details of a Room.
     * @return A string representing all the details of a Room.
     */
    public String toString() {
        String theString = "";
        String roomName = String.format("%s%s", name, ": ");
        String roomDescription = String.format("%s", description);
        String roomExits = String.format("%s", "Exits: ");
        String roomItemString = "";
        for (Item item : roomItems) {
            roomItemString += String.format("%s, ", item.getName());
        }
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            roomExits += String.format("%s ",exit);
        }
        
        theString += String.format("%s\n%s\n%s\n%s", roomName, roomDescription, roomItemString, roomExits);
        return theString;
    }
    
    // Item related Methods
    /**
     * This is the method for adding items to the room.
     * @param newItem is the item to be added to the room.
     */
    public void addItem(Item newItem) {
        roomItems.add(newItem);
    }
    
    /**
     * This is the method for getting and item by its name.
     * @param itemName is the name of the desired item.
     * @return the desired item.
     */
    public Item getItem(String itemName) {
        Item desiredItem = null;
        Iterator<Item> iter = roomItems.iterator();
        boolean found = false;
        while (iter.hasNext() && !found) {
            Item testItem = iter.next();
            if (itemName.equals(testItem.getName())) {
                found = true;
                desiredItem = testItem;
            }
        }
        return desiredItem;
    }
    
    /**
     * This is a method for removing items from a room.
     * @param removingItem is the item to be removied.
     * @return the tiem that was removed or null if no item exists.
     */
    public Item removeItem(String removingItem) {
        Item removedItem = this.getItem(removingItem);
        roomItems.remove(removedItem);
        return removedItem;
    }
}
