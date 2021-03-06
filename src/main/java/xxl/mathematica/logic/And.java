package xxl.mathematica.logic;

import java.util.Arrays;

/**
 * 逻辑与
 */

public class And {

    /**
     * 它按照顺序对其参数进行计算，当它们中任意一个是 False 时立即返回 False，如果它们都是 True 则返回 True.
     *
     * @param ps
     * @return And()=true, and nothing==true;
     */
    public static Boolean and(Boolean... ps) {
        return AllTrue.allTrue(Arrays.asList(ps), aBoolean -> aBoolean);
    }
}
