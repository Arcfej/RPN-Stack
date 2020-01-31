import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void pushOnce() {
        Stack stack = new Stack();
        stack.push(55);
        assertEquals(stack.toString(), "The list contains:\n55.0, ");
    }

    @Test
    void pushThrice() {
        Stack stack = new Stack();
        stack.push(55);
        stack.push(8);
        stack.push(-89.6897);
        assertEquals(stack.toString(), "The list contains:\n-89.6897, 8.0, 55.0, ");
    }

    @Test
    void checkIfEmpty() {
        Stack stack = new Stack();
        assertAll(
                () -> assertTrue(stack.isEmpty()),
                () -> {
                    stack.push(55);
                    assertFalse(stack.isEmpty());
                }
        );
    }

    @Test
    void popNotEmptyStack() {
        Stack stack = new Stack();
        stack.push(55);
        stack.push(8);
        stack.push(-89.6897);
        assertAll(
                () -> assertEquals(stack.pop(), -89.6897),
                () -> assertEquals(stack.toString(), "The list contains:\n8.0, 55.0, ")
        );
    }

    @Test
    void popEmptyStack() {
        Stack stack = new Stack();
        assertThrows(EmptyStackException.class, stack::pop);
    }
}