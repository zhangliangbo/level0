package xxl.mathematica.network

class TelnetTest extends GroovyTestCase {
    void testTelnet() {
        println(Telnet.telnet("www.baidu.com", 80))
        println(Telnet.telnet("www.baidu.com", 8000))
    }
}
