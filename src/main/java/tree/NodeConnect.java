package tree;

import java.util.LinkedList;
import java.util.Queue;

public class NodeConnect {
    public NodeWithPoint connect(NodeWithPoint root) {
        if (root == null){
            return null;
        }
        Queue<NodeWithPoint> queue = new LinkedList<>();
        queue.offer(root);
        // 层数
        while (!queue.isEmpty()){
            // 通过size加内部for循环，达到层序遍历
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeWithPoint node = queue.poll();
                if (i<size-1){
                    node.next = queue.peek();
                }
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        NodeWithPoint root = new NodeWithPoint(1,new NodeWithPoint(2),new NodeWithPoint(3),null);
        NodeConnect sum = new NodeConnect();
        System.out.println(sum.connect(root));
    }
}
