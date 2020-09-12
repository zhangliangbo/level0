package xxl.mathematica.cache

class CacheTest extends GroovyTestCase {
    void testGet() {
        println(Cache.get("lrd"))
    }

    void testMatch() {
        println(Cache.match(".*"))
    }

    void testPut() {
        Cache.put("zlb", "2")
    }

    void testTestPut() {
        Cache.put("lrd", "100", 10)
        println(Cache.get("lrd"))
        Thread.sleep(10000)
        println(Cache.get("lrd"))
        Thread.sleep(10000)
        println(Cache.get("lrd"))
    }

    void testIdleTime() {
        println(Cache.idleTime("zlb"))
    }

    void testMaxLife() {
        println(Cache.maxLife("zlb"))
    }

    void testPutNX() {
        Cache.putNx("zlb", "1")
    }

    void testClear() {
        Cache.clear()
    }

    void testRemove() {
        Cache.remove("zlb")
    }

    void testSize() {
        println(Cache.size())
    }

    void testCapacity() {
        println(Cache.capacity())
    }
}
