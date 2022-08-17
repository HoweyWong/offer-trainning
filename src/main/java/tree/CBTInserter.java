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
            if (cur.left != null) {
                arrayQueue.add(cur.left);
            }
            if (cur.right != null) {
                arrayQueue.add(cur.right);
            }
            i++;
        }
    }

    public int insert(int value) {
        TreeNode node = new TreeNode(value);
        while (arrayQueue.get(idx).left != null && arrayQueue.get(idx).right != null) {
            idx++;
        }
        TreeNode cur = arrayQueue.get(idx);
        if (cur.left == null) {
            cur.left = node;
        } else if (cur.right == null) {
            cur.right = node;
        }
        arrayQueue.add(node);
        return cur.val;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
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
