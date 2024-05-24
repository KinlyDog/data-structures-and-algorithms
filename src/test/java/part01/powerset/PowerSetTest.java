package part01.powerset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {
    PowerSet powerSet;

    @BeforeEach
    void prepare() {
        powerSet = new PowerSet();
    }

    @Test
    void putTest() {
        assertFalse(powerSet.get("1"));
        powerSet.put("1");
        powerSet.put("2");
        powerSet.put("3");
        powerSet.put("3");
        powerSet.put("3");


        assertEquals(3, powerSet.size());
        assertTrue(powerSet.get("1"));
        assertFalse(powerSet.get("0"));
    }

    @Test
    void sizeTest() {
        assertEquals(0, powerSet.size());

        for (int i = 0; i < 1000; i++) {
            String string = String.valueOf(i);
            powerSet.put(string);
        }

        assertEquals(1000, powerSet.size());
    }

    @Test
    void getTest() {
        assertFalse(powerSet.get("0"));

        for (int i = 0; i < 100; i++) {
            String string = String.valueOf(i);
            powerSet.put(string);
        }

        for (int i = 0; i < 100; i++) {
            String string = String.valueOf(i);

            assertTrue(powerSet.get(string));
        }

        assertFalse(powerSet.get("100"));
        assertEquals(100, powerSet.size());
    }

    @Test
    void removeTest() {
        assertFalse(powerSet.remove("5"));

        for (int i = 0; i < 30; i++) {
            String string = String.valueOf(i);
            powerSet.put(string);
        }

        assertEquals(30, powerSet.size());

        for (int i = 15; i < 30; i++) {
            String string = String.valueOf(i);
            assertTrue(powerSet.remove(string));
        }

        assertEquals(15, powerSet.size());
        assertFalse(powerSet.remove("29"));
        assertTrue(powerSet.remove("0"));
        assertEquals(14, powerSet.size());
    }
}