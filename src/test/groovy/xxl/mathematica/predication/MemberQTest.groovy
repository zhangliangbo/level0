package xxl.mathematica.predication
/**
 * Created by zhang on 2017/9/10.
 */

class MemberQTest extends GroovyTestCase {
    void testMemberQ() {
        println(MemberQ.memberQ([1, 2, 3, 4, 5], 5))
        println(MemberQ.memberQ([1, 2, 3, 4, 5], 6))
    }
}