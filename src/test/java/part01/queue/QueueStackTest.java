package part01.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueStackTest {
    QueueStack<Integer> queueStack;

    @BeforeEach
    void prepare() {
        queueStack = new QueueStack<>();
    }


    @Test
    void enqueueTest() {
        for (int i = 0; i < 10; i++) {
            queueStack.enqueue(i);
        }

        assertEquals(10, queueStack.size());
    }

    @Test
    void dequeueInEmptyQueueTest() {
        assertNull(queueStack.dequeue());
    }

    @Test
    void dequeueTest() {
        for (int i = 0; i < 10; i++) {
            queueStack.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(i, queueStack.dequeue());
        }
    }

    @Test
    void sizeTest() {
        assertEquals(0, queueStack.size());

        for (int i = 0; i < 5; i++) {
            queueStack.enqueue(i);
        }
        assertEquals(5, queueStack.size());
    }
}