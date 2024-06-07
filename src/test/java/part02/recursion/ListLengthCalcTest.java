package part02.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static part02.recursion.ListLengthCalc.*;

class ListLengthCalcTest {
    ArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void test0() {
        int length = 20;
        for (int i = 0; i < length; i++) {
            list.add(i);
        }

        assertEquals(length, listLengthCalc(list));
    }

    @Test
    void test1() {
        assertEquals(0, listLengthCalc(list));
    }

    @Test
    void test2() {
        int length = 123;
        for (int i = 0; i < length; i++) {
            list.add(i);
        }

        assertEquals(length, listLengthCalc(list));
    }
}