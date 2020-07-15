package xxl.mathematica.cryptology

class BaseEncodeTest extends GroovyTestCase {
    void testBaseEncode() {
        def bytes = BaseEncode.baseEncode("hello world".getBytes())
        println(Arrays.toString(bytes))
        println(new String(bytes))
    }
}
