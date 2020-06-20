package xxl.mathematica.random

class RandomChoiceTest extends GroovyTestCase {
    void testRandomChoice() {
        println(RandomChoice.randomChoice(["A", "B", "C", "D"], 10))
    }
}
