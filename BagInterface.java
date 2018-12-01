
/**
 * Write a description of interface BagInterface here.
 *
 * @author W Jacob Reilley
 * @version 18_12_1
 */
public interface BagInterface<T> {

    /**
     * This method will give the current size of the bag
     * @return an int of the bag size.
     */
    public int getCurrentSize();

    /**
     * This method will tell if the bag is empty or not
     * @return a boolean of wheteher the bag is empty.
     */
    public boolean isEmpty();

    /**
     * This method will add items to the bag.
     * @param newEntry the item being added to the bag.
     * @return if the add was successful
     */
    public boolean add(T newEntry);

    /**
     * This method will remove and item from the bag
     * @param anEntry the item to be removed form the bag.
     * @return a boolean of whether the remove was successful
     */
    public boolean remove(T anEntry);

    /**
     * This method will remove a random item from the bag.
     * @return the item that was removed at random
     */
    public T remove();

    /**
     * This method will clear the bag
     */
    public void clear();

    /**
     * This method will check the bag for an item.
     * @param anEntry the item being searched for.
     * @return a boolean of whether the item is there.
     */
    public boolean containsEntry(T anEntry);

    /**
     * This method will convert the contents of the bagg to an array.
     * @return an array of the bag contents.
     */
    public T[] toArray();

}
