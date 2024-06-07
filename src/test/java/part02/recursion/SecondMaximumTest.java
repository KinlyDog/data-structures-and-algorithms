package part02.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static part02.recursion.SecondMaximum.*;

class SecondMaximumTest {
    ArrayList<Integer> list;
    Random rand;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        rand = new Random();
    }

    @Test
    void test0() {
        for (int i = 0; i < 100; i++) {
            list.add(rand.nextInt(100));
        }

        ArrayList<Integer> sorted = new ArrayList<>(list);
        sorted.sort(Collections.reverseOrder());

        assertEquals(sorted.get(1), secondMaximum(list));
    }
}
