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
        root.leftChild = pruneTree(root.leftChild);
        root.rightChild = pruneTree(root.rightChild);
        if (root.leftChild == null && root.rightChild == null && root.data == 0) {
            return null;
        }
        return root;
    }
}
