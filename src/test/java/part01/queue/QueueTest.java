package part01.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue<Integer> queue;

    @BeforeEach
    void prepare() {
        queue = new Queue<>();
    }


    @Test
    void enqueueTest() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        assertEquals(10, queue.size());
    }

    @Test
    void dequeueInEmptyQueueTest() {
        assertNull(queue.dequeue());
    }

    @Test
    void dequeueTest() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(i, queue.dequeue());
        }
    }

    @Test
    void sizeTest() {
        assertEquals(0, queue.size());

        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        assertEquals(5, queue.size());
    }
}
