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
            if (root.leftChild != null) {
                if (root.leftChild.data < root.data) {
                    root = root.leftChild;
                } else {
                    return false;
                }
            }
            if (root.rightChild != null) {
                if (root.rightChild.data > root.data) {
                    root = root.rightChild;
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
        if (node.data < low || node.data > high) {
            return false;
        }
        return isValidBstOpz(node.leftChild, low, node.data) && isValidBstOpz(node.rightChild, node.data, high);
    }

    static boolean isValidBstOpzBft(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.leftChild != null) {
                if (node.leftChild.data > node.data) {
                    return false;
                } else {
                    queue.offer(node.leftChild);
                }
            }
            if (node.rightChild != null) {
                if (node.rightChild.data < node.data) {
                    return false;
                } else {
                    queue.offer(node.rightChild);
                }
            }
        }
        return true;
    }
}
