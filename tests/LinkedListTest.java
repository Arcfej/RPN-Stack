import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList list;

    @BeforeEach
    void setUp() {
        list = new LinkedList();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isListEmpty() {
        assertTrue(list.isListEmpty(), "The list should be empty.");
    }

    @Test
    void addToList() {
        list.addToList(55);
        list.addToList(8);
        list.addToList(-89.6897);
        assertAll(

        );
    }

    @Test
    void deleteFromStart() {
    }
}