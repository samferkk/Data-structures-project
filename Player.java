import java.util.HashSet;
import java.util.Iterator;

/**
 * This class stores a player.
 *
 * @author Jake Reillley
 * @version 2018-01-23
 */
public class Player {
    /** This feild will sotre the players maximum carry weight. */
    public final static int MAXIMUM_WEIGHT = 10;

    /** This feild stores the players current room. */
    private Room currentPlayerRoom;
    /** This feild stroes the players previous room. */
    private Room previousPlayerRoom;
    /** This feild stores the players inventory. */
    private LinkedListBag<Item> playerItems;
    /** This feild will hold the shopping list for the player. */
    private StackLinked<String> shoppingList;

    /**
     * This is thre default constructor for a player object.
     * @param startingRoom is the starting room of the player.
     */
    public Player(Room startingRoom) {
        currentPlayerRoom = startingRoom;
        previousPlayerRoom = null;
        playerItems = new LinkedListBag<Item>();
        shoppingList = new StackLinked<String>();
    }

    /**
     * This is the accessor fo the players current room.
     * @return the players current room.
     */
    public Room getCurrentPlayerRoom() {
        return currentPlayerRoom;
    }

    /**
     * This the the accessor for the players previous room.
     * @return the players previos room.
     */
    public Room getPreviousPlayerRoom(){
        return previousPlayerRoom;
    }

    /**
     * This is the mutator for the player's current room.
     * This method also sets the previous room to the current room before moving the the new room.
     * @param newRoom is the new room the player is in.
     */
    public void setCurrentPlayerRoom(Room newRoom) {
        previousPlayerRoom = currentPlayerRoom;
        currentPlayerRoom = newRoom;
    }

    // Item Related Methods

    /**
     * This method will add items to the players inventory.
     * @param newItem is the item to be added.
     * @return an boolean of whether or not the item was successfully added.
     */
    public boolean addItem(Item newItem) {
        boolean result = false;
        playerItems.add(newItem);
        result = true;

        return result;
    }

    /**
     * This method will be responcible for getting the player inventory.
     * @return a string of the items.
     */
    public String getInventory() {
        String theString = "";
        Object[] tempArray = playerItems.toArray();
        for (int index = 0; index < tempArray.length; index++) {
            Item currentItem = (Item)tempArray[index];
            theString += String.format("%s ", currentItem.getName());
        }
        return theString;
    }

    /**
     * This method will get items from the players inventory.
     * @param desiredItem is the name of the item you want.
     * @return the item that is desired.
     */
    public Item getItem(String desiredItem) {
        Item theItem = null;
        Object[] tempArray = playerItems.toArray();
        boolean found = false;
        int index = 0;
        while (index < tempArray.length && !found) {
            Item testItem = (Item)tempArray[index];
            if (desiredItem.equalsIgnoreCase(testItem.getName())) {
                found = true;
                theItem = testItem;
            }
            index++;
        }
        return theItem;
    }

    /**
     * This method will check to see if an item is in the players inventory.
     * @param desiredItem is the name of the item you want.
     * @return a boolean of if the item is present.
     */
    public boolean hasItem(String desiredItem) {
        Object[] tempArray = playerItems.toArray();
        boolean found = false;
        int index = 0;
        while (index < tempArray.length && !found) {
            Item testItem = (Item)tempArray[index];
            if (desiredItem.equalsIgnoreCase(testItem.getName())) {
                found = true;
            }
            index++;
        }
        return found;
    }

    /**
     * This is a method for removing items from a room.
     * @param removingItem is the item to be removied.
     * @return the tiem that was removed or null if no item exists.
     */
    public Item removeItem(String removingItem) {
        Item removedItem = this.getItem(removingItem);
        playerItems.remove(removedItem);
        return removedItem;
    }

    /**
     * THis method is used for seeing how much weight the player has left to carry.
     * @return a double of the remainign weight for the player to carry.
     */
    public double getRemainingWeight() {
        double currentInventoryWeight = 0.0;
        for(Item item : playerItems.toArray()) {
            currentInventoryWeight += item.getWeight();
        }
        double remainingWeight = MAXIMUM_WEIGHT - currentInventoryWeight;
        return remainingWeight;
    }

    /**
     * This method will allow items to be added to the Shopping List.
     * @param listItem is a string of the item to be added to the list.
     */
    public void addListItem(String listItem) {
        shoppingList.push(listItem);
    }

    /**
     * This method will read the top item from the shopping List.
     * @retrun a string of the top item.
     */
    public String readList() {
        String output = null;
        if(shoppingList.isEmpty() != true) {
            output = shoppingList.peek();
        }
        else{
            output = "The List is empty";
        }
        return output;
    }

    /**
     * This method will remove the top item form the Shopping List.
     * @return a string of the tiem removed.
     */
    public String removeListItem() {
        return shoppingList.pop();
    }

    /**
     * This method will tell if the shopping list is empty.
     * @return a boolean of the list's state.
     */
    public boolean isListEmpty() {
        return shoppingList.isEmpty();
    }
}

