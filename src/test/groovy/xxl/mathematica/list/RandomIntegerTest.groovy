package xxl.mathematica.list

import groovy.test.GroovyTestCase
import xxl.mathematica.random.RandomInteger

/**
 * Created by zhang on 2017/9/10.
 */

class RandomIntegerTest extends GroovyTestCase{

    void testRandomInteger() throws Exception {
        println(RandomInteger.randomInteger(0, 10, 10))
    }
}