package tree;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树是有序树，度数不超过2；2度的树则是无序的。
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/21 14:03
 */
public class BinaryTree {
    private TreeNode root;
    private static int index;

    public void insertNode(int[] data) {
        root = insert(root, data);
    }

    public TreeNode insert(TreeNode node, int[] data) {
        int index = 0;
        // 当前节点为空，即插入
        if (node == null) {
            return new TreeNode(data[index]);
        }
        node.leftChild = insert(node.leftChild, data);
        node.rightChild = insert(node.rightChild, data);
        return node;
    }

    public static TreeNode CreateBTree(int[] a) {
        TreeNode root = null;
        if (a[index] != '#') {
            root = new TreeNode(a[index]);
            index++;
            root.leftChild = CreateBTree(a);
            index++;
            root.rightChild = CreateBTree(a);
        }
        return root;

    }

    public static void minOrderTra(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        minOrderTra(node.leftChild);
        minOrderTra(node.rightChild);
    }

    public static void levelTra(TreeNode node) {
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode leaf = queue.poll();
            System.out.println(leaf.data);
            if (leaf.leftChild != null) {
                queue.offer(leaf.leftChild);
            }
            if (leaf.rightChild != null) {
                queue.offer(leaf.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tree = CreateBTree(new int[]{1, 0, 1, 0, 0, '#', '#', 0, 1, '#', '#'});
        levelTra(tree);

    }
}
