package xxl.algorithm.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhangliangbo
 * @since 2021/12/12
 **/


@Slf4j
public class Asteroid {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int as : asteroids) {
            while (!stack.empty() && stack.peek() > 0 && stack.peek() < -as) {
                stack.pop();
            }
            if (!stack.empty() && as < 0 && stack.peek() == -as) {
                stack.pop();
            } else if (as > 0 || stack.empty() || stack.peek() < 0) {
                stack.push(as);
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        Asteroid asteroid = new Asteroid();
        int[] ints = asteroid.asteroidCollision(new int[]{4, 5, -6, 4, 6, -5, -9});
        System.err.println(Arrays.toString(ints));
    }

}
