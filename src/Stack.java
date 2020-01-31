/**
 * Basic implementation of a stack data structure
 */
public class Stack {

    /**
     * The stack, based on a LinkedList
     */
    private final LinkedList stack;

    /**
     * Default constructor. Creates an empty stack
     */
    public Stack() {
        stack = new LinkedList();
    }

    /**
     * Add a new number to the top of the stack
     *
     * @param number The number to add to the stack.
     */
    public void push(double number) {
        stack.addToList(number);
    }

    /**
     * Delete the top node of the stack and return its number.
     *
     * @return The number of the top node
     * @throws EmptyStackException if the stack was empty.
     */
    public double pop() throws EmptyStackException {
        if (stack.isListEmpty()) {
            throw new EmptyStackException("The stack is empty, you cannot pop it.");
        } else {
            double last = stack.getHead().getNumber();
            stack.deleteFromStart();
            return last;
        }
    }

    /**
     * Return true if the stack is empty
     *
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return stack.isListEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        ListNode marker = stack.getHead();

        if (stack.isListEmpty())
        {
            return LinkedList.EMPTY_LIST_ERROR_MESSAGE;
        }

        stringBuilder.append("The list contains:\n");
        while (marker != null)
        {
            stringBuilder.append(marker).append(", ");
            marker = marker.getNext();
        }
        return stringBuilder.toString();
    }
}
