package part01.orderedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest<T> {
    OrderedList ascending;

    @BeforeEach
    void prepare() {
        ascending = new OrderedList(true);
    }

    @Test
    void compareIntegersTest() {
        assertEquals(0, ascending.compare(5, 5));
        assertEquals(1, ascending.compare(4, 2));
        assertEquals(-1, ascending.compare(0, 12));
    }

    @Test
    void compareStringsTest() {
        assertEquals(0, ascending.compare("a", "a"));
        assertEquals(1, ascending.compare("z", "b"));
        assertEquals(-1, ascending.compare("a", "c"));
    }

    @Test
    void deleteTest() {
        assertFalse(ascending.delete(5));

        ascending.add(1);
        ascending.add(3);
        ascending.add(5);
        ascending.add(6);

        assertEquals(3, ascending.find(3).value);
        assertTrue(ascending.delete(3));
        assertNull(ascending.find(3));

        assertTrue(ascending.delete(1));
        assertEquals(2, ascending.count());
    }

    @Test
    void countTest() {
        assertEquals(0, ascending.count());

        ascending.add(1);
        ascending.add(2);
        assertEquals(2, ascending.count());

        ascending.add(3);
        ascending.add(4);
        ascending.add(5);
        assertEquals(5, ascending.count());

        ascending.delete(1);
        assertEquals(4, ascending.count());
    }


    @Test
    void clearTest() {
        assertEquals(0, ascending.count());

        ascending.add(1);
        ascending.add(2);
        ascending.add(3);
        ascending.add(4);
        assertEquals(4, ascending.count());

        ascending.clear(true);
        assertEquals(0, ascending.count());
        assertNull(ascending.head);
    }

    @Test
    void getAllTest() {
        ascending.add(5);
        ascending.add(4);
        ascending.add(3);
        ascending.add(2);

        ArrayList<Node<T>> list = ascending.getAll();

        assertEquals(2, list.getFirst().value);
        assertEquals(5, list.getLast().value);
        assertNotEquals(11, list.get(3).value);
    }

}

