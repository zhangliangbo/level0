package xxl.mathematica

import xxl.mathematica.cryptology.Hash

class HashTest extends GroovyTestCase {
    void testHashString() {
        println(Hash.encodeHexString(Hash.hashString("hello world", Hash.Algorithm.MD5)))
    }

    void testHashFile() {
        println(Hash.encodeHexString(Hash.hashFile("D:\\hhh.txt", Hash.Algorithm.MD5)))
    }

    void testHashStream() {
        def stream = new FileInputStream("D:\\hhh.txt")
        println(Hash.encodeHexString(Hash.hashStream(stream, Hash.Algorithm.MD5)))
        stream.close()
    }
}
