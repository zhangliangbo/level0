package xxl.mathematica.java;

import xxl.mathematica.Rule;

import java.util.List;
import java.util.Map;

/**
 * 把java类型转成mathematica类型
 *
 * @author zhangliangbo
 * @since 2020/10/5
 **/

public class Converter {
    /**
     * 字典转成列表
     *
     * @param map 字典
     * @return 列表
     */
    public static <K, V> List<Rule<K, V>> map(Map<K, V> map) {
        return io.vavr.collection.HashMap.ofAll(map)
                .toList()
                .map(tuple2 -> Rule.valueOf(tuple2._1(), tuple2._2()))
                .asJava();
    }
}
