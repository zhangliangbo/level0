package xxl.algorithm.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangliangbo
 * @since 2021/12/18
 **/


@Slf4j
public class MovingAverage {
    private Queue<Integer> nums;
    private int capacity;
    private int sum;

    public MovingAverage(int size) {
        nums = new LinkedList<>();
        capacity = size;
    }

    public double next(int val) {
        nums.offer(val);
        sum += val;
        if (nums.size() > capacity) {
            sum -= nums.poll();
        }
        return (double) sum / nums.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        for (int i = 1; i <= 7; i++) {
            System.err.println(movingAverage.next(i));
        }
    }

}
