package tree;

/**
 * 二叉树剪枝
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/21 13:55
 */
public class PruneTree {
    static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
