package xxl.algorithm.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author zhangliangbo
 * @since 2021/12/19
 **/


@Slf4j
public class RecentCounter {

    private Queue<Integer> times;
    private int windowSize;

    public RecentCounter() {
        times = new LinkedList<>();
        windowSize = 3000;
    }

    public int ping(int t) {
        times.offer(t);
        while (times.peek() + windowSize < t) {
            times.poll();
        }
        return times.size();
    }

    public static void main(String[] args) throws InterruptedException {
        RecentCounter recentCounter = new RecentCounter();
        long start = System.currentTimeMillis();
        int i = 100;
        Random random = new Random();
        while (--i > 0) {
            int ping = recentCounter.ping((int) (System.currentTimeMillis() - start));
            System.err.println(ping);
            long sleep = random.nextInt(5) * 1000;
            System.err.println("sleep " + sleep);
            Thread.sleep(sleep);
        }
    }

}
