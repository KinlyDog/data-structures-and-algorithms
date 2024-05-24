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

    private int find(String value) {
        if (value == null) {
            return -1;
        }

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
        this.count--;

        return true;
    }

    // complete
    public PowerSet intersection(PowerSet set2) {
        PowerSet powerSet = new PowerSet();

        for (int i = 0; i < this.size; i++) {
            if (this.slots[i] == null) {
                continue;
            }

            if (set2.get(this.slots[i])) {
                powerSet.put(this.slots[i]);
                i++;
            }
        }

        return null;
    }

    // complete
    public PowerSet union(PowerSet set2) {
        PowerSet powerSet = new PowerSet();

        if (this.size() + set2.size() == 0) {
            return powerSet;
        }

        int i = 0;
        while (powerSet.size() < this.size()) {
            if (this.slots[i] != null) {
                powerSet.put(this.slots[i]);
                i++;
            }
        }

        i = 0;
        while (powerSet.size() < this.size() + set2.size()) {
            if (set2.slots[i] != null) {
                powerSet.put(set2.slots[i]);
                i++;
            }
        }

        return powerSet;
    }

    // ??
    public PowerSet difference(PowerSet set2) {
        PowerSet powerSet = new PowerSet();

        for (int i = 0; i < this.size; i++) {
            if (set2.slots[i] == null) {
                continue;
            }

            if (!this.get(set2.slots[i])) {
                powerSet.put(this.slots[i]);
            }
        }

        for (int i = 0; i < this.size; i++) {
            if (this.slots[i] == null) {
                continue;
            }

            if (!set2.get(this.slots[i])) {
                powerSet.put(this.slots[i]);
            }
        }

        return null;
    }

    // complete
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
