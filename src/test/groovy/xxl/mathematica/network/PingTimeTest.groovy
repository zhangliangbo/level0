package xxl.mathematica.network

import xxl.mathematica.list.Last
import xxl.mathematica.string.StringCases

class PingTimeTest extends GroovyTestCase {
    void testPingTime() {
        System.err.println(PingTime.pingTime("www.baidu.com"))
    }

    void testString() {
        String s = "PING www.xxlun.com (47.97.183.24) 56(84) bytes of data.\n" +
                "64 bytes from 47.97.183.24: icmp_seq=1 ttl=64 time=0.203 ms\n" +
                "64 bytes from 47.97.183.24: icmp_seq=2 ttl=64 time=0.206 ms\n" +
                "64 bytes from 47.97.183.24: icmp_seq=3 ttl=64 time=0.201 ms\n" +
                "64 bytes from 47.97.183.24: icmp_seq=4 ttl=64 time=0.210 ms\n" +
                "64 bytes from 47.97.183.24: icmp_seq=5 ttl=64 time=0.213 ms\n" +
                "64 bytes from 47.97.183.24: icmp_seq=6 ttl=64 time=0.184 ms\n" +
                "64 bytes from 47.97.183.24: icmp_seq=7 ttl=64 time=0.207 ms\n" +
                "64 bytes from 47.97.183.24: icmp_seq=8 ttl=64 time=0.202 ms\n" +
                "64 bytes from 47.97.183.24: icmp_seq=9 ttl=64 time=0.198 ms\n" +
                "64 bytes from 47.97.183.24: icmp_seq=10 ttl=64 time=0.218 ms\n" +
                "\n" +
                "--- www.xxlun.com ping statistics ---\n" +
                "10 packets transmitted, 10 received, 0% packet loss, time 8999ms\n" +
                "rtt min/avg/max/mdev = 0.184/0.204/0.218/0.012 ms"
        println(Last.last(StringCases.stringCases(s, "= .*/(.*)/.*/.* ms", 1)))
    }
}
