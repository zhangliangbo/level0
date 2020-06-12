package xxl.mathematica.cryptology;


import xxl.apache.commons.codec.binary.Base64;

/**
 * 字节数组加密成Base64字节数组
 */
public class BaseEncode {
    public static byte[] baseEncode(byte[] data) {
        return Base64.encodeBase64(data);
    }
}
