package part01.nativechache;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;

public class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;

    public NativeCache(int size, Class clazz) {
        this.size = size;
        this.slots = new String[size];
        this.values = (T[]) Array.newInstance(clazz, this.size);
        this.hits = new int[size];
    }

    private int hashFun(String key) {
        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);

        int sum = 0;
        for (byte b : bytes) {
            sum += b;
        }

        return sum % this.size;
    }

    public boolean isKey(String key) {
        return find(key) > -1;
    }

    private int find(String value) {
        int index = hashFun(value);

        for (int i = 0; i < this.size; i++, index += 3) {
            if (index >= this.size) {
                index -= this.size;
            }

            if (this.slots[index] == null) {
                continue;
            }

            if (this.slots[index].equals(value)) {
                return index;
            }
        }

        return -1;
    }

    public void put(String key, T value) {
        int index = seekSlot(key);

        if (index == -1) {
            index = removeRare();
            hits[index] = 0;
        }

        this.slots[index] = key;
        this.values[index] = value;
    }

    private int removeRare() {
        int min = this.hits[0];
        int minIndex = 0;

        for (int i = 1; i < hits.length; i++) {
            if (this.hits[i] < min) {
                min = this.hits[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public T get(String key) {
        int index = find(key);

        if (index > -1) {
            this.hits[index]++;
            return this.values[index];
        }

        return null;
    }

    private int seekSlot(String value) {
        int index = hashFun(value);
        int i = index;

        do {
            if (this.slots[i] == null) {
                return i;
            }

            i = stepIndex(i);
        } while (i != index);

        return -1;
    }

    private int stepIndex(int index) {
        index += 3;

        if (index >= this.size) {
            index -= this.size;
        }

        return index;
    }
}
