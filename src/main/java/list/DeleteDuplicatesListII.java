package list;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表删除重复数据2：无序链表，需要一个存储空间；
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/21 9:48
 */
public class DeleteDuplicatesListII {
    /**
     * 暴力解法：时间复杂度O（n），但是有三次遍历
     * 空间复杂度O（n）
     */
    static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        // 存放重复的数据
        List<Integer> duplicate = new ArrayList<>();
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                duplicate.add(cur.val);
            } else {
                cur = cur.next;
            }
        }
        while (head != null) {
            if (duplicate.contains(head.val)) {
                head = head.next;
            } else {
                break;
            }
        }
        if (head == null) {
            return null;
        }
        cur = head;
        while (cur.next != null) {
            if (duplicate.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 时间复杂度O（n）
     * 空间复杂度O（1）,常量级别
     */
    static ListNode deleteDuplicatesOpz(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = new ListNode(0, head);
        ListNode cur = tmp;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                // 重复的数据
                int val = cur.next.val;
                // 向后遍历，遇到删除
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(2);
        ListNode.addLast(listNode, node4);
        ListNode.addLast(listNode, node6);
        ListNode.addLast(listNode, node7);
        /*ListNode node5 = new ListNode(0);
        ListNode.addLast(listNode, node5);
        listNode = ListNode.fill(7);
        ListNode node = new ListNode(6);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(6);
        listNode = ListNode.addLast(listNode, node);
        listNode = ListNode.addLast(listNode, node2);
        listNode = ListNode.addLast(listNode, node3);*/
        ListNode.print(listNode);
//        ListNode.print(deleteDuplicates(listNode));
        ListNode.print(deleteDuplicatesOpz(listNode));
    }
}
