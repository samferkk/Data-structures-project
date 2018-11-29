/**
 * Class Door - a door or portal between two Rooms in an adventure game.
 * 
 * This class is part of the "Campus of Kings" application. "Campus of Kings" is a
 * very simple, text based adventure game.
 * 
 * A "Door" represents a door or portal between two locations of the game.
 * It stores a reference to the neighboring room and whether that door
 * or portal is locked.  Doors are not locked by default.
 * 
 * @author Maria Jump
 * @version 2015.02.01
 */
public class Door {
    
    /** The room that this door leads to. */
    private Room destination;
    /** Whether this door is locked. */
    private boolean locked;
    /** this feild is for storing the name id the key that unlocks the door. */
    private String key;
    
    /**
     * Constructor for the Door class.
     * @param destination The room this door leads to
     */
    public Door(Room destination) {
        this.destination = destination;
        this.locked = false;
        key = null;
        
    }
    
    /**
     * A getter for the room this door leads to.
     * @return The room this door leads to
     */
    public Room getDestination() {
        return destination;
    }
    
    /**
     * A getter for whether this door is locked.
     * @return Whether this door is locked
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * A setter for whether this door is locked.
     * @param locked Whether this door is locked.
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    
    /**
     * This method is for getting the key for a door.
     * @return a string of the name of the key required to unlock the door.
     */
    public String getKey() {
       return key;
    }
    
    /**
     * This method is used to set the key the will be need for unlocking the door.
     * @param keyJawn is the key that will be used to open the door.
     */
    public void setKey(String keyJawn) {
        key = keyJawn;
    }
}
