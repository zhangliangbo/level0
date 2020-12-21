package xxl.mathematica.parallel;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 并行映射(forkjoin)
 *
 * @author zhangliangbo
 * @since 2020/8/31
 */
public class ParallelMap {
    /**
     * 默认是io密集型
     *
     * @param f    函数
     * @param list 列表
     * @param <T>  输入
     * @param <R>  输出
     * @return 列表
     */
    public static <T, R> List<R> parallelMap(Function<T, R> f, List<T> list) {
        return parallelMap(f, list, false);
    }

    /**
     * 是否是cpu密集型
     *
     * @param f            函数
     * @param list         列表
     * @param cpuDenseness 是否cpu密集型
     * @param <T>          输入
     * @param <R>          输出
     * @return 结果列表
     */
    public static <T, R> List<R> parallelMap(Function<T, R> f, List<T> list, boolean cpuDenseness) {
        int available = Runtime.getRuntime().availableProcessors();
        int parallel;
        if (list.size() < available) {
            parallel = list.size();
        } else {
            if (cpuDenseness) {
                parallel = available;
            } else {
                parallel = 2 * available;
            }
        }
        return parallelMap(f, list, parallel);
    }

    /**
     * 并行映射
     *
     * @param f        函数
     * @param list     列表
     * @param parallel 并行数，根据io密集还是cpu密集选择合适的大小
     * @param <T>      输入
     * @param <R>      输出
     * @return
     */
    public static <T, R> List<R> parallelMap(Function<T, R> f, List<T> list, int parallel) {
        //根据并行数把原列表分成大小大致相同的列表
        int size = list.size();
        int numOfOne = size / parallel;
        //多出的个数
        int more = size - numOfOne * parallel;
        List<List<T>> partitions;
        if (more == 0) {
            partitions = Lists.partition(list, numOfOne);
        } else {
            int split = (numOfOne + 1) * more;
            List<List<T>> group1 = Lists.partition(list.subList(0, split), numOfOne + 1);
            List<List<T>> group2 = Lists.partition(list.subList(split, size), numOfOne);
            partitions = ListUtils.union(group1, group2);
        }
        partitions = partitions.stream().map((Function<List<T>, List<T>>) ArrayList::new)
                .collect(Collectors.toList());
        //开始线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool(parallel);
        //每个并行数处理一个子列表
        List<List<R>> partitionResults = forkJoinPool.invoke(
                new Task<>(ts -> ts.stream().map(f).collect(Collectors.toList()), partitions)
        );
        //每个子列表汇总
        List<R> res = partitionResults.stream()
                .flatMap((Function<List<R>, Stream<R>>) Collection::stream).collect(Collectors.toList());
        //关闭线程池
        forkJoinPool.shutdown();
        return res;
    }

    /**
     * 递归任务
     *
     * @param <T>
     */
    private static class Task<T, R> extends RecursiveTask<List<R>> {
        private final Function<T, R> f;
        private final List<T> list;

        public Task(Function<T, R> f, List<T> list) {
            this.f = f;
            this.list = list;
        }

        @Override
        protected List<R> compute() {
            if (list == null || list.size() == 0) {
                return null;
            }
            if (list.size() == 1) {
                List<R> res = new ArrayList<>();
                res.add(f.apply(list.get(0)));
                return res;
            }
            Task<T, R> task1 = new Task<>(f, new ArrayList<>(list.subList(0, 1)));//第一个
            Task<T, R> task2 = new Task<>(f, new ArrayList<>(list.subList(1, list.size())));//剩余的
            task2.fork();
            List<R> first = task1.invoke();
            first.addAll(task2.join());
            return first;
        }
    }
}
