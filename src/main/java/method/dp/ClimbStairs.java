package method.dp;

/**
 * 爬楼梯 动态规划
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/27 10:30
 */
public class ClimbStairs {
    /**
     * 对爬楼梯的数据进行计算，总结规律，获得动态方程
     * f(1) = 1;
     * f(2) = 2;
     * f(3) = 3;
     * f(4) = 5;
     * f(5) = 8;
     * 正好是前两项之和，符合斐波那契数列规律
     */
    public int climbStairs(int n) {
        int p = 0, q = 1;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp = p + q;
            p = q;
            q = tmp;
        }
        return tmp;
    }

    public static void main(String[] args) {
        ClimbStairs c = new ClimbStairs();
        System.out.println(c.climbStairs(4));
    }
}
