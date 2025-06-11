package tree;

public class NodeWithPoint
{
    public int val;
    public NodeWithPoint left;
    public NodeWithPoint right;
    public NodeWithPoint next;

    public NodeWithPoint() {}

    public NodeWithPoint(int _val) {
        val = _val;
    }

    public NodeWithPoint(int _val, NodeWithPoint _left, NodeWithPoint _right, NodeWithPoint _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        String nextStr = next==null?"null": String.valueOf(next.val);
        return "NodeWithPoint{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + nextStr +
                '}';
    }
}
