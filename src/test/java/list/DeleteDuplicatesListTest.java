package list;

//有序链表，删除重复元素
public class DeleteDuplicatesListTest {
    public ListNode deleteDuplicatesList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode result = cur;
        while (cur.next != null) {
            // 取值需要考虑判空
            if (cur.val == cur.next.val) {
                // 赋值不需要考虑空指针
                // 此时仍然是对当前节点判断，因为可能下一节点也相等
                cur.next = cur.next.next;
            } else {
                // 往后移
                cur = cur.next;
            }
        }
        return result;
    }
}
