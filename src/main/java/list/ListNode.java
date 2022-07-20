package list;

/**
 * 链表节点
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/20 16:37
 */
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

    static void print(ListNode node) {
        System.out.print("null");
        while (node != null) {
            System.out.print("->" + node.val);
            node = node.next;
        }
        System.out.println();
    }

    static ListNode fill(int size) {
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        for (int i = 0; i < size; i++) {
            ListNode node = new ListNode(i);
            res.next = node;
            res = res.next;
        }
        return tmp.next;
    }
}
