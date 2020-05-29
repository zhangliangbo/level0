package xxl.mathematica;

import xxl.mathematica.list.Sort;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 键排序
 */
public class KeySort {
    /**
     * 使用排序函数对映射进行排序
     *
     * @param map
     * @param comparator
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> keySort(Map<K, V> map, Comparator<K> comparator) {
        ObjectHelper.requireNonNull(map, comparator);
        Map<K, V> result = new TreeMap<>(comparator);
        result.putAll(map);
        return result;
    }

    /**
     * 默认自然排序函数
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> keySort(Map<K, V> map) {
        return keySort(map, Sort.naturalOrder());
    }
}
