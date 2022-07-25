package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 完全二叉树插入器
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/25 14:17
 */
public class CBTInserter {
    private TreeNode root;
    private List<TreeNode> arrayQueue = new ArrayList<>();
    private int idx = 0;

    public CBTInserter(TreeNode root) {
        this.root = root;
        arrayQueue.add(root);
        int i = 0;
        while (i < arrayQueue.size()) {
            TreeNode cur = arrayQueue.get(i);
            if (cur.leftChild != null) {
                arrayQueue.add(cur.leftChild);
            }
            if (cur.rightChild != null) {
                arrayQueue.add(cur.rightChild);
            }
            i++;
        }
    }

    public int insert(int value) {
        TreeNode node = new TreeNode(value);
        while (arrayQueue.get(idx).leftChild != null && arrayQueue.get(idx).rightChild != null) {
            idx++;
        }
        TreeNode cur = arrayQueue.get(idx);
        if (cur.leftChild == null) {
            cur.leftChild = node;
        } else if (cur.rightChild == null) {
            cur.rightChild = node;
        }
        arrayQueue.add(node);
        return cur.data;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        CBTInserter cbtInserter = new CBTInserter(root);
        cbtInserter.insert(1);
        cbtInserter.insert(2);
        cbtInserter.insert(3);
        cbtInserter.insert(4);
        cbtInserter.insert(5);
        cbtInserter.insert(6);
        cbtInserter.insert(7);
        cbtInserter.insert(8);
        cbtInserter.insert(9);
        cbtInserter.print(root);
    }
}
