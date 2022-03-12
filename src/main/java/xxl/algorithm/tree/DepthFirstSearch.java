package xxl.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 深度优先搜索
 *
 * @author zlb
 * @since 2021/12/27
 */
public class DepthFirstSearch {

    public List<Integer> inorder(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        inorderDfs(root, nodes);
        return nodes;
    }

    private void inorderDfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            inorderDfs(root.getLeft(), nodes);
            nodes.add(root.getVal());
            inorderDfs(root.getRight(), nodes);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            result.add(cur.getVal());
            cur = cur.getRight();
        }
        return result;
    }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        preorderDfs(root, nodes);
        return nodes;
    }

    private void preorderDfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            nodes.add(root.getVal());
            preorderDfs(root.getLeft(), nodes);
            preorderDfs(root.getRight(), nodes);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.add(cur.getVal());
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            cur = cur.getRight();
        }
        return result;
    }

    public List<Integer> postorder(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        postorderDfs(root, nodes);
        return nodes;
    }

    private void postorderDfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            postorderDfs(root.getLeft(), nodes);
            postorderDfs(root.getRight(), nodes);
            nodes.add(root.getVal());
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.peek();
            if (cur.getRight() != null && cur.getRight() != prev) {
                cur = cur.getRight();
            } else {
                stack.pop();
                result.add(cur.getVal());
                prev = cur;
                cur = null;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.setLeft(node3);
        TreeNode node5 = new TreeNode(5);
        root.setRight(node5);

        TreeNode node7 = new TreeNode(7);
        node5.setLeft(node7);
        TreeNode node1 = new TreeNode(1);
        node5.setRight(node1);

        TreeNode node4 = new TreeNode(4);
        node3.setLeft(node4);
        TreeNode node6 = new TreeNode(6);
        node3.setRight(node6);

        DepthFirstSearch dfs = new DepthFirstSearch();
        List<Integer> integers = dfs.inorderTraversal(root);
        System.err.println(integers);
        integers = dfs.inorder(root);
        System.err.println(integers);

        integers = dfs.preorderTraversal(root);
        System.err.println(integers);
        integers = dfs.preorder(root);
        System.err.println(integers);

        integers = dfs.postorderTraversal(root);
        System.err.println(integers);
        integers = dfs.postorder(root);
        System.err.println(integers);
    }

}
