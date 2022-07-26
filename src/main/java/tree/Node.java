package tree;

import java.util.List;

/**
 * 普通树
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/25 17:33
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
