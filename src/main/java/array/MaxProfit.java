package array;

/**
 * 双重循环实现，双指针，股票最大利润
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/22 11:33
 */
public class MaxProfit {
    /**
     * 双重循环实现，双指针,复杂度o（n*n）
     */
    static int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // 买入价格大于当天价格，跳出，为亏损状态
                if (prices[i] > prices[j]) {
                    continue;
                }
                int tmp = result;
                // 利润大于之前的，替换掉
                if (tmp < prices[j] - prices[i]) {
                    result = prices[j] - prices[i];
                }
            }
        }
        return result;
    }

    /**
     * 动态规划，找到临界值，递推公式，时间复杂度O(n),空间复杂度O(1),常数个变量
     */
    static int maxProfitDp(int[] prices) {
        // 边界
        int[] dp = new int[prices.length];
        // 第一天交易利润为0
        dp[0] = 0;
        // 递推公式 dp[i] = max(dp[i-1],prices[i]-cost);
        // 初始成本为第一天买入价格
        int cost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - cost);
            cost = Math.min(prices[i], cost);
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
