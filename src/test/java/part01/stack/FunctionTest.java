package part01.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static part01.stack.Function.*;

class FunctionTest {

    @Test
    void nullTest() {
        String string = "";
        assertFalse(isBalanced(string));
    }

    @Test
    void test1() {
        String string = "()";
        assertTrue(isBalanced(string));
    }

    @Test
    void test2() {
        String string = "(()((())()))";
        assertTrue(isBalanced(string));
    }

    @Test
    void test3() {
        String string = "(()()(())";
        assertFalse(isBalanced(string));
    }

    @Test
    void test4() {
        String string = "))))((((";
        assertFalse(isBalanced(string));
    }
}
