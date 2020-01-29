import java.util.Scanner;

public class RPN_Stack {

    /**
     * Calculate expressions written in reverse polish notation.
     */
    public RPN_Stack() {

    }

    /**
     * Display a menu to the user and ask for expressions written in reverse polish notation, then calculate them.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RPN_Stack rpn = new RPN_Stack();
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
                    } catch (Exception e) {

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

    public double calculate(String expression) {
        return 0;
    }
}
