package xxl.mathematica.cryptology;


import xxl.apache.commons.codec.Charsets;
import xxl.apache.commons.codec.binary.Hex;
import xxl.apache.commons.codec.digest.DigestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * 散列表
 */
public class Hash {
    /**
     * hash数据流
     *
     * @param is
     * @param algorithm
     * @return
     */
    public static byte[] hashStream(InputStream is, Algorithm algorithm) throws IOException {
        return DigestUtils.digest(DigestUtils.getDigest(algorithm.getName()), is);
    }

    /**
     * hash文件
     *
     * @param file
     * @param algorithm
     * @return
     * @throws IOException
     */
    public static byte[] hashFile(String file, Algorithm algorithm) throws IOException {
        return hashStream(new FileInputStream(file), algorithm);
    }

    /**
     * hash字符串
     *
     * @param data
     * @param algorithm
     * @return
     */
    public static byte[] hashString(String data, Algorithm algorithm) {
        return DigestUtils.digest(DigestUtils.getDigest(algorithm.getName()), data.getBytes(Charsets.UTF_8));
    }

    /**
     * hash字节数组
     *
     * @param data
     * @param algorithm
     * @return
     */
    public static byte[] hashByteArray(byte[] data, Algorithm algorithm) {
        return DigestUtils.digest(DigestUtils.getDigest(algorithm.getName()), data);
    }

    /**
     * hash字节缓冲
     *
     * @param data
     * @param algorithm
     * @return
     */
    public static byte[] hashByteBuffer(ByteBuffer data, Algorithm algorithm) {
        return DigestUtils.digest(DigestUtils.getDigest(algorithm.getName()), data);
    }

    /**
     * 字节数组转成字符串
     *
     * @param data
     * @return
     */
    public static String encodeHexString(byte[] data) {
        return Hex.encodeHexString(data);
    }

    /**
     * 字节数组转成字符数组
     *
     * @param data
     * @return
     */
    public static char[] encodeHex(byte[] data) {
        return Hex.encodeHex(data);
    }

    /**
     * 算法名称
     */
    public enum Algorithm {

        MD2("MD2"), MD5("MD5"), SHA1("SHA-1"), SHA224("SHA-224"), SHA256("SHA-256"), SHA384("SHA-384"), SHA512("SHA-512"), SHA3224("SHA3-224"), SHA3256("SHA3-256"), SHA3384("SHA3-384"), SHA3512("SHA3-512");

        private String name;

        Algorithm(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
