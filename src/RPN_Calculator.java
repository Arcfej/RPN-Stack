import java.util.Scanner;

public class RPN_Calculator {

    /**
     * Calculate expressions written in reverse polish notation.
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
        while (!command.equals("2")) {
            command = printMenu(in);
            System.out.println();
            switch (command) {
                case "1":
                    System.out.println("The expression:");
                    try {
                        double result = rpn.calculate(in.nextLine());
                        System.out.println("The result is: " + result);
                    } catch (InvalidExpressionException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
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
        System.out.println("2) Exit");
        return in.nextLine();
    }

    public double calculate(String expression) throws InvalidExpressionException {
        String[] split = expression.split(" ");

        try {
            Double.parseDouble(split[split.length - 1]);
            throw new InvalidExpressionException(InvalidExpressionException.EXPRESSION_ENDING_WITH_NUMBER_MESSAGE);
        } catch (NumberFormatException ignore) {}

        Stack numbers = new Stack();
        for (String arg : split) {
            if (arg.equals("")) continue;
            try {
                numbers.push(Double.parseDouble(arg));
            } catch (NumberFormatException e) {
                numbers.push(operate(arg, numbers));
            }
        }

        double result;
        try {
            result = numbers.pop();
        } catch (EmptyStackException e) {
            throw new InvalidExpressionException(InvalidExpressionException.EMPTY_EXPRESSION_MESSAGE);
        }

        if (numbers.isEmpty()) {
            return result;
        } else {
            throw new InvalidExpressionException(InvalidExpressionException.TOO_MUCH_NUMBER_MESSAGE);
        }
    }

    private double operate(String operator, Stack numbers) throws InvalidExpressionException {
        double n1;
        double n2;
        try {
            n2 = numbers.pop();
            n1 = numbers.pop();
        } catch (EmptyStackException e) {
            switch (operator) {
                case "+": case "-": case "*": case "/":
                    break;
                default:
                    throw new InvalidExpressionException(InvalidExpressionException.INVALID_OPERATOR_MESSAGE + operator);
            }
            throw new InvalidExpressionException(InvalidExpressionException.TOO_FEW_NUMBER_MESSAGE);
        }

        switch (operator) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                if (n2 == 0) {
                    throw new InvalidExpressionException(InvalidExpressionException.DIVIDING_WITH_ZERO_MESSAGE);
                } else {
                    return n1 / n2;
                }
            default:
                throw new InvalidExpressionException(InvalidExpressionException.INVALID_OPERATOR_MESSAGE + operator);
        }
    }
}
