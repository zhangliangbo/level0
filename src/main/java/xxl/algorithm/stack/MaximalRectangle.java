package xxl.algorithm.stack;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangliangbo
 * @since 2021/12/18
 **/


@Slf4j
public class MaximalRectangle {

    private LargestRectangleArea largestRectangleArea = new LargestRectangleArea();

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '0') {
                    heights[i] = 0;
                } else {
                    heights[i]++;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea.largestRectangleArea3(heights));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'0', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int i = maximalRectangle.maximalRectangle(matrix);
        System.err.println(i);
    }

}
