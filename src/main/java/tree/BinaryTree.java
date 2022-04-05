package tree;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-2-21
 * @Version 1.0
 */
public class BinaryTree {
    TreeNode root;

    @Override
    public String toString() {
        return "BinaryTree{" + "root=" + root + '}';
    }

    public void insertNode(int data) {
        root = insert(root, data);
    }

    private TreeNode insert(TreeNode node, int data) {
        // 递归的结束标志
        if (node == null) {
            return new TreeNode(data);
        }
        if (data < node.data) {
            node.leftChild = insert(node.leftChild, data);
        } else if (data > node.data) {
            node.rightChild = insert(node.rightChild, data);
        } else {
            node.data = data;
        }
        return node;
    }

    /**
     * 前序遍历
     */
    public void preOrderTra(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTra(node.leftChild);
        preOrderTra(node.rightChild);
    }

    /**
     * 中序
     */
    public void midOrderTra(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrderTra(node.leftChild);
        System.out.println(node.data);
        midOrderTra(node.rightChild);
    }

    /**
     * 后序
     */
    public void postOrderTra(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTra(node.leftChild);
        postOrderTra(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 广度优先，层序遍历
     */
    public void levelTra(TreeNode node) {
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
        BinaryTree tree = new BinaryTree();
        tree.insertNode(10);
        tree.insertNode(8);
        tree.insertNode(11);
        tree.insertNode(7);
        tree.insertNode(9);
        tree.insertNode(12);
        System.out.println(tree);
        tree.preOrderTra(tree.root);
        System.out.println("==============================================================");
        tree.midOrderTra(tree.root);
        System.out.println("==============================================================");
        tree.postOrderTra(tree.root);
        System.out.println("==============================================================");
        tree.levelTra(tree.root);
    }
}
