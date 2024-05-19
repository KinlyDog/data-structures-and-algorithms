package part01.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {
    Deque<Integer> deque;

    @BeforeEach
    void prepare() {
        deque = new Deque<>();
    }

    @Test
    void sizeTest() {
        assertEquals(0, deque.size());

        for (int i = 0; i < 100; i++) {
            deque.addTail(i);
        }

        assertEquals(100, deque.size());
    }

    @Test
    void addAndRemoveFrontTest() {
        for (int i = 0; i < 5; i++) {
            deque.addFront(i);
        }

        assertEquals(5, deque.size());
        assertEquals(4, deque.removeFront());
        assertEquals(0, deque.removeTail());
    }

    @Test
    void addAndRemoveTailTest() {
        for (int i = 0; i < 7; i++) {
            deque.addTail(i);
        }

        assertEquals(7, deque.size());
        assertEquals(0, deque.removeFront());
        assertEquals(6, deque.removeTail());
    }
}
