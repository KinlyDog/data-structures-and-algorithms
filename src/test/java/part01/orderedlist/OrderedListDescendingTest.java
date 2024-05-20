package part01.orderedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OrderedListDescendingTest {
    OrderedList<Integer> descending;

    @BeforeEach
    void prepare() {
        descending = new OrderedList<>(false);
    }

    @Test
    void addTest() {
        descending.add(1);
        descending.add(2);
        descending.add(7);
        descending.add(4);
        descending.add(5);

        assertEquals(7, descending.head.value);
        assertEquals(1, descending.tail.value);
    }

    @Test
    void findTest() {
        assertNull(descending.find(5));

        descending.add(1);
        descending.add(2);
        descending.add(5);
        descending.add(0);

        assertEquals(descending.tail, descending.find(0));
        assertEquals(descending.head.next, descending.find(2));
        assertEquals(descending.tail.prev, descending.find(1));
    }
}
