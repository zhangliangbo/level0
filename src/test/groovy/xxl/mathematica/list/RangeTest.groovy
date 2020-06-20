package xxl.mathematica.list


import xxl.mathematica.list.Range

/**
 * Created by zhang on 2017/9/1.
 */

class RangeTest extends GroovyTestCase {

    void testRange() {
        println(Range.range(1, 10, 2))
        println(Range.range('a' as char, 'z' as char))
    }
}