package queue;

import java.util.Stack;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-8-13
 * @Version 1.0
 */
public class CQueue {
    /**
     * 两个栈，一个出栈，一个入栈
     */
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    /**
     * 1倒入2，实现倒序
     */
    public int deleteHead() {
        // 删除头，等于队列出，栈2有值，则不需要下面的处理
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            // 栈2已空，需从栈1中倒入
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            // 返回值，经过上述处理栈2为空则-1，否则弹出栈顶元素
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}
