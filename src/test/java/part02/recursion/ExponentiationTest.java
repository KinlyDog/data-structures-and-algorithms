package part02.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static part02.recursion.Exponentiation.*;

class ExponentiationTest {

    @Test
    void test0() {
        assertEquals(4, exponentiation(2, 2));
    }

    @Test
    void test1() {
        assertEquals(1000, exponentiation(10, 3));
    }

    @Test
    void test2() {
        assertEquals(81, exponentiation(3, 4));
    }

    @Test
    void test3() {
        assertEquals(1, exponentiation(1024, 0));
    }
}
