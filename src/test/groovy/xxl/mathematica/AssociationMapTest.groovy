package xxl.mathematica

import xxl.mathematica.map.AssociationMap

class AssociationMapTest extends GroovyTestCase {
    void testAssociationMap() {
        def map = AssociationMap.associationMap({ t -> Math.sqrt(t) }, [1, 2, 3, 4])
        println(map)
    }

    void testAssociationMap1() {
        def now = AssociationMap.associationMap({ t -> Rule.valueOf(t.getValue(), t.getKey()) }, ["a": 1, "b": 2, "c": 3, "d": 4])
        println(now)
    }
}
