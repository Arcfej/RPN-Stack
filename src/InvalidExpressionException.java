public class InvalidExpressionException extends Exception {

    public static final String TOO_MUCH_NUMBER_MESSAGE = "Too much numbers are in the exception.";
    public static final String TOO_FEW_NUMBER_MESSAGE = "Too few numbers are in the exception.";
    public static final String EXPRESSION_ENDING_WITH_NUMBER_MESSAGE = "Expression is ending with a number.";
    public static final String INVALID_OPERATOR_MESSAGE = "Invalid operator: ";
    public static final String DIVIDING_WITH_ZERO_MESSAGE = "The expression contains a division by zero.";
    public static final String EMPTY_EXPRESSION_MESSAGE = "The expression is empty.";

    private String message;

    public InvalidExpressionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
