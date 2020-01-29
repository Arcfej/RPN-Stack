import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void isListEmpty() {
        LinkedList list = new LinkedList();
        assertTrue(list.isListEmpty(), "The list should be empty.");
    }

    @Test
    void addOneToList() {
        LinkedList list = new LinkedList();
        list.addToList(55);
        assertEquals(list.toString(), "The list contains:\n55.0, ", "The list did not contains the 3 added element");
    }

    @Test
    void addMultipleToList() {
        LinkedList list = new LinkedList();
        list.addToList(55);
        list.addToList(8);
        list.addToList(-89.6897);
        assertEquals(list.toString(), "The list contains:\n-89.6897, 8.0, 55.0, ", "The list did not contains the 3 added element");
    }

    @Test
    void deleteFromStart() {
        LinkedList list = new LinkedList();
        list.addToList(55);
        list.addToList(8);
        list.addToList(-89.6897);
        list.deleteFromStart();
        assertEquals(list.toString(), "The list contains:\n8.0, 55.0, ", "The list did not contains the 3 added element");
    }

    @Test
    void deleteFromEmptyStart() {
        LinkedList list = new LinkedList();
        list.deleteFromStart();
    }
}