package math;

/**
 * 2的次幂判断，递归
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/22 15:56
 */
public class PowerOfTwo {
    static boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(8 % 2);
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(0));
    }
}
