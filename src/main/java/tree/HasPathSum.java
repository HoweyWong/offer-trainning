package tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的根节点 root 和一个表示目标和的整数 targetSum
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 */
public class HasPathSum {
    // 递归 DFS
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 退出条件 1、节点为空，到达叶子节点，所有节点都遍历
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        // 只要有一个为true则为true，全部结果进行或运算
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // 利用队列处理，先进先出，到最后就是叶子节点数，包括结果数也是
    public boolean hasPathSumQueueBfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            // 弹出队列的节点，遍历完的都会弹出
            TreeNode node = nodeQueue.poll();
            int sum = sumQueue.poll();
            if (node.left == null && node.right == null && sum == targetSum) {
                return true;
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                sumQueue.offer(sum + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                sumQueue.offer(sum + node.right.val);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(2), new TreeNode(3), 1);
        HasPathSum sum = new HasPathSum();
        System.out.println(sum.hasPathSumQueueBfs(root, 4));
    }
}
