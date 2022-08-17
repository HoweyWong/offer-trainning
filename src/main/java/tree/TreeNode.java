package tree;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-2-21
 * @Version 1.0
 */
public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode() {
    }

    @Override
    public String toString() {
        return "TreeNode{data=" + val +
                ", leftChild=" + left.val +
                ", rightChild=" + right.val +
                '}';
    }
}
