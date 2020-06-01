package xxl.mathematica.random;

import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/**
 * 随机选择
 */
public class RandomChoice {

    /**
     * 随机选择n个
     *
     * @param list
     * @param n
     * @param <T>
     * @return
     */
    public static <T> List<T> randomChoice(List<T> list, int n) {
        return io.vavr.collection.List.range(0, n)
                .map(integer -> list.get(RandomUtils.nextInt(0, list.size())))
                .asJava();
    }

    /**
     * 随机选择一个
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T randomChoice(List<T> list) {
        return io.vavr.collection.List.ofAll(list)
                .get(RandomUtils.nextInt(0, list.size()));
    }

}
