package list;

/**
 * 删除重复数据
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/20 18:12
 */
public class DeleteDuplicatesListI {
    static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.fill(6);
        ListNode node = new ListNode(5);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(5);
        listNode = ListNode.addLast(listNode, node);
        listNode = ListNode.addLast(listNode, node2);
        listNode = ListNode.addLast(listNode, node3);
        ListNode.print(listNode);
        ListNode.print(deleteDuplicates(listNode));
    }
}
