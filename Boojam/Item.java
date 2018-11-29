
/**
 * This calss will be used for defineing items.
 *
 * @author William Jacob Reilley
 * @version 2018.04.22
 */
public class Item {
    /**
     * This feild will store the name of the item.
     */
    private String name;
    /**
     * This feild will store the item description.
     */
    private String description;
    
    /**
     * This is the Constructor for an item.
     * 
     * @param nameJawn is the name of the item.
     * @param descriptionJawn is the description of the item.
     */
    public Item (String nameJawn, String descriptionJawn) {
        name = nameJawn;
        description = descriptionJawn;
    }

    /**
     * This is the accessor for the name feild.
     * @return a string of the name.
     */
    public String getName() {
        return name;
    }

    /**
     * This is the accessor for the description feild.
     * @return a string of the description.
     */
    public String getDescription() {
        return description;
    }
    
    
    /**
     * This is the mutator for the description.
     * @param newDescription is the new description.
     */
    public void setDescription(String newDescription) {
        description = newDescription;
    }
    
    /**
     * This is a method for geting the info of an item as a string.
     * @return a sting of the item information.
     */
    public String toString() {
        String theString = String.format("%s\n%s\nWeight: %s", name, description);
        return theString;
    }
}

