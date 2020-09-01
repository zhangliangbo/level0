package xxl.mathematica.parallel

import xxl.mathematica.functional.Map

class ParallelMapTest extends GroovyTestCase {
    void testMap() {
        long s = System.currentTimeMillis()
        println(
                Map.map(t -> {
                    sleep(5000)
                    return t * t
                }, [1, 2, 3, 4, 5, 6, 7, 8])
        )
        println("duration:" + (System.currentTimeMillis() - s))
    }

    void testParallelMap() {
        long s = System.currentTimeMillis()
        println(
                ParallelMap.parallelMap(t -> {
                    sleep(5000)
                    return t * t
                }, [1, 2, 3, 4, 5, 6, 7, 8])
        )
        println("duration:" + (System.currentTimeMillis() - s))
    }
}
