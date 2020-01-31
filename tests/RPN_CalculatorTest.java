import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RPN_CalculatorTest {

    @Test
    void calculateWithEmptyExpression() {
        RPN_Calculator calculator = new RPN_Calculator();
        assertThrows(
                InvalidExpressionException.class,
                () -> calculator.calculate(""),
                InvalidExpressionException.EMPTY_EXPRESSION_MESSAGE
        );
    }

    @Test
    void calculateAddition() {
        RPN_Calculator calculator = new RPN_Calculator();
        try {
            assertEquals(calculator.calculate("4 6 +"), 10);
        } catch (InvalidExpressionException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void calculateWithNegativeNumber() {
        RPN_Calculator calculator = new RPN_Calculator();
        try {
            assertEquals(calculator.calculate("4 -6 +"), -2);
        } catch (InvalidExpressionException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void calculateWithTooManyNumbers() {
        RPN_Calculator calculator = new RPN_Calculator();
        assertThrows(
                InvalidExpressionException.class,
                () -> calculator.calculate("4 6 2 +"),
                InvalidExpressionException.TOO_MUCH_NUMBER_MESSAGE + "4 6 2 +"
        );
    }

    @Test
    void calculateWithTooFewNumbers() {
        RPN_Calculator calculator = new RPN_Calculator();
        assertThrows(
                InvalidExpressionException.class,
                () -> calculator.calculate("4 +"),
                InvalidExpressionException.TOO_FEW_NUMBER_MESSAGE + "4 +"
        );
    }

    @Test
    void calculateSubtractionWithPositiveResult() {
        RPN_Calculator calculator = new RPN_Calculator();
        try {
            assertEquals(calculator.calculate("6 4 -"), 2);
        } catch (InvalidExpressionException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void calculateSubtractionWithNegativeResult() {
        RPN_Calculator calculator = new RPN_Calculator();
        try {
            assertEquals(calculator.calculate("4 6 -"), -2);
        } catch (InvalidExpressionException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void calculateMultiplication() {
        RPN_Calculator calculator = new RPN_Calculator();
        try {
            assertEquals(calculator.calculate("6 4 *"), 24);
        } catch (InvalidExpressionException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void calculateWithMissingSpaceBeforeOperator() {
        RPN_Calculator calculator = new RPN_Calculator();
        assertThrows(
                InvalidExpressionException.class,
                () -> calculator.calculate("4 6+"),
                InvalidExpressionException.INVALID_OPERATOR_MESSAGE + "6+"
        );
    }

    @Test
    void calculateExpressionEndingWithNumber() {
        RPN_Calculator calculator = new RPN_Calculator();
        assertThrows(
                InvalidExpressionException.class,
                () -> calculator.calculate("15 7 1 1 + - / 3 * 2 1 1 + + - 5"),
                InvalidExpressionException.EXPRESSION_ENDING_WITH_NUMBER_MESSAGE
        );
    }

    @Test
    void calculateDividingWithWholeNumberResult() {
        RPN_Calculator calculator = new RPN_Calculator();
        try {
            assertEquals(calculator.calculate("6 3 /"), 2);
        } catch (InvalidExpressionException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void calculateDividingWithFractionNumberResult() {
        RPN_Calculator calculator = new RPN_Calculator();
        try {
            assertEquals(calculator.calculate("3 6 /"), 0.5);
        } catch (InvalidExpressionException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void calculateComplexExpressionWithNegativeNumbers() {
        RPN_Calculator calculator = new RPN_Calculator();
        try {
            assertEquals(calculator.calculate("15 7 1 1 + - / 3 * 2 1 -1 + + -"), 7);
        } catch (InvalidExpressionException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void calculateDividingWithZero() {
        RPN_Calculator calculator = new RPN_Calculator();
        assertThrows(
                InvalidExpressionException.class,
                () -> calculator.calculate("6 0 /"),
                InvalidExpressionException.DIVIDING_WITH_ZERO_MESSAGE
        );
    }

    @Test
    void calculateWithInvalidOperator() {
        RPN_Calculator calculator = new RPN_Calculator();
        assertAll(
                () -> assertThrows(
                        InvalidExpressionException.class,
                        () -> calculator.calculate("4 6 @"),
                        InvalidExpressionException.INVALID_OPERATOR_MESSAGE + "6+"
                ),
                () -> assertThrows(
                        InvalidExpressionException.class,
                        () -> calculator.calculate("4 6 A"),
                        InvalidExpressionException.INVALID_OPERATOR_MESSAGE + "6+"
                ),
                () -> assertThrows(
                        InvalidExpressionException.class,
                        () -> calculator.calculate("4 6 k"),
                        InvalidExpressionException.INVALID_OPERATOR_MESSAGE + "6+"
                ),
                () -> assertThrows(
                        InvalidExpressionException.class,
                        () -> calculator.calculate("4 6 ="),
                        InvalidExpressionException.INVALID_OPERATOR_MESSAGE + "6+"
                )
        );
    }

    @Test
    void calculateComplexExpressionWithWholeNumberResults() {
        RPN_Calculator calculator = new RPN_Calculator();
        try {
            assertEquals(calculator.calculate("15 7 1 1 + - / 3 * 2 1 1 + + -"), 5);
        } catch (InvalidExpressionException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void calculateComplexExpressionWithFractionNumberResults() {
        RPN_Calculator calculator = new RPN_Calculator();
        try {
            assertEquals(calculator.calculate("15 7 1 4 + - / 3 * 2 1 1 + + -"), 18.5);
        } catch (InvalidExpressionException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void calculateComplexExpressionWithZeroDivision() {
        RPN_Calculator calculator = new RPN_Calculator();
        assertThrows(
                InvalidExpressionException.class,
                () -> calculator.calculate("15 7 1 6 + - / 3 * 2 1 1 + + -"),
                InvalidExpressionException.DIVIDING_WITH_ZERO_MESSAGE
        );
    }

    @Test
    void calculateComplexExpressionWithTooMuchNumbers() {
        RPN_Calculator calculator = new RPN_Calculator();
        assertThrows(
                InvalidExpressionException.class,
                () -> calculator.calculate("15 7 1 1 + - / 3 * 2 1 1 1 + + -"),
                InvalidExpressionException.TOO_MUCH_NUMBER_MESSAGE
        );
    }

    @Test
    void calculateComplexExpressionWithTooFewNumbers() {
        RPN_Calculator calculator = new RPN_Calculator();
        assertThrows(
                InvalidExpressionException.class,
                () -> calculator.calculate("15 7 1 1 + - / 3 * 2 1 + + -"),
                InvalidExpressionException.TOO_FEW_NUMBER_MESSAGE
        );
    }
}