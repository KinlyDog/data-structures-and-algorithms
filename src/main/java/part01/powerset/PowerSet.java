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
        return this.count;
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

    public int find(String value) {
        int index = hashFun(value);

        for (int i = 0; i < size; i++, index += step) {
            if (index >= size) {
                index -= size;
            }

            if (slots[index] == null) {
                continue;
            }

            if (slots[index].equals(value)) {
                return index;
            }
        }

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
        this.count--;

        return true;
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet intersectionSet = new PowerSet();

        for (int i = 0; i < this.size; i++) {
            if (this.slots[i] == null) {
                continue;
            }

            if (set2.get(this.slots[i])) {
                intersectionSet.put(this.slots[i]);
            }
        }

        return intersectionSet;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet unionSet = new PowerSet();

        if (this.size() + set2.size() == 0) {
            return unionSet;
        }

        int i = 0;
        while (unionSet.size() < this.size()) {
            if (this.slots[i] != null) {
                unionSet.put(this.slots[i]);
            }

            i++;
        }

        i = 0;
        while (unionSet.size() < this.size() + set2.size()) {
            if (set2.slots[i] != null) {
                unionSet.put(set2.slots[i]);
            }

            i++;
        }

        return unionSet;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet differenceSet = new PowerSet();

        for (int i = 0; i < this.size; i++) {
            if (set2.slots[i] == null) {
                continue;
            }

            if (!this.get(set2.slots[i])) {
                differenceSet.put(set2.slots[i]);
            }
        }

        for (int i = 0; i < this.size; i++) {
            if (this.slots[i] == null) {
                continue;
            }

            if (!set2.get(this.slots[i])) {
                differenceSet.put(this.slots[i]);
            }
        }

        return differenceSet;
    }

    public boolean isSubset(PowerSet set2) {
        for (int i = 0; i < this.size; i++) {
            if (set2.slots[i] == null) {
                continue;
            }

            if (!this.get(set2.slots[i])) {
                return false;
            }
        }

        return true;
    }
}
