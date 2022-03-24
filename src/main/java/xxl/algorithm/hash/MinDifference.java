package xxl.algorithm.hash;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangliangbo
 * @since 2021/11/29
 **/


@Slf4j
public class MinDifference {

    public int findMinDifference(List<String> timePoints) {
        int maxLen = 1440;
        if (timePoints.size() > maxLen) {
            return 0;
        }
        boolean[] minuteFlags = new boolean[1440];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int min = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);

            //有重复值
            if (minuteFlags[min]) {
                return 0;
            }

            minuteFlags[min] = true;
        }

        return helper(minuteFlags);
    }

    private int helper(boolean[] minuteFlags) {
        int minDiff = minuteFlags.length - 1;
        int prev = -1;
        int first = minuteFlags.length - 1;
        int last = -1;
        for (int i = 0; i < minuteFlags.length; ++i) {
            if (minuteFlags[i]) {
                if (prev >= 0) {
                    minDiff = Math.min(i - prev, minDiff);
                }

                prev = i;

                first = Math.min(i, first);
                last = Math.max(i, last);
            }
        }
        //首尾比较
        minDiff = Math.min(first + minuteFlags.length - last, minDiff);
        return minDiff;
    }

    public static void main(String[] args) {
        MinDifference minDifference = new MinDifference();
        List<String> list = new LinkedList<>();
        list.addAll(Arrays.asList("23:50", "23:59", "00:00"));
        int difference = minDifference.findMinDifference(list);
        System.err.println(difference);
    }
}

