package xxl.mathematica;

/**
 * 逻辑非
 */

public class Not {
    /**
     * 是逻辑非函数. 若 expr 为 True，它返回 False；反之，它返回 True.
     *
     * @param predicate
     * @return
     */
    public static boolean not(Boolean predicate) {
        return !predicate;
    }
}
