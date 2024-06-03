package part01.bloomfilter;

import java.util.BitSet;

public class BloomFilter {
    private int filterLen;
    private BitSet bitSet;

    public BloomFilter(int filterLen) {
        this.filterLen = filterLen;
        this.bitSet = new BitSet(filterLen);
    }

    private int hash(String string, int seed) {
        int hash = 0;

        for (int i = 0; i < string.length(); i++) {
            hash = (hash * seed + string.charAt(i)) % filterLen;
        }

        return hash;
    }

    public int hash1(String string) {
        return hash(string, 17);
    }

    public int hash2(String string) {
        return hash(string, 223);
    }

    public void add(String string) {
        bitSet.set(hash1(string));
        bitSet.set(hash2(string));
    }

    public boolean isValue(String string) {
        return bitSet.get(hash1(string)) && bitSet.get(hash2(string));
    }
}
