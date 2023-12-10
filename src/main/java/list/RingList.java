package list;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-3-7
 * @Version 1.0
 */
public class RingList {
    public Boolean isRing(SimpleNode head) {
        if (head == null) {
            return false;
        }
        SimpleNode slow = head;
        SimpleNode fast = head;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            // 慢指针步长1
            slow = slow.next;
            // 快指针步长2
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SimpleNode node1 = new SimpleNode(1, "张三");
        SimpleNode node2 = new SimpleNode(2, "李四");
        SimpleNode node3 = new SimpleNode(3, "王五");
        SimpleNode node4 = new SimpleNode(4, "张三");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
        RingList ringList = new RingList();
        System.out.println(ringList.isRing(node1));
    }
}

