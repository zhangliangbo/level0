package xxl.mathematica.functional;

import java.util.List;
import java.util.function.BiFunction;

/**
 * 折叠
 */

public class Fold {
    /**
     * 给出 {x,f[x,a],f[f[x,a],b]}.
     *
     * @param function
     * @param initValue
     * @param list      列表
     * @param <T>
     * @return
     */
    public static <T> T fold(BiFunction<T, T, T> function, T initValue, List<T> list) {
        return io.vavr.collection.List.ofAll(list)
                .fold(initValue, function);
    }

    /**
     * 给出 {x,f[x,a],f[f[x,a],b]}.
     *
     * @param function
     * @param list     列表
     * @param <T>
     * @return
     */
    public static <T> T fold(BiFunction<T, T, T> function, List<T> list) {
        return io.vavr.collection.List.ofAll(list)
                .subSequence(1)
                .fold(list.get(0), function);
    }
}
