package algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-9-28
 * @Version 1.0
 */
public class FibSolution {

    /**
     * 递归解法 01 复杂度计算
     * 子问题复杂度*子问题个数
     * 子问题复杂度：2的层数次幂，每一层都是2的倍数 2^n
     */
    public int fib01(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib01(n - 1) + fib01(n - 2);
    }

    /**
     * 自底向上，利用数组，以空间交换时间
     */
    public int fibArrayDp(int n) {
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }

    Map<Integer, Integer> temp = new HashMap<>();

    /**
     * 已计算过的值存在map中，那么只要计算过的就都只会计算一次，递归时只会计算n个值，空间复杂度就是O（n）
     * 这个是自顶向下的解法
     * 递归+记忆搜索
     */
    public int fib02(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        if (temp.containsKey(n)) {
            return temp.get(n);
        } else {
            // 计算过的值存放起来
            temp.put(n, (fib02(n - 1) + fib02(n - 2)) % 1000000007);
            return temp.get(n);
        }
    }

    /**
     * 斐波那契数列 F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 动态规划有几个典型特征，最优子结构、状态转移方程、边界、重叠子问题,它是自底向上的。即如下：
     * f(n-1)和f(n-2) 称为 f(n) 的最优子结构
     * f(n)= f（n-1）+f（n-2）就称为状态转移方程
     * f(1) = 1, f(2) = 2 就是边界啦
     * 比如f(10)= f(9)+f(8),f(9) = f(8) + f(7) ,f(8)就是重叠子问题
     * 跟第二种带备忘录的区别：map要存放整个所有节点，而动态规划只需要存放前两个值，a,b，空间复杂度是O(1)
     * 逐层计算，计算到第n层即可返回结果
     */
    public int fib(int n) {
        if (n==1){
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        /*if (n == 4) {
            return 2;
        }*/
        int a = 0;
        int b = 1;
        int temp = 0;
        // 从边界值开始计算，到n层停止，返回值
        for (int i = 3; i <= n; i++) {
            temp = (a + b) % 1000000007;
            // 两个变量逐层往后计算
            a = b;
            b = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        FibSolution fib = new FibSolution();
        System.out.println(fib.fib(9));
    }
}
