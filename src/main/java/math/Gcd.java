package math;

/**
 * 最大公约数
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/27 10:59
 */
public class Gcd {
    /**
     * 欧几里得算法
     */
    public static long gcd(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(gcd(12, 18));
    }
}
