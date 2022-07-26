package list;

/**
 * 环形链表位置获取
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/21 16:21
 */
public class DetectCycle {
    /**
     * a+n(b+c)+b = a+(n+1)b+nc = 2(a+b)
     * a = (n-1)(b+c)
     * 利用数学关系获得环形节点的位置，三个指针，快慢指针相遇后，原指针开始走，跟慢指针第一次相遇，必定是环形入口
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            // 慢指针步长1
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
