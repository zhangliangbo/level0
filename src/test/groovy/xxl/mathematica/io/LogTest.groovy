package xxl.mathematica.io

class LogTest extends GroovyTestCase {
    void testLog() {
        Log.log(LogTest.class, "abc")
        Log.log("abc")
    }
}
