package xxl.mathematica.map

class AssociationTest extends GroovyTestCase {
    class A {
        String name = "abc"
        int age = 19
        String school = "武汉"
    }

    void testAssociation() {
        A a = new A()
        println(Association.association(a, ["name"]))
    }
}
