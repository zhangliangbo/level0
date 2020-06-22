package xxl.mathematica.map;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 分组
 */
public class GroupBy {
    /**
     * 分组
     *
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, List<V>> groupBy(List<V> list, Function<V, K> f) {
        return io.vavr.collection.List.ofAll(list)
                .groupBy(f)
                .mapValues(io.vavr.collection.List::asJava)
                .toJavaMap();
    }
}
