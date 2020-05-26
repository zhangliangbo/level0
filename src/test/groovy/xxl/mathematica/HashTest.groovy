package xxl.mathematica

class HashTest extends GroovyTestCase {
    void testHashString() {
        println(Hash.encodeHexString(Hash.hashString("The quick brown fox jumps over the lazy dog", Hash.Algorithm.SHA1)))
    }

    void testHashFile() {
        println(Hash.encodeHexString(Hash.hashFile("D:\\IdeaProjects\\rice-server\\file\\goods\\6604545927195660288.jpg", Hash.Algorithm.SHA1)))
    }
}
