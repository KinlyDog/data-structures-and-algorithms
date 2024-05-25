package part01.powerset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

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
    void removeOneTest() {
        assertEquals(0, powerSet.size());

        powerSet.put("1");
        powerSet.put("2");
        assertEquals(2, powerSet.size());

        assertTrue(powerSet.remove("1"));
        assertTrue(powerSet.remove("2"));
        assertEquals(0, powerSet.size());
    }

    @RepeatedTest(100)
    void removeTest() {
        assertEquals(0, powerSet.size());
        int storageSize = 10_000;
        Random rand = new Random();

        String[] strings = new String[storageSize];
        for (int i = 0; i < storageSize; i++) {
            StringBuilder builder = new StringBuilder();

            int stringLength = rand.nextInt(500) + 10;

            for (int j = 0; j < stringLength; j++) {
                int charCode = rand.nextInt(100) + 1;
                builder.append((char) charCode);
            }

            powerSet.put(builder.toString());
            strings[i] = builder.toString();
        }

        assertEquals(storageSize, powerSet.size());

        for (int i = 0; i < storageSize; i++) {
            assertTrue(powerSet.remove(strings[i]));
        }

        assertEquals(0, powerSet.size());
    }

    @Test
    void differenceTest() {

    }
}
