package xxl.mathematica.cryptology;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64字节数组解密成字节数组
 */
public class BaseDecode {
    public static byte[] baseDecode(byte[] data) {
        return Base64.decodeBase64(data);
    }
}
