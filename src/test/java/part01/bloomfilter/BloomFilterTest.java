package part01.bloomfilter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {
    BloomFilter bf = new BloomFilter(32);
    String def = "0123456789";

    @Test
    void isValue() {
        String tempDef = def;
        for (int i = 0; i < 10; i++) {
            bf.add(tempDef);
            tempDef = tempDef.substring(1) + tempDef.charAt(0);
        }

        tempDef = def;
        for (int i = 0; i < 10; i++) {
            assertTrue(bf.isValue(tempDef));
            tempDef = tempDef.substring(1) + tempDef.charAt(0);
        }
    }
}
