package part01.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static part01.deque.Functions.*;

class FunctionsTest {

    @Test
    void test0() {
        String string = "123454321";

        assertTrue(isPalindrome(string));
    }

    @Test
    void test1() {
        String string = "123454324";

        assertFalse(isPalindrome(string));
    }

    @Test
    void test2() {
        String string = "00";

        assertTrue(isPalindrome(string));
    }
}
