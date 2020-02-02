/**
 * An error which is thrown when you try to pop from an empty stack.
 */
public class EmptyStackException extends Exception {

    /**
     * The message/cause of the error
     */
    private String message;

    /**
     * Base constructor of the class
     *
     * @param message The cause of the error
     */
    public EmptyStackException(String message) {
        this.message = message;
    }

    /**
     * Return the cause/message of the error
     *
     * @return the cause/message of the error
     */
    public String getMessage() {
        return message;
    }
}
