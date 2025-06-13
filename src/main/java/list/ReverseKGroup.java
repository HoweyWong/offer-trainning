package list;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 */
public class ReverseKGroup {
    static public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, end = dummy;

        while (true) {
            int count = 0;
            while (count < k && end != null) {
                end = end.next;
                count++;
            }
            if (end == null) break;

            ListNode start = pre.next; // 全链表
            ListNode next = end.next; // 移动了2之后的链表
            end.next = null;  // 断开链表

            pre.next = reverseList(start);  // 复用反转链表函数
            start.next = next;

            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    // 复用第1题反转链表代码
    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ThreadLocal<Integer> local = new ThreadLocal<>();
        local.set(2);
        ListNode node = ListNode.fill(5);
        ListNode.print(node);
        ListNode.print(reverseKGroup(node, 2));
    }
}
