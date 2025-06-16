package list;

/**
 * 删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 栈；双指针；找出序号
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        int len = getLength(head);
        ListNode pre = temp;
        // 找到倒数第n个节点
        for (int i = 0; i < len - n; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return temp.next;
    }

    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    // 双指针
    public ListNode removeNthFromEndNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fl = head;
        ListNode sl = dummy;
        for (int i = 0; i < n; i++) {
            fl = fl.next;
            if (fl == null) {
                break;
            }
        }
        while (fl != null) {
            fl = fl.next;
            sl = sl.next;
        }
        sl.next = sl.next.next;
        return dummy.next;
    }
}
