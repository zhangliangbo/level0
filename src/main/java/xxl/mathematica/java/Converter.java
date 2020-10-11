package xxl.mathematica.java;

import xxl.mathematica.Rule;
import xxl.mathematica.time.DateString;

import java.sql.Timestamp;
import java.util.Date;
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
    public static <K, V> List<Rule<Object, Object>> map(Map<K, V> map) {
        return io.vavr.collection.HashMap.ofAll(map)
                .toList()
                .map(tuple2 -> {
                    Object key = tuple2._1();
                    Object value = tuple2._2();
                    if (tuple2._2() instanceof Date) {
                        value = DateString.dateString((Date) tuple2._2());
                    } else if (tuple2._2() instanceof Timestamp) {
                        value = DateString.dateString((Timestamp) tuple2._2());
                    }
                    return Rule.valueOf(key, value);
                })
                .asJava();
    }
}
