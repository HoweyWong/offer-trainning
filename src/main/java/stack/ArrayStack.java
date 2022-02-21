package stack;

/**
 * @Description 数组实现栈，栈属于逻辑结构，先进后出FILO
 * @Author huanghao
 * @Date 2022-2-11
 * @Version 1.0
 */
public class ArrayStack {
    /**
     * 初始化数组
     */
    private int[] nums;
    /**
     * 作为栈的操作index
     */
    private int count;

    public ArrayStack(int n) {
        this.nums = new int[n];
        this.count = 0;
    }

    public int pop() {
        int result = 0;
        if (count > 0) {
            result = nums[count-1];
            count--;
        }
        return result;
    }

    /**
     * 简单实现，先push满
     */
    public boolean push(int value) {
        if (count > nums.length - 1) return false;
        nums[count] = value;
        count++;
        return true;
    }

    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(8);
        as.push(5);
        as.push(4);
        as.push(3);
        as.push(2);
        as.push(1);

        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
    }
}
