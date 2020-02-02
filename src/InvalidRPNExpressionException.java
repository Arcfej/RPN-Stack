/**
 * This error is thrown when an invalid expression is provided to the RPN calculator.
 */
public class InvalidRPNExpressionException extends Exception {

    /**
     * The error message when there is too much number in the expression.
     */
    public static final String TOO_MUCH_NUMBER_MESSAGE = "Too muc" +
            "h numbers are in the exception.";
    /**
     * The error message when there is too few number in the expression.
     */
    public static final String TOO_FEW_NUMBER_MESSAGE = "Too few numbers are in the exception.";

    /**
     * The error message when the expression is ending with a number.
     */
    public static final String EXPRESSION_ENDING_WITH_NUMBER_MESSAGE = "Expression is ending with a number.";

    /**
     * The error message when the expression contains an invalid operator.
     */
    public static final String INVALID_OPERATOR_MESSAGE = "Invalid operator: ";

    /**
     * The error message when a division by zero occurred during a calculation.
     */
    public static final String DIVIDING_WITH_ZERO_MESSAGE = "The expression contains a division by zero.";

    /**
     * The error message when a blank expression is provided to the calculator.
     */
    public static final String EMPTY_EXPRESSION_MESSAGE = "The expression is empty.";

    /**
     * The error message/cause of the error.
     */
    private String message;

    /**
     * Base constructor of the class.
     *
     * @param message The message/cause of the error.
     */
    public InvalidRPNExpressionException(String message) {
        this.message = message;
    }

    /**
     * Get the message/cause of the error.
     *
     * @return the message/cause of the error.
     */
    public String getMessage() {
        return message;
    }
}
