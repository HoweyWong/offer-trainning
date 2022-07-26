package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通树前序遍历
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/25 17:35
 */
public class TreePreorder {
    static List<Integer> preOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private static void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        // 类似二叉树的左右孩子，这里就是多孩子，list
        for (Node node : root.children) {
            helper(node, res);
        }
    }
}
