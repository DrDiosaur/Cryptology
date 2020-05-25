import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XTEATest {
    private static XTEA xtea;

    @BeforeAll
    static void before(){
        int[] key = {34563, 9835575, 8635552, 957352};
        xtea = new XTEA(key);
    }

    @Test
    void encryptAndDecrypt() {
        String testStr = "Test string";
        byte[] bytes = testStr.getBytes();

        byte[] encryptedData = xtea.encrypt(bytes);

        assertEquals(11, encryptedData.length);
        assertEquals("[B@4facf68f", encryptedData.toString());

        byte[] decryptedData = xtea.decrypt(encryptedData);

        assertEquals(11, decryptedData.length);
        assertEquals("Test string", new String(decryptedData));
    }

    @Test
    void getInt() {
        String test = "test";
        byte[] buffer = test.getBytes();

        int intgr = XTEA.getInt(0, buffer);
        assertEquals(1952805748, intgr);
    }

    @Test
    void putInt() {
        String test = "test";
        byte[] buffer = test.getBytes();

        assertEquals(116, buffer[0]);

        byte[] res = XTEA.putInt(23, 0, buffer);

        assertEquals(0, res[0]);
    }
}