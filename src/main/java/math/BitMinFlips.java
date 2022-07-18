package math;

/**
 * 最少翻转使得或运算 a|b=c
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/18 15:59
 */
public class BitMinFlips {
    /**
     * 对abc三数分别取最低位，逐次完成；
     * 取最低位只要与1做&运算即可
     * 对于需要反转的情况：a|b!=c
     * 有两种情况：
     * 1 c=1，则a,b都为0，此时只需要反转一次
     * 2 c=0,此时a,b都需要为0，谁为1都需要反转，故直接相加
     */
    public static int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            int aBit = a & 1, bBit = b & 1, cBit = c & 1;
            if ((aBit | bBit) != cBit) {
                if (cBit == 1) {
                    flips++;
                } else {
                    flips += aBit + bBit;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flips;
    }

    public static void main(String[] args) {
        System.out.println(minFlips(2, 6, 5));
    }
}
