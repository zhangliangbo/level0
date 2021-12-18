package xxl.algorithm.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author zhangliangbo
 * @since 2021/12/14
 **/


@Slf4j
public class LargestRectangleArea {
    public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                int area = min * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        return helper(heights, 0, heights.length);
    }

    private int helper(int[] heights, int start, int end) {
        if (start == end) {
            return 0;
        }

        if (start + 1 == end) {
            return heights[start];
        }

        int minIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }

        int area = (end - start) * heights[minIndex];
        //二分+递归
        int left = helper(heights, start, minIndex);
        int right = helper(heights, minIndex + 1, end);

        area = Math.max(area, left);
        return Math.max(area, right);
    }

    public int largestRectangleArea3(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] data = new int[]{3, 2, 5, 4, 6, 1, 4, 2};
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        int area1 = largestRectangleArea.largestRectangleArea1(data);
        System.err.println(area1);
        int area2 = largestRectangleArea.largestRectangleArea2(data);
        System.err.println(area2);
        int area3 = largestRectangleArea.largestRectangleArea3(data);
        System.err.println(area3);
    }

}
