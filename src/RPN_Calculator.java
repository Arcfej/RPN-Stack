import java.util.Scanner;

/**
 * A reverse polish notation calculator.
 * Can calculate any expressions written in reverse polish notation and handle all the occurring errors.
 */
public class RPN_Calculator {

    /**
     * Base constructor of the class.
     */
    public RPN_Calculator() {

    }

    /**
     * Display a menu to the user and ask for expressions written in reverse polish notation, then calculate them.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RPN_Calculator rpn = new RPN_Calculator();
        String command = "";

        // Display menu and chose one.
        while (!command.equals("2")) {
            command = printMenu(in);
            System.out.println();
            switch (command) {
                case "1":
                    System.out.println("The expression:");
                    try {
                        double result = rpn.calculate(in.nextLine(), " ");
                        System.out.println("The result is: " + result);
                    } catch (InvalidRPNExpressionException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Type in a whole and valid Reverse Polish Notation expression and the program will calculate it for you.");
                    System.out.println("If you don't know how to write a Reverse Polish Notation expression, visit the wikipedia page: https://en.wikipedia.org/wiki/Reverse_Polish_notation");
                case "3":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Not a valid command");
            }
        }
    }

    /**
     * Print a menu for the user and take their command.
     *
     * @param in The scanner through the user gives their command.
     * @return the command given by the user.
     */
    private static String printMenu(Scanner in) {
        System.out.println();
        System.out.println("1) Type in expression");
        System.out.println("2) How to use the calculator");
        System.out.println("3) Exit");
        return in.nextLine();
    }

    /**
     * Calculate the result of the given RPN expression.
     *
     * @param expression The expression to calculate.
     * @param divider The divider used in the expression to divide the numbers and operators.
     * @return the result of the calculation.
     * @throws InvalidRPNExpressionException if an error occurred during the calculation and/or the expression is invalid.
     */
    public double calculate(String expression, String divider) throws InvalidRPNExpressionException {
        String[] split = expression.trim().split(divider);

        // Check if the last character on the expression is a number.
        try {
            Double.parseDouble(split[split.length - 1]);
            throw new InvalidRPNExpressionException(InvalidRPNExpressionException.EXPRESSION_ENDING_WITH_NUMBER_MESSAGE);
        } catch (NumberFormatException ignore) {}

        Stack numbers = new Stack();

        // Iterate through the expression
        for (String arg : split) {
            // Ignore whitespaces
            if (arg.equals("")) continue;
            try {
                // If it's a number push it into the stack
                numbers.push(Double.parseDouble(arg));
            } catch (NumberFormatException e) {
                // If it's an operator, execute the operation on the last two numbers and push the result into the stack
                numbers.push(operate(arg, numbers));
            }
        }

        double result;
        try {
            // The last number in the stack should be the result of the expression
            result = numbers.pop();
        } catch (EmptyStackException e) {
            // If the stack is empty, the expression was blank
            throw new InvalidRPNExpressionException(InvalidRPNExpressionException.EMPTY_EXPRESSION_MESSAGE);
        }

        if (numbers.isEmpty()) {
            // If there's nothing left in the stack, the expression was valid, return the result.
            return result;
        } else {
            // There are too much number in the expression, throw an error.
            throw new InvalidRPNExpressionException(InvalidRPNExpressionException.TOO_MUCH_NUMBER_MESSAGE);
        }
    }

    /**
     * Execute operation on two numbers
     *
     * @param operator The operation to execute
     * @param numbers The stack of numbers to operate upon
     * @return The result of the operation
     * @throws InvalidRPNExpressionException if an error occurred during the operation
     */
    private double operate(String operator, Stack numbers) throws InvalidRPNExpressionException {
        // The two numbers to operate upon
        double n1;
        double n2;
        try {
            // Try to get the numbers from the stack
            n2 = numbers.pop();
            n1 = numbers.pop();
        } catch (EmptyStackException e) {
            // Error while retreading numbers
            switch (operator) {
                case "+": case "-": case "*": case "/":
                    // The error occurred because of an invalid operator.
                    // Probably because the divider missing between a number and the operator next to it.
                    throw new InvalidRPNExpressionException(InvalidRPNExpressionException.TOO_FEW_NUMBER_MESSAGE);
                default: // There aren't two numbers to operate upon
                    throw new InvalidRPNExpressionException(InvalidRPNExpressionException.INVALID_OPERATOR_MESSAGE + operator);
            }
        }

        // Execute the operation
        switch (operator) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                if (n2 == 0) {
                    // Dividing with zero error
                    throw new InvalidRPNExpressionException(InvalidRPNExpressionException.DIVIDING_WITH_ZERO_MESSAGE);
                } else {
                    return n1 / n2;
                }
            default:
                // Invalid operator error
                throw new InvalidRPNExpressionException(InvalidRPNExpressionException.INVALID_OPERATOR_MESSAGE + operator);
        }
    }
}
