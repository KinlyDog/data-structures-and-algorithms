package part01.powerset;

import java.nio.charset.StandardCharsets;

public class PowerSet {
    private int size;
    private int step;
    private int count;
    private String[] slots;

    public PowerSet() {
        this.size = 20_000;
        this.step = 3;
        this.count = 0;
        this.slots = new String[this.size];
    }

    private int hashFun(String value) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);

        int sum = 0;
        for (byte b : bytes) {
            sum += b;
        }

        return sum % this.size;
    }

    private int stepIndex(int index) {
        index += this.step;

        if (index >= this.size) {
            index -= this.size;
        }

        return index;
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

    public int size() {
        // количество элементов в множестве
        return 0;
    }

    public void put(String value) {
        if (get(value)) {
            return;
        }

        int index = seekSlot(value);

        if (index > -1) {
            this.slots[index] = value;
            this.count++;
        }
    }

    private int find(String value) {
        int index = hashFun(value);
        int i = index;

        do {
            if (this.slots[i] == null) {
                return -1;
            }

            if (this.slots[i].equals(value)) {
                return i;
            }

            i = stepIndex(i);
        } while (i != index);

        return -1;
    }

    public boolean get(String value) {
        return find(value) > -1;
    }

    public boolean remove(String value) {
        int index = find(value);

        if (index < 0) {
            return false;
        }

        this.slots[index] = null;

        return true;
    }

    public PowerSet intersection(PowerSet set2) {
        // пересечение текущего множества и set2
        return null;
    }

    public PowerSet union(PowerSet set2) {
        // объединение текущего множества и set2
        return null;
    }

    public PowerSet difference(PowerSet set2) {
        // разница текущего множества и set2
        return null;
    }

    public boolean isSubset(PowerSet set2) {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        return false;
    }
}
