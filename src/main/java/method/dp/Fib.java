package method.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/27 9:28
 */
public class Fib {
    Map<Integer, Integer> tmp = new HashMap<>();

    /**
     * 简单递归，其中fib有很多次重复调用
     */
    public int fib(int n) {
        if (n > 1) {
            return fib(n - 1) + fib(n - 2);
        } else if (n == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 简单递归，用
     */
    public int fibOpzWithHash(int n) {
        if (tmp.containsKey(n)) {
            return tmp.get(n);
        }
        if (n > 1) {
            tmp.put(n, fibOpzWithHash(n - 1) + fibOpzWithHash(n - 2));
            return tmp.get(n);
        } else if (n == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 利用数组，自底向上保存变量，减小复杂度
     */
    public int fibOpzArray(int n) {
        int[] tmp = new int[n + 1];
        tmp[0] = 0;
        tmp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            tmp[i] = tmp[i - 1] + tmp[i - 2];
        }
        return tmp[n];
    }

    public int fibOpzDp(int n) {
        int a = 0, b = 1, tmp;
        if (n < 2) {
            return n;
        }
        for (int i = 2; i < n; i++) {
            tmp = a;
            a = b;
            b = tmp + b;
        }
        return a + b;
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        long l1 = System.currentTimeMillis();
        System.out.println(fib.fib(32));
        long l2 = System.currentTimeMillis();
        System.out.println("cost:" + (l2 - l1));
        long l3 = System.currentTimeMillis();
        System.out.println(fib.fibOpzWithHash(32));
        long l4 = System.currentTimeMillis();
        System.out.println("cost:" + (l4 - l3));
        System.out.println(fib.fibOpzArray(8));

        long l5 = System.currentTimeMillis();
        System.out.println(fib.fibOpzDp(32));
        long l6 = System.currentTimeMillis();
        System.out.println("cost:" + (l6 - l5));
    }
}
