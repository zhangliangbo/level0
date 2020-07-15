package xxl.mathematica

import xxl.mathematica.cryptology.Hash

class HashTest extends GroovyTestCase {
    void testHashString() {
        println(Hash.encodeHexString(Hash.hashString("hello world", Hash.Algorithm.MD5)))
    }

    void testHashFile() {
        println(Hash.encodeHexString(Hash.hashFile("D:\\hhh.txt", Hash.Algorithm.MD5)))
    }
}
