package xxl.algorithm.queue;

import lombok.extern.slf4j.Slf4j;
import xxl.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangliangbo
 * @since 2021/12/25
 **/


@Slf4j
public class BottomLeftValue {
    public int bottomLeftValue(TreeNode root) {
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();

        currentLevel.offer(root);

        int bottomLeft = root.getVal();
        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.poll();
            if (node.getLeft() != null) {
                nextLevel.offer(node.getLeft());
            }

            if (node.getRight() != null) {
                nextLevel.offer(node.getRight());
            }

            if (currentLevel.isEmpty()) {
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();

                if (!currentLevel.isEmpty()) {
                    bottomLeft = currentLevel.peek().getVal();
                }
            }
        }

        return bottomLeft;
    }

    public static void main(String[] args) {
        BottomLeftValue bottomLeftValue = new BottomLeftValue();

        TreeNode root = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        root.setLeft(node6);
        TreeNode node10 = new TreeNode(10);
        root.setRight(node10);

        TreeNode node5 = new TreeNode(5);
        node6.setLeft(node5);
        TreeNode node7 = new TreeNode(7);
        node6.setRight(node7);

        TreeNode node9 = new TreeNode(9);
        node10.setLeft(node9);
        TreeNode node11 = new TreeNode(11);
        node10.setRight(node11);

        int result = bottomLeftValue.bottomLeftValue(root);
        System.err.println(result);
    }
}
