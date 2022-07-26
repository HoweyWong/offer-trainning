package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点的最近公共祖先
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/26 9:30
 */
public class LowestCommonAncestor {
    /**
     * 通过广度优先遍历，分别找到p、q的路径，再遍历两者的路径，找到最后一个相同的节点
     */
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = getPath(root, p);
        List<TreeNode> qList = getPath(root, q);
        TreeNode ancestorNode = null;
        for (int i = 0; i < pList.size() && i < qList.size(); i++) {
            if (pList.get(i) == qList.get(i)) {
                ancestorNode = pList.get(i);
            } else {
                break;
            }
        }
        return ancestorNode;
    }

    private static List<TreeNode> getPath(TreeNode root, TreeNode target) {
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode node = root;
        while (node.data != target.data) {
            if (target.data < node.data) {
                node = node.leftChild;
                list.add(node);
            } else if (target.data > node.data) {
                node = node.rightChild;
                list.add(node);
            }
        }
        return list;
    }
}
