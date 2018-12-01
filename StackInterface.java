
/**
 * Write a description of interface StackInterface here.
 *
 * @author W Jacob Reilley
 * @version 18_12_1
 */
public interface StackInterface<T> {

    /**
     * This method will puch items on to the top of the stack.
     * @param newItem is the tiem being added.
     */
    void push(T newItem);

    /**
     * This method will remove and return the top item of the stack
     * @return the top item of the stack
     * @throws EmptyStackException if the stack is empty
     */
    T pop();

    /**
     * This method allows a peek at the top item of the stack with out removing it.
     * @return the top item of the stack
     * @throws EmptyStackException if the stack is empty
     */
    T peek();

    /**
     * This method will check if the stack is empty
     * @return a boolean if the stack is empty or not.
     */
    boolean isEmpty();

    /**
     * This method will clear the stack of all contents.
     */
    void clear();
}
