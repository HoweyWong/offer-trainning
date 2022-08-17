package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 验证二叉搜索树
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/27 16:21
 */
public class IsValidBST {
    static boolean isValidBst(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                if (root.left.val < root.val) {
                    root = root.left;
                } else {
                    return false;
                }
            }
            if (root.right != null) {
                if (root.right.val > root.val) {
                    root = root.right;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValidBstOpz(TreeNode root) {
        return isValidBstOpz(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBstOpz(TreeNode node, long low, long high) {
        if (node == null) {
            return true;
        }
        if (node.val < low || node.val > high) {
            return false;
        }
        return isValidBstOpz(node.left, low, node.val) && isValidBstOpz(node.right, node.val, high);
    }

    static boolean isValidBstOpzBft(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (node.left.val >= node.val) {
                    return false;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (node.right.val <= node.val) {
                    return false;
                } else {
                    queue.offer(node.right);
                }
            }
        }
        return true;
    }
}
