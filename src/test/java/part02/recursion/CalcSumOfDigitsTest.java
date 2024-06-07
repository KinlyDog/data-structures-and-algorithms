package part02.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static part02.recursion.CalcSumOfDigits.*;

class CalcSumOfDigitsTest {

    @Test
    void test0() {
        assertEquals(6, calcSumOfDigits(123));
    }

    @Test
    void test1() {
        assertEquals(0, calcSumOfDigits(0));
    }

    @Test
    void test2() {
        assertEquals(10, calcSumOfDigits(1111111111));
    }
}
