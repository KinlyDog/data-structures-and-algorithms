package part01.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static part01.stack.Functions.*;

class FunctionsTest {

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

class PostfixCalcTest {

    @Test
    void test0() {
        String string = "1 2 + 3 *";

        assertEquals(9, postfixCalc(string));
    }

    @Test
    void test1() {
        String string = "8 2 + 5 * 9 + =";

        assertEquals(59, postfixCalc(string));
    }

    @Test
    void test2() {
        String string = "9 9 * 9 + 2 * =";

        assertEquals(180, postfixCalc(string));
    }
}
