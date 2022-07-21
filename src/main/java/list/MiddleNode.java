package list;

import java.util.ArrayList;
import java.util.List;

/**
 * 中间节点
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/21 15:25
 */
public class MiddleNode {
    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     */
    static ListNode middleNode(ListNode head) {
        List<ListNode> tmp = new ArrayList<>();
        while (head != null) {
            tmp.add(head);
            head = head.next;
        }
        return tmp.get(tmp.size() / 2);
    }

    static ListNode middleNodeOpzTwoPoint(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.fill(6);
        ListNode.print(node);
        ListNode.print(middleNode(node));
        ListNode.print(middleNodeOpzTwoPoint(node));
    }
}
