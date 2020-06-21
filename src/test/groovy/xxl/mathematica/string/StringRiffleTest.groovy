package xxl.mathematica.string

import org.junit.Test
import xxl.mathematica.function.Function
import xxl.mathematica.random.RandomInteger

class StringRiffleTest extends GroovyTestCase{

    void testStringRiffle() {
        System.out.println(StringRiffle.stringRiffle(Arrays.asList("zlb", "hwj", "dsx"), "|"))
    }
}