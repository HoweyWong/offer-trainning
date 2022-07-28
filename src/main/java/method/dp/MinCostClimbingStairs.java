package method.dp;

/**
 * 使用最小花费爬楼梯，每一次爬1、2阶梯，到顶花销最小
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/28 10:27
 */
public class MinCostClimbingStairs {
    /**
     * cost = [10,15,20] out:15
     * cost = [1,100,1,1,1,100,1,1,100,1] out :6
     * 解法1：两种情况，要么最后一步走2级台阶，要么走一级台阶 故f(n) = min{(f(n-1)+cost[i]),(f(n-2)+cost[i-1])}
     * 找到边界值：f(0)=0;f(1)=min(cost[0],cost[1])，然后根据状态方程递推，并把重复值优化掉
     */
    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i - 1]);
        }
        return dp[n - 1];
    }

    /**
     * 优化解法1，对空间进行优化
     */
    static int minCostClimbingStairsOpzSpace(int[] cost) {
        int a = 0;
        int b = Math.min(cost[0], cost[1]);
        int tmp = 0;
        for (int i = 2; i < cost.length; i++) {
            tmp = Math.min(b + cost[i], a + cost[i - 1]);
            a = b;
            b = tmp;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairsOpzSpace(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairsOpzSpace(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
