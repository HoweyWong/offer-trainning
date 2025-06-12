package list;

/**
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class MyReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 保存下一个节点
            ListNode next = cur.next;
            // 更改cur的下一个节点
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode node = ListNode.fill(5);
        ListNode.print(node);
        ListNode.print(reverseListRecursive(node));
    }
}
