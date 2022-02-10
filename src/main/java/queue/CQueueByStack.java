package queue;

import java.util.LinkedList;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-8-13
 * @Version 1.0
 */
public class CQueueByStack {
    LinkedList<Integer> A, B;

    public CQueueByStack() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if (!B.isEmpty()) {
            return B.removeLast();
        }
        if (A.isEmpty()) {
            return -1;
        }
        while (!A.isEmpty()) {
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
