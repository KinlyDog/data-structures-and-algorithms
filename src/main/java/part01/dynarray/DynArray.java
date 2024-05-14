package part01.dynarray;

import java.lang.reflect.*;
import java.util.Arrays;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    public void makeArray(int newCapacity) {
        if (newCapacity < 16) {
            newCapacity = 16;
        }

        this.capacity = newCapacity;

        if (count == 0) {
            array = (T[]) Array.newInstance(this.clazz, newCapacity);
            return;
        }

        array = Arrays.copyOf(array, newCapacity);
    }

    public T getItem(int index) {
        exception(index);
        return array[index];
    }

    public void append(T itm) {
        checkCapacity();

        array[count++] = itm;
    }

    public void insert(T itm, int index) {
        if (index != count) {
            exception(index);
        }

        checkCapacity();

        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = itm;
        count++;
    }

    private void checkCapacity() {
        if (count >= capacity) {
            makeArray(capacity * 2);
        }
    }

    public void remove(int index) throws Exception {
        exception(index);

        for (int i = index; i < count; i++) {
            array[i] = array[i + 1];
        }

        array[--count] = null;

        if (capacity > 16 && count < capacity / 2) {
            makeArray((int) (capacity / 1.5));
        }
    }

    private void exception(int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException("Sorry, incorrect index");
        }
    }
}
