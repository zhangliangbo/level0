package xxl.mathematica.cryptology

class BaseDecodeTest extends GroovyTestCase {
    void testBaseDecode() {
        def bytes = BaseDecode.baseDecode("aGVsbG8gd29ybGQ=".getBytes())
        println(new String(bytes))
    }
}
