package xxl.mathematica.parallel;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Function;

/**
 * 并行映射(forkjoin)
 *
 * @author zhangliangbo
 * @since 2020/8/31
 */
@Slf4j
public class ParallelMap {
    /**
     * 使用默认线程数
     *
     * @param f    函数
     * @param list 列表
     * @param <T>  输入
     * @param <R>  输出
     * @return 输出列表
     */
    public static <T, R> List<R> parallelMap(Function<T, R> f, List<T> list) {
        return parallelMap(f, list, Runtime.getRuntime().availableProcessors());
    }

    /**
     * 并行映射
     *
     * @param f           函数
     * @param list        列表
     * @param parallelism 并行数量
     * @param <T>         输入
     * @param <R>         输出
     * @return 输出列表
     */
    public static <T, R> List<R> parallelMap(Function<T, R> f, List<T> list, int parallelism) {
        int available = Runtime.getRuntime().availableProcessors();
        int size = list.size();
        if (parallelism < available) {
            parallelism = available;
        } else if (parallelism > 256 * available) {
            parallelism = 256 * available;
        }
        int times = size % parallelism == 0 ? size / parallelism : size / parallelism + 1;
        log.info("核心数 {} 并行数 {} 大小 {} 倍率 {}", available, parallelism, size, times);
        ForkJoinPool forkJoinPool = new ForkJoinPool(parallelism);
        List<R> res = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            int start = i * parallelism;
            int end;
            if (i != times - 1) {
                end = (i + 1) * parallelism;
            } else {
                end = size;
            }
            log.info("核心数索引 {} {}", start, end);
            List<T> partSrc = new ArrayList<>(list.subList(start, end));
            List<R> partDst = forkJoinPool.invoke(new Task<>(f, partSrc));
            res.addAll(partDst);
        }
        forkJoinPool.shutdown();
        return res;
    }

    /**
     * 递归任务
     *
     * @param <T> 输入类型
     * @param <R> 输出类型
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
            Task<T, R> task1 = new Task<>(f, list.subList(0, 1));//第一个
            Task<T, R> task2 = new Task<>(f, list.subList(1, list.size()));//剩余的
            task2.fork();
            List<R> first = task1.invoke();
            first.addAll(task2.join());
            return first;
        }
    }
}
