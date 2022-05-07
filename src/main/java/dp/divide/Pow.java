package dp.divide;

/**
 * @Description 某数的N次幂，分治法
 * @Author huanghao
 * @Date 2022-3-7
 * @Version 1.0
 */
public class Pow {
    public int pow(int x, int n) {
        // 递归结束条件
        if (n == 1) {
            return x;
        }
        // 对指数折半递归
        int half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.pow(2, 10));
    }
}
