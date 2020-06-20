package xxl.mathematica.list

import xxl.mathematica.list.Append

/**
 * Created by zhang on 2017/9/3.
 */

class AppendTest extends GroovyTestCase {
    void testAppend() {
        println(Append.append(["a", "b", "c", "d"], "tail"))
    }
}