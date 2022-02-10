package math;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-12-3
 * @Version 1.0
 */
public class DivideInt {
    /**
     * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%'
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
     */
    /**
     * 减法代替除法
     */
    public static int divide(int a, int b) {
        // 考虑负数，异或运算，相同为0，不同为1
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        int result = 0;
        a = Math.abs(a);
        b = Math.abs(b);
        while (a >= b) {
            result++;
            a -= b;
        }
        return sign == 1 ? result : -result;
    }

    /**
     * 减法代替除法,优化边界值，时间复杂度为O(n)，当a为n时，b=1，则需要减n次；转为负数处理，则不会越界
     * 环境只支持存储 32 位整数，否则还可以转为long来存储
     */
    public static int divide02(int a, int b) {
        // 考虑负数，异或运算，相同为0，不同为1
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int result = 0;
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }
        while (a <= b) {
            result++;
            a -= b;
        }
        return sign == 1 ? result : -result;
    }

    /**
     * 减法代替除法,优化减法的方式，每次减去被除数的倍数；复杂度：logn*logn,每次成倍，并且每次是减少一半，所以相乘
     */
    public static int divide03(int a, int b) {
        // 考虑负数，异或运算，相同为0，不同为1
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int result = 0;
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }
        while (a <= b) {
            int value = b, k = 1;
            while (value >= 0xc0000000 && a <= value + value) {
                value += value;
                k += k;
            }
            result += k;
            // 对剩余无法减的数据继续进行减
            a -= value;
        }
        return sign == 1 ? result : -result;
    }

    /**
     * 位运算
     */
    public static int divide04(int a, int b) {
        // 考虑负数，异或运算，相同为0，不同为1
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int result = 0;
        a = Math.abs(a);
        b = Math.abs(b);
        for (int i = 31; i >= 0; i--) {
            // 右移解决左移的越界问题
            // 无符号右移解决最小值问题负数
            // 比较改为相减，解决b最小的问题
            if ((a >>> i) - b >= 0) {
                a -= (b << i);
                result += 1 << i;
            }
        }
        return sign == 1 ? result : -result;
    }

    public static void main(String[] args) {

        System.out.println(DivideInt.divide04(10, 3));
    }
}
