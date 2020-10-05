package xxl.mathematica.parallel;

import io.vavr.control.Try;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Function;

/**
 * 并行映射(forkjoin)
 *
 * @author zhangliangbo
 * @time 2020/8/31
 */
public class ParallelMap {
    /**
     * 并行映射
     *
     * @param f
     * @param list
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> parallelMap(Function<T, R> f, List<T> list) {
        return Try.ofCallable(() -> ForkJoinPool.commonPool().invoke(new Task<>(f, list))).get();
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
            Task<T, R> task1 = new Task<>(f, list.subList(0, 1));//第一个
            Task<T, R> task2 = new Task<>(f, list.subList(1, list.size()));//剩余的
            task2.fork();
            List<R> first = task1.invoke();
            first.addAll(task2.join());
            return first;
        }
    }
}
