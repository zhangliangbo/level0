package xxl.algorithm.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhangliangbo
 * @since 2021/12/14
 **/


@Slf4j
public class DailyTemperature {
    public int[] dailyTemperature(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                result[prev] = i - prev;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] ints = dailyTemperature.dailyTemperature(new int[]{35, 31, 33, 36, 34});
        System.err.println(Arrays.toString(ints));
    }
}
