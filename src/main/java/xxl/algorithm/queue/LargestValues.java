package xxl.algorithm.queue;

import lombok.extern.slf4j.Slf4j;
import xxl.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangliangbo
 * @since 2021/12/24
 **/


@Slf4j
public class LargestValues {
    public List<Integer> largestValues1(TreeNode root) {
        //当前层未处理节点数
        int current = 0;
        //下一次的节点数
        int next = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            current = 1;
        }

        List<Integer> result = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            max = Math.max(max, node.getVal());

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
                next++;
            }

            if (node.getRight() != null) {
                queue.offer(node.getRight());
                next++;
            }

            if (current == 0) {
                result.add(max);
                max = Integer.MIN_VALUE;
                current = next;
                next = 0;
            }
        }
        return result;
    }

    public List<Integer> largestValues2(TreeNode root) {
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();

        if (root != null) {
            currentLevel.offer(root);
        }

        List<Integer> result = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.poll();
            max = Math.max(max, node.getVal());

            if (node.getLeft() != null) {
                nextLevel.offer(node.getLeft());
            }

            if (node.getRight() != null) {
                nextLevel.offer(node.getRight());
            }

            if (currentLevel.isEmpty()) {
                result.add(max);

                max = Integer.MIN_VALUE;
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LargestValues largestValues = new LargestValues();

        TreeNode root = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.setLeft(node4);
        TreeNode node2 = new TreeNode(2);
        root.setRight(node2);
        TreeNode node5 = new TreeNode(5);
        node4.setLeft(node5);
        TreeNode node1 = new TreeNode(1);
        node4.setRight(node1);
        TreeNode node9 = new TreeNode(9);
        node2.setRight(node9);

        List<Integer> res = largestValues.largestValues1(root);
        System.err.println(res);

        res = largestValues.largestValues2(root);
        System.err.println(res);
    }
}
