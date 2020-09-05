package xxl

class MainTest extends GroovyTestCase {
    void testMain() {
        Integer one = Integer.valueOf(1);
        Integer two = Integer.valueOf(1);
        System.err.println(one == two);
    }

    void testMain1() {
        Integer one = new Integer(1);
        Integer two = new Integer(1);
        System.err.println(one == two);
    }
}
