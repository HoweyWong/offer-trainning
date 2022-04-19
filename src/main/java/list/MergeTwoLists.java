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
     *
     * @param l1
     * @param l2
     * @return list.ListNode
     * @author huanghao
     * @date 2022/4/15 14:23
     */
    public ListNode mergeTwoListsCur(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsCur(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsCur(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsIte(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(-9, new ListNode(3));
        ListNode listNode2 = new ListNode(5, new ListNode(7));
        MergeTwoLists lists = new MergeTwoLists();
        ListNode listNode3 = lists.mergeTwoLists(listNode1, listNode2);
//        ListNode listNode4 = lists.mergeTwoLists(new ListNode(1), new ListNode(2));
        log.info(listNode3.toString());
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
