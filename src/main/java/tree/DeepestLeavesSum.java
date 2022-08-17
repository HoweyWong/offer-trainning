package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 层数最深的叶子节点的和
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/8/17 14:27
 */
public class DeepestLeavesSum {
    /**
     * 解法一：层序遍历（广度优先遍历）遍历到最后一层就是答案，不需要去判断
     * 注意：层序遍历是自身没有分层，需要对当前层做个隔离，通过size做for循环
     */
    public int deepestLeavesSumBfs(TreeNode root) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        int sum = 0;
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            sum = 0;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                sum += node.val;
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
        }
        return sum;
    }

    int sum = 0, maxLevel = -1;

    /**
     * 解法二：深度遍历，遍历所有节点，记下层数
     * 注意：当层数相等时，累计数值；
     * 层数大于最大值，说明当前层有可能才是最深层，替换之，替换后遇到层数相同的继续上一步，累计。
     */
    public int deepestLeavesSumDfs(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level == maxLevel) {
            sum += node.val;
        } else if (level > maxLevel) {
            sum = node.val;
            maxLevel = level;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
