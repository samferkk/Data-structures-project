import java.util.EmptyStackException;
/**
 * Write a description of class StackLinked here.
 *
 * @author W Jacob Reilley
 * @version 18_12_1
 */


public class StackLinked<T> implements StackInterface<T> {
    /**
     * This varible will house the first node of the list.
     */
    private Node firstNode;
    /**
     * Inner class for nodes
     */
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
         * @return the nesxt node.
         */
        public Node getNext() {
            return next;
        }
    }

    public StackLinked() {
        firstNode = null;
    }

    /**
     * This method will push items on to the top of the stack.
     *
     * @param newItem is the item being added.
     */
    public void push(T newItem) {
        Node newNode = new Node(newItem, firstNode);
        firstNode = newNode;
    }

    /**
     * This method will remove and return the top item of the stack
     *
     * @return the top item of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop() {
        T returnData = null;
        if(firstNode != null) {
            returnData = firstNode.getData();
            firstNode = firstNode.getNext();
        }
        else {
            throw new EmptyStackException() ;
        }
        return returnData;
    }

    /**
     * This method allows a peek at the top item of the stack with out removing it.
     *
     * @return the top item of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T peek() {
        T returnData = null;
        if(firstNode != null) {
            returnData = firstNode.getData();
        }
        else {
            throw new EmptyStackException() ;
        }
        return returnData;
    }

    /**
     * This method will check if the stack is empty
     *
     * @return a boolean if the stack is empty or not.
     */
    public boolean isEmpty() {
        boolean stackEmpty = false;
        if(firstNode == null){
            stackEmpty = true;
        }
        return stackEmpty;
    }

    /**
     * This method will clear the stack of all contents.
     */
    public void clear() {
    firstNode = null;
    }
}
