package part01.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack<Integer> stack;

    @BeforeEach
    void prepare() {
        stack = new Stack<>();
    }

    @Test
    void pushTest() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        assertEquals(5, stack.size());
        assertEquals(4, stack.peek());
    }

    @Test
    void popTest() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        assertEquals(5, stack.size());

        for (int i = 4; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }

        assertEquals(0, stack.size());
    }

    @Test
    void popInEmptyStackTest() {
        assertNull(stack.pop());
    }

    @Test
    void sizeTest() {
        assertEquals(0, stack.size());

        stack.push(0);
        assertEquals(1, stack.size());

        stack.pop();

        assertEquals(0, stack.size());
    }

    @Test
    void peekTest() {
        assertNull(stack.peek());
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.peek());
        assertEquals(3, stack.size());
    }
}
