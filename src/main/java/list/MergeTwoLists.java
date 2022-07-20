package list;

import lombok.extern.slf4j.Slf4j;

/**
 * 合并两有序链表
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/4/15 10:25
 */
@Slf4j
public class MergeTwoLists {
    /**
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     *
     * @param list1
     * @param list2
     * @return list.ListNode
     * @author huanghao
     * @date 2022/4/15 10:27
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode listNode = list1;
        int temp;
        ListNode tempNode;
        while (list1 != null) {
            while (list2 != null) {
                // 如果第二个链表值等于当前值，则插入后面
                if (list2.val == list1.val) {
                    temp = list2.val;
                    tempNode = list1.next;
                    list1.next = new ListNode(temp, tempNode);
                    // list2后移
                    list2 = list2.next;
                }
                // 如果第二个链表值小于当前值，则插入前面
                else if (list2.val < list1.val) {
                    // 前移
                    temp = list1.val;
                    tempNode = list1.next;
                    list1.val = list2.val;
                    list1.next = new ListNode(temp, tempNode);
                    list2 = list2.next;
                } else {
                    // 没有符合情况的，list2不移动，退出，list1继续后移比较
                    break;
                }
            }
            list1 = list1.next;
        }
        // 处理剩余的list2节点，插到尾部
        if (list2 != null) {
            ListNode head = listNode;
            while (head != null) {
                if (head.next == null) {
                    head.next = list2;
                    break;
                }
                head = head.next;
            }
        }
        return listNode;
    }

    /**
     * 递归方式实现
     * 时间复杂度O(n+m)
     * 空间复杂度O(n+m)，每次递归占用栈空间
     */
    public static ListNode mergeTwoListsCur(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoListsCur(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsCur(list1, list2.next);
            return list2;
        }
    }

    /**
     * 迭代实现：时间复杂度，两链表长度O（n+m），空间复杂度O(1)
     */
    public static ListNode mergeTwoListsIte(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = list1 == null ? list2 : list1;

        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.fill(6);
        ListNode list2 = ListNode.fill(6);
        ListNode listNode = mergeTwoListsCur(list1, list2);
        ListNode.print(listNode);
    }
}


