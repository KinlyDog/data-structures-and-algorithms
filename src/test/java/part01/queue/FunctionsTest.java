package part01.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static part01.queue.Functions.*;

class FunctionsTest {
    Queue<Integer> queue;

    @BeforeEach
    void prepare() {
        queue = new Queue<>();
    }

    @Test
    void test0() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        int n = 3;
        rotateQueue(queue, n);

        assertEquals(n, queue.dequeue());
    }

    @Test
    void test1() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }

        int n = 4;
        rotateQueue(queue, n);

        assertEquals(4, queue.dequeue());
    }

    @Test
    void rotateFullRound() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        int n = 10;
        rotateQueue(queue, n);

        assertEquals(0, queue.dequeue());
    }
}