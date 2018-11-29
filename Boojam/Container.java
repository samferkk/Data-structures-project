import java.util.HashSet;
import java.util.Iterator;

/**
 * A class for defining containers that will contain items.
 *
 * @author William Jacob Reilley
 * @version 26.04.2018
 */
public class Container extends Item {
    /** This feild will sotre the items contained with in the container. */
    private HashSet<Item> containerItems;

    /**
     * This is the construsctor for the conatiner.
     * 
     * @param nameJawn is the name of the item.
     * @param descriptionJawn is the description of the item.
     * @param pointJawns is the point value of the item.
     * @param weightJawn is the weight of the item.
     */
    public Container (String nameJawn, String descriptionJawn, int pointJawns, double weightJawn) {
        super(nameJawn, descriptionJawn, pointJawns, weightJawn);
        containerItems = new HashSet<Item>();
    }
    
    /**
     * This method will get the weight of the container and its contents.
     * @return a double of teh total weight.
     */
    public double getWeight() {
        double totalWeight = super.getWeight();
        for (Item item : containerItems) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
    
    /**
     * This method is the toString method for container.
     * @return a string of the containers contents.
     */
    public String toString() {
        String theString = "";
        theString += super.toString();
        for (Item item : containerItems) {
            theString += item.toString() +"\n";
        }
        return theString;
    }

    /** 
     * This method will be use to add items to the container.
     * @param item is the beign added.
     */
    public void addItem(Item item) {
        containerItems.add(item);
    }

    /**
     * This method will check to see if the container has an item.
     * @param itemName is the item to be checked.
     * @return a boolean of if the item is contained or not.
     */
    public boolean hasItem(String itemName) {
        boolean found = false;
        Iterator<Item> iter = containerItems.iterator();
        while (iter.hasNext() && !found) {
            Item testItem = iter.next();
            if (itemName.equals(testItem.getName())) {
                found = true;
            }
        }
        return found;
    }

    /**
     * This is the method for removing items from the container.
     * @param name is the name of the desired item.
     * @return the item that was desried.
     */
    public Item removeItem(String name) {
        Item theItem = null;
        boolean found = false;
        Iterator<Item> iter = containerItems.iterator();
        while (iter.hasNext() && !found) {
            Item testItem = iter.next();
            if (name.equals(testItem.getName())) {
                theItem = testItem;
                iter.remove();
                found = true;
            }
        }
        return theItem;
    }
}
