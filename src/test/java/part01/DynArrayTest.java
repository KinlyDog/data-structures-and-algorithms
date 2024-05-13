package part01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DynArrayTest {
    DynArray<Integer> array;

    @BeforeEach
    void prepare() {
        array = new DynArray<>(Integer.class);

        for (int i = 0; i < 10; i++) {
            array.append(i);
        }
    }

    @Test
    void makeArrayCapacityTest() {
        array.makeArray(899);
        assertEquals(899, array.capacity);

        array.makeArray(-1);
        assertEquals(16, array.capacity);
    }

    @Test
    void appendTest() {
        assertEquals(10, array.count);

        array.append(999);
        assertEquals(999, array.getItem(10));
    }

    @Test
    void getItemTest() {
        assertEquals(0, array.getItem(0));
        assertEquals(4, array.getItem(4));
    }

    @Test
    void insertTest() {
        assertNotEquals(777, array.getItem(0));

        array.insert(777, 0);
        assertEquals(777, array.getItem(0));

        for (int i = 1; i < 11; i++) {
            assertEquals(i - 1, array.getItem(i));
        }
    }

    @Test
    void insertOverBufferTest() {
        for (int i = 10; i < 20; i++) {
            array.insert(i, i);
        }

    }

    @Test
    void removeTest() throws Exception {
        assertEquals(10, array.count);

        array.remove(1);

        assertEquals(2, array.getItem(1));
        assertEquals(9, array.count);
    }

    @Test
    void exceptionTest() {
        Exception ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(-1));
        assertEquals("Sorry, incorrect index", ex.getMessage());

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.insert(5, 100));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.getItem(999));
    }
}
