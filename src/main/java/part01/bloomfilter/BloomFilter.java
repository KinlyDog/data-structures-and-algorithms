package part01.bloomfilter;

public class BloomFilter {
    private int filterLen;
    private int filter;

    public BloomFilter(int filterLen) {
        this.filterLen = filterLen;
        this.filter = 0;
    }

    public int hash(String string, int rand) {
        int hash = 0;

        for (int i = 0; i < string.length(); i++) {
            hash = (hash * rand + string.charAt(i)) % filterLen;
        }

        return hash;
    }

    public int hash1(String string) {
        return 1 << hash(string, 17);
    }

    public int hash2(String string) {
        return 1 << hash(string, 223);
    }

    public void add(String string) {
        filter |= (hash1(string) | hash2(string));
    }

    public boolean isValue(String string) {
        return (filter & hash1(string)) != 0 && (filter & hash2(string)) != 0;
    }
}
