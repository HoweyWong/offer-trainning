package method.dp;

/**
 * 不同路径
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/28 14:20
 */
public class UniquePaths {
    /**
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
     * 组合类的题目，应该等于各种情况的累加 f(m,n) = f(m-1,n)+f(m,n-1)
     */
    static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }
}
