package xxl.mathematica

class AssociationMapTest extends GroovyTestCase {
    void testAssociationMap() {
        def old = AssociationMap.associationMap({ t -> Math.sqrt(t) }, [1, 2, 3, 4])
        println(old)
        def now = AssociationMap.associationMap({ t -> Rule.valueOf(t.getValue(), t.getKey()) }, old)
        println(now)
    }
}
