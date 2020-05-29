package xxl.mathematica;

import xxl.mathematica.function.Function;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 键排序方式
 */
public class KeySortBy {
    /**
     * 通过转换f作用于K得到的S进行排序
     *
     * @param map
     * @param f
     * @param <K>
     * @param <V>
     * @param <S>
     * @return
     */
    public static <K, V, S extends Comparable<? super S>> Map<K, V> keySortBy(Map<K, V> map, Function<K, S> f) {
        ObjectHelper.requireNonNull(map, f);
        Map<K, V> result = new TreeMap<>(new Comparator<K>() {
            @Override
            public int compare(K o1, K o2) {
                return f.apply(o1).compareTo(f.apply(o2));
            }
        });
        result.putAll(map);
        return result;
    }
}
