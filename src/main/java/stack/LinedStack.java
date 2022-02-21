package stack;

/**
 * @Description 链表实现栈，先进后出
 * @Author huanghao
 * @Date 2022-2-11
 * @Version 1.0
 */
public class LinedStack {
    /**
     * 头节点，下一个节点往前指
     */
    Node head;
    /**
     * 作为栈的大小
     */
    int size;

    public LinedStack() {
        this.head = null;
        this.size = 0;
    }

    public boolean push(Node node) {
        if (head == null) {
            head = node;
        } else {
            // 指向前一个节点
            node.next = head;
            head = node;
        }
        size++;
        return true;
    }

    public Node pop() {
        if (size > 0) {
            // 把需要返回的数据先存起来
            Node oldHead = head;
            // head指向下一个，则是前移
            head = head.next;
            size--;
            return oldHead;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        LinedStack ls = new LinedStack();
        ls.push(new Node(1));
        ls.push(new Node(2));
        ls.push(new Node(3));
        ls.push(new Node(4));
        ls.push(new Node(5));

        System.out.println(ls.pop().value);
        System.out.println(ls.pop().value);
        System.out.println(ls.pop().value);
        System.out.println(ls.pop().value);
        System.out.println(ls.pop().value);
    }
}

/**
 * 链表结构，包含数据域，以及指向下个节点的指针
 */
class Node {
    Node next;
    int value;

    public Node(int value) {
        this.value = value;
    }
}
