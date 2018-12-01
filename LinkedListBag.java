
/**
 * Write a description of class LinkedListBag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedListBag<T> implements BagInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedListBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * This method will give the current size of the bag
     * @return an int of the bag size.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * This method will tell if the bag is empty or not
     * @return a boolean of wheteher the bag is empty.
     */
    public boolean isEmpty() {
        boolean empty = true;
        if(firstNode != null) {
            empty = false;
        }
        return empty;
    }

    /**
     * This method will add items to the bag.
     * @param newEntry the item being added to the bag.
     * @return if the add was successful
     */
    public boolean add(T newEntry) {
        boolean addSuccesful = false;
        Node newNode = new Node(newEntry);
        newNode.setNext(firstNode);
        firstNode = newNode;
        numberOfEntries++;
        addSuccesful  = true;
        return addSuccesful;
    }

    /**
     * This method will remove and item from the bag
     * @param anEntry the item to be removed form the bag.
     * @return a boolean of whether the remove was successful
     */
    public boolean remove(T anEntry) {
        boolean result = false;
        Node wanted = getReferenceTo(anEntry);
        if (wanted != null) {
            wanted.data = firstNode.getData();
            firstNode = firstNode.getNext();
            numberOfEntries--;
            result = true;
        }
        return result;
    }

    /**
     * This method will remove a random item from the bag.
     * @return the item that was removed at random
     */
    public T remove() {
        T result = null;
        if(firstNode != null) {
            result = firstNode.getData();
            firstNode = firstNode.getNext();
            numberOfEntries--;
        }
        return result;
    }

    /**
     * This method will clear the bag
     */
    public void clear() {
        firstNode = null;
    }

    /**
     * This method will check the bag for an item.
     * @param anEntry the item being searched for.
     * @return a boolean of whether the item is there.
     */
    public boolean containsEntry(T anEntry){
        boolean containsItem = false;
        Node selected = getReferenceTo(anEntry);
        if(selected != null){
            containsItem = true;
        }
        return containsItem;
    }

    /**
     * This is a helper method for finding nodes.
     * @param anEntry the entry we are looking for.
     * @return the node that mathes the entry.
     */
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node current = firstNode;
        while(!found && (current != null)) {
            if (anEntry.equals(current.getData())) {
                found = true;
            } else {
                current = current.getNext();
            }
        }
        return current;
    }

    /**
     * This method will convert the contents of the bag to an array.
     * @return an array of the bag contents.
     */
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Object[numberOfEntries];
        Node workingNode = firstNode;
        for(int index = 0; index < tempArray.length; index++) {
            tempArray[index] = workingNode.getData();
            workingNode = workingNode.getNext();
        }
        return tempArray;
    }

    private class Node {
        private T data; // entry in the bag
        private Node next; // Next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        /**
         * This method will fetch the data of a node.
         * @return the adata contained in the node.
         */
        public T getData() {
            return data;
        }

        /**
         * This method will retrieve the next node of the list.
         * @return the next node.
         */
        public Node getNext() {
            return next;
        }

        /**
         * This method will allow the setting of the next node
         * @pararm nextNodeValue will be the node that is to be placed.
         */
        public void setNext(Node nextNodeValue) {
            next = nextNodeValue;
        }
    }

}
