package xxl.algorithm.queue;

import lombok.extern.slf4j.Slf4j;
import xxl.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangliangbo
 * @since 2021/12/21
 **/


@Slf4j
public class CbtInserter {
    private TreeNode root;
    private Queue<TreeNode> queue;

    public CbtInserter(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            TreeNode peek = queue.peek();
            if (peek != null && peek.getLeft() != null && peek.getRight() != null) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.offer(node.getLeft());
                    queue.offer(node.getRight());
                }
            } else {
                break;
            }
        }
    }

    public int insert(int v) {
        TreeNode parent = queue.peek();

        if (parent == null) {
            return 0;
        }

        TreeNode node = new TreeNode(v);

        if (parent.getLeft() == null) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);

            queue.poll();

            queue.offer(parent.getLeft());
            queue.offer(parent.getRight());
        }

        return parent.getVal();
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.setLeft(node2);
        root.setRight(node3);

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.setLeft(node4);
        node2.setRight(node5);

        TreeNode node6 = new TreeNode(6);
        node3.setLeft(node6);

        CbtInserter cbtInserter = new CbtInserter(root);
        System.err.println(cbtInserter.insert(7));
        System.err.println(cbtInserter.insert(8));
        System.err.println(cbtInserter.insert(9));

        System.err.println(cbtInserter.getRoot());
    }

}
