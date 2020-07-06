package xxl.mathematica.cryptology

class HashTest extends GroovyTestCase {
    void testHashFile() {
        println(Hash.encodeHexString(Hash.hashFile("D:\\.gradle\\caches\\modules-2\\files-2.1\\io.netty\\netty-all\\4.1.50.Final\\c7baf02e4f92595a04a9dcfbf2d49749bba44db5\\netty-all-4.1.50.Final.pom", Hash.Algorithm.SHA1)))
    }
}
