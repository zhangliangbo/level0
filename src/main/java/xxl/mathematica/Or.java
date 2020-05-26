package xxl.mathematica;

/**
 * 逻辑或
 */

public class Or {
    /**
     * 是逻辑 OR 函数. 它按顺序计算自变量，当这些自变量中任意一个是 True 返回 True. 如果都是 False 返回 False.
     *
     * @param predicates
     * @param <T>        空也返回false
     * @return
     */
    public static <T> boolean or(Boolean... predicates) {
        ObjectHelper.requireNonNull((Object) predicates);
        for (boolean predicate : predicates) {
            if (predicate) {
                return true;
            }
        }
        return false;
    }
}
