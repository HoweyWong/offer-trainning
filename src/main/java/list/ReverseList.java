package list;

/**
 * 反转链表
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/20 17:18
 */
public class ReverseList {
    /**
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     */
    static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.fill(5);
        ListNode.print(node);
        ListNode.print(reverseList(node));
    }
}
