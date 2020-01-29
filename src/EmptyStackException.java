public class EmptyStackException extends Exception {

    private String message;

    public EmptyStackException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
