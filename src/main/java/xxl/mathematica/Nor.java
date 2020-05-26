package xxl.mathematica;

/**
 * 逻辑或非
 */

public class Nor {
    /**
     * 是逻辑或非函数. 按顺序计算自变量，当任一自变量为 True 时，给出 False，当所有自变量值为  False，给出 True.
     *
     * @param predicates
     * @return
     */
    public static boolean nor(Boolean... predicates) {
        ObjectHelper.requireNonNull((Object) predicates);
        for (boolean predicate : predicates) {
            if (predicate) {
                return false;
            }
        }
        return true;
    }
}
