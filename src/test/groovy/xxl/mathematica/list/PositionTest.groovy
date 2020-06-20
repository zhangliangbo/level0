package xxl.mathematica.list


import java.util.function.Predicate

class PositionTest extends GroovyTestCase {
    void testPosition() {
        def list = ["a", "b", "c", "d"]
        println(Position.position(list, "a"))
        println(Position.position(list, "b"))
        println(Position.position(list, new Predicate<String>() {
            @Override
            boolean test(String t) {
                return t.equals("c")
            }
        }))
    }
}
