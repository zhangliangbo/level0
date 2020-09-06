package xxl.mathematica.cache

class CacheTest extends GroovyTestCase {
    void testGet() {
        println(Cache.get("lrd"))
    }

    void testPut() {
        Cache.put("zlb", "2")
    }

    void testTestPut() {
        Cache.put("lrd", "100", 10)
    }

    void testPutNX() {
        Cache.putNX("zlb", "1")
    }

    void testClear() {
        Cache.clear()
    }

    void testRemove() {
        Cache.remove("zlb")
    }
}
