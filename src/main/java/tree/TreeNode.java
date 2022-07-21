package tree;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-2-21
 * @Version 1.0
 */
public class TreeNode {
    TreeNode leftChild;
    TreeNode rightChild;
    int data;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(TreeNode leftChild, TreeNode rightChild, int data) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    public TreeNode() {
    }
}
