package part02.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static part02.recursion.IsPalindrome.*;

class IsPalindromeTest {

    @Test
    void test0() {
        assertTrue(isPalindrome("111"));
    }

    @Test
    void test1() {
        assertTrue(isPalindrome(""));
    }

    @Test
    void test2() {
        assertTrue(isPalindrome("tenet"));
    }

    @Test
    void test3() {
        assertFalse(isPalindrome("1113"));
    }
}
