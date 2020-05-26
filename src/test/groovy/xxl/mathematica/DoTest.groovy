package xxl.mathematica


import org.junit.Test

/**
 * Created by zhang on 2017/9/22.
 */

class DoTest {
    @Test
    void name() throws Exception {
        Do.loop({ i -> println(i) }, 5)
    }

    @Test
    void name1() throws Exception {
        Do.loop({ i -> println(i) }, 1, 10)

    }

    @Test
    void name2() throws Exception {
        Do.loop({ i -> println(i) }, 1, 10, -1)

    }

    @Test
    void name3() throws Exception {
        Do.loop({ i -> println(i) }, 1, 10, 3)

    }

    @Test
    void name4() throws Exception {
        Do.loop({ i -> println(i) }, 10, -3, -3)

    }

    @Test
    void name5() throws Exception {
        Do.loop({ i -> println(i) }, Arrays.asList(1, 4, 5, 9, 4))

    }
}