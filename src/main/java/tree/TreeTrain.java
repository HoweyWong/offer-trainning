package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-8-22
 * @Version 1.0
 */
public class TreeTrain {
    /**
     * 从上到下打印二叉树（BFS）
     * 广度优先搜索
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
//        Queue<TreeNode> queue = new LinkedList<>() {{
//            add(root);
//        }};
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 队列先入先出
            // 队列首出列
            TreeNode node = queue.poll();
            ans.add(node.val);
            // 加入左子树
            if (node.left != null) {
                queue.add(node.left);
            }
            // 右子树入队列
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;

    }

    /**
     * 层序遍历,一层层打印
     */
    public List<List<Integer>> levelOrderFloor(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            // 获得当前queue的大小，相当于只有当前层被遍历，然后把叶子节点加入作为下一层
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                // 加入左右节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    /**
     * 层序遍历，Z字型，利用双端队列
     */
    public List<List<Integer>> levelOrderFloorInZ(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            // 获得当前queue的大小，相当于只有当前层被遍历，然后把叶子节点加入作为下一层
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                // 分奇偶数，分别按头尾插入
                if (res.size() % 2 == 0) {
                    tmp.addLast(node.val);
                } else {
                    tmp.addFirst(node.val);
                }
                // 加入左右节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    /**
     * 二叉树构造
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 判断是否为子树
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null)
                // 从根节点判断
                && (recur(A, B)
                // 左子树判断
                || isSubStructure(A.left, B)
                // 右子树判断
                || isSubStructure(A.right, B));
    }


    boolean recur(TreeNode A, TreeNode B) {
        // 直至右树遍历完
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        // 遍历左树、右树
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    /**
     * 镜像树，递归节点替换
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 作为交换，先保存到tmp
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    /**
     * 对称二叉树判断
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recurSym(root.left, root.right);
    }

    boolean recurSym(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recurSym(L.left, R.right) && recurSym(L.right, R.left);
    }

}
