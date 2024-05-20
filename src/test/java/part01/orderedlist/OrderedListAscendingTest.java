package part01.orderedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OrderedListAscendingTest {
    OrderedList<Integer> ascending;

    @BeforeEach
    void prepare() {
        ascending = new OrderedList<>(true);
    }

    @Test
    void addTest() {
        ascending.add(5);
        ascending.add(4);
        ascending.add(2);
        ascending.add(1);
        ascending.add(0);

        assertEquals(0, ascending.head.value);
        assertEquals(5, ascending.tail.value);
    }

    @Test
    void findTest() {
        assertNull(ascending.find(5));

        ascending.add(1);
        ascending.add(2);
        ascending.add(5);
        ascending.add(0);

        assertEquals(ascending.tail, ascending.find(5));
        assertEquals(ascending.head.next, ascending.find(1));
        assertEquals(ascending.tail.prev, ascending.find(2));
    }
}
