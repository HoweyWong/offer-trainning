package math;

/**
 * TODO (输入本类描述)
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/6/21 17:38
 */
public class ListNodeAdd {
    public void printList(ListNode head) {
        ListNode curNode = head;
        //循环遍历到尾节点
        while (curNode != null) {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    /**
     * 链表尾插法
     */
    public ListNode insertNode(int data, ListNode head) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            return head;
        }
        ListNode curNode = head;
        //循环找到当前链表的尾节点
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        //尾节点的指针指向新增加的节点
        curNode.next = node;
        return head;
    }

    /**
     * 链表加法
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        // 定义临时变量，用以遍历，避免到了表尾
        ListNode cur = pre;
        int carry = 0;
        // 前面进行空判断，只要一方不空，即进行加法
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            // 商为进位值
            carry = sum / 10;
            // 余数为当前位数值
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNodeAdd nodeAdd = new ListNodeAdd();
        ListNode l1 = new ListNode(2);
        nodeAdd.insertNode(4, l1);
        nodeAdd.insertNode(3, l1);
        nodeAdd.printList(l1);
        nodeAdd.printList(nodeAdd.addTwoNumbers(l1, l1));
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

}

