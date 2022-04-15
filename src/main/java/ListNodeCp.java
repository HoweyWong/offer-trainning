import java.util.Stack;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-8-15
 * @Version 1.0
 */
public class ListNodeCp {

    /**
     * 传入链表头结点，利用栈把所有节点放进去，实现倒序打印
     */
    public int[] reversePrint(ListNode head) {
        // 构建栈，里面存储每个链表的节点
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        // 遍历链表，压入栈中
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        // 定义数组接收
        int size = stack.size();
        int[] print = new int[size];
        // 遍历stack
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    /**
     * 反转链表，输出头结点
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 拿到下一个节点
            ListNode next = cur.next;
            // 把后一个节点给到pre
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 最后一个节点情况：cur = null,pre = head;
        return pre;
    }


    /**
     * 单向链表结构
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 链表复制
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }

    class Node {
        int val;
        Node next, random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
