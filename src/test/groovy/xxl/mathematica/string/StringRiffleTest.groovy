package xxl.mathematica.string

import org.junit.Test
import xxl.mathematica.RandomInteger
import xxl.mathematica.function.Function

class StringRiffleTest {

    @Test
    void all() {
        System.out.println(
                StringRiffle.stringRiffle(
                        RandomInteger.randomInteger(0, 10, 1000),
                        new Function<Integer, String>() {
                            @Override
                            String apply(Integer integer) {
                                return "xxl" + integer
                            }
                        },
                        "(",
                        ": ",
                        ")"))
    }

    @Test
    void nullable() {
        System.out.println(StringRiffle.stringRiffle(null, "|"))
    }

    @Test
    void defaultSplitter() {
        System.out.println(StringRiffle.stringRiffle(Arrays.asList("zlb", "hwj", "dsx")))
    }

    @Test
    void splitter() {
        System.out.println(StringRiffle.stringRiffle(Arrays.asList("zlb", "hwj", "dsx"), "|"))
    }
}