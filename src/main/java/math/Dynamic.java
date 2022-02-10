package math;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-9-1
 * @Version 1.0
 */
public class Dynamic {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        // n=0 直接返回a
        // n=1 返回b
        for (int i = 0; i < n; i++) {
            // sum等于两者相加
            sum = (a + b) % 1000000007;
            // 后挪一位
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 青蛙跳台阶，每次跳1，2两种。从底往上推演
     */
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            // sum等于两者相加
            sum = (a + b) % 1000000007;
            // 后挪一位
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 买卖一次的最大利润，暴力法
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    continue;
                }
                int tmp = result;
                if (tmp < prices[j] - prices[i]) {
                    result = prices[j] - prices[i];
                }
            }
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            // 没有卖出的可能性
            return 0;
        }
        // 定义状态，第i天卖出的最大收益
        int[] dp = new int[prices.length];
        // 初始边界
        dp[0] = 0;
        // 成本
        int cost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - cost);
            // 选择较小的成本买入
            cost = Math.min(cost, prices[i]);
        }

        return dp[prices.length - 1];
    }

    public int maxProfit3(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    /**
     * 最大子数组之和nums = [-2,1,-3,4,-1,2,1,-5,4] [4,-1,2,1] out:6
     * 动态规划：找出关系公式
     */
    public int maxSubArray(int[] nums) {

        return 0;
    }
}
