package list;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-3-7
 * @Version 1.0
 */
public class RingList {
    public Boolean isRing(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
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
        Node node1 = new Node(1, "张三");
        Node node2 = new Node(2, "李四");
        Node node3 = new Node(3, "王五");
        Node node4 = new Node(4, "张三");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
        RingList ringList = new RingList();
        System.out.println(ringList.isRing(node1));
    }
}

class Node {
    int id;
    String name;
    Node next;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }
}