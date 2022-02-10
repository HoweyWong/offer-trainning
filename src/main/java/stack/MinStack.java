package stack;

import java.util.Stack;

/**
 * @Description 辅助栈来，时间复杂度为O(1),空间复杂度O(N)
 * @Author huanghao
 * @Date 2021-8-13
 * @Version 1.0
 */
public class MinStack {
    /**
     * b作为辅助栈，保证栈顶是a最小值
     */
    Stack<Integer> a, b;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.push(x);
        // b为空，直接入栈；b栈顶的值大于等于x，也入栈顶
        if (b.isEmpty() || b.peek() >= x) {
            b.push(x);
        }
    }

    public void pop() {
        // 弹出栈顶元素，如果跟b栈顶相等为最小值，b也弹出，这里对应上面的相同最小值
        if (a.pop().equals(b.peek())) {
            b.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
