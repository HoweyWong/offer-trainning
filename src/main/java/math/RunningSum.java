package math;

import java.util.Arrays;

/**
 * 数组动态和
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/18 15:00
 */
public class RunningSum {
    private final static int HIGH = 1000;
    private final static int LOW = 1;

    /**
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,6,10]
     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4]
     * 时间复杂度：O(n);空间复杂度:O(n),多了个数组
     */
    public static int[] runningSum(int[] nums) {
        int length = nums.length;
        if (length < LOW || length > HIGH) {
            return null;
        }
        int[] result = new int[length];
        result[0] = nums[0];
        for (int i = 1; i < length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }

    /**
     * 优化代码，优化空间
     */
    public static int[] runningSumUpgrade(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        System.out.println(Arrays.toString(RunningSum.runningSum(ints)));
    }
}
