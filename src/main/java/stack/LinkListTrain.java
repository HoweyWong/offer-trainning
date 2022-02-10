package stack;

import queue.CQueueByStack;

import java.util.LinkedList;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-8-13
 * @Version 1.0
 */
public class LinkListTrain {
    public static void main(String[] args) {
        LinkedList<Integer> aList = new LinkedList<>();
        aList.addFirst(1);
        aList.addLast(2);
        System.out.println(aList);
        CQueueByStack queue = new CQueueByStack();
        queue.appendTail(3);
        queue.appendTail(1);
        queue.deleteHead();
        System.out.println(queue);
        queue.deleteHead();
        System.out.println(queue);
    }
}
