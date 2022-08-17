package tree;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description 二叉排序树
 * @Author huanghao
 * @Date 2022-2-21
 * @Version 1.0
 */
public class BinarySortTree {
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
        if (data < node.val) {
            node.left = insert(node.left, data);
        } else if (data > node.val) {
            node.right = insert(node.right, data);
        } else {
            node.val = data;
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
        System.out.print(node.val + " ");
        preOrderTra(node.left);
        preOrderTra(node.right);
    }

    /**
     * 中序
     */
    public void midOrderTra(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrderTra(node.left);
        System.out.print(node.val + " ");
        midOrderTra(node.right);
    }

    /**
     * 后序
     */
    public void postOrderTra(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTra(node.left);
        postOrderTra(node.right);
        System.out.print(node.val + " ");
    }

    /**
     * 广度优先，层序遍历
     */
    public void levelTra(TreeNode node) {
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode leaf = queue.poll();
            System.out.print(leaf.val + " ");
            if (leaf.left != null) {
                queue.offer(leaf.left);
            }
            if (leaf.right != null) {
                queue.offer(leaf.right);
            }
        }
    }

    public static void main(String[] args) {
        BinarySortTree tree = new BinarySortTree();
        tree.insertNode(10);
        tree.insertNode(8);
        tree.insertNode(11);
        tree.insertNode(7);
        tree.insertNode(9);
        tree.insertNode(12);
        System.out.println(tree);
        System.out.print("preOrderTra：");

        tree.preOrderTra(tree.root);
        System.out.println();
        System.out.print("midOrderTra：");
        tree.midOrderTra(tree.root);
        System.out.println();
        System.out.print("postOrderTra：");
        tree.postOrderTra(tree.root);
        System.out.println();
        System.out.print("levelTra：");
        tree.levelTra(tree.root);
        System.out.println();
        System.out.println("LowestCommonAncestor:" + LowestCommonAncestor.lowestCommonAncestor(tree.root, new TreeNode(7), new TreeNode(9)));
    }
}
