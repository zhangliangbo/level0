package xxl.mathematica.random

import xxl.mathematica.list.Range

class RandomSampleTest extends GroovyTestCase {
    void testRandomSample() {
        println(RandomSample.randomSample(Range.range(10), 11))
    }
}
