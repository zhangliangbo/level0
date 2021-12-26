package xxl.algorithm.queue;

import lombok.extern.slf4j.Slf4j;
import xxl.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangliangbo
 * @since 2021/12/25
 **/


@Slf4j
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new LinkedList<>();

        if (root == null) {
            return view;
        }

        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();

        currentLevel.offer(root);

        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.poll();

            if (node.getLeft() != null) {
                nextLevel.offer(node.getLeft());
            }

            if (node.getRight() != null) {
                nextLevel.offer(node.getRight());
            }

            if (currentLevel.isEmpty()) {
                view.add(node.getVal());

                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
            }
        }

        return view;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        root.setLeft(node6);
        TreeNode node10 = new TreeNode(10);
        root.setRight(node10);

        TreeNode node5 = new TreeNode(5);
        node6.setLeft(node5);
        TreeNode node7 = new TreeNode(7);
        node6.setRight(node7);

        RightSideView rightSideView = new RightSideView();
        List<Integer> integers = rightSideView.rightSideView(root);
        System.err.println(integers);
    }
}
