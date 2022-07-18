package math;

import java.util.Arrays;

/**
 * 数组中心坐标
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/18 15:18
 */
public class PivotIndex {
    /**
     * 输入：nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 暴力求解
     */
    public static int pivotIndex(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (sumArray(nums, i) == sumArrayRight(nums, i)) {
                return i;
            }
        }
        return -1;
    }

    public static int sumArray(int[] nums, int index) {
        int result = 0;
        for (int i = 0; i < index; i++) {
            result += nums[i];
        }
        return result;
    }

    public static int sumArrayRight(int[] nums, int index) {
        int result = 0;
        for (int i = index + 1; i < nums.length; i++) {
            result += nums[i];
        }
        return result;
    }

    /**
     * 利用数学公式优化
     * sum(l)+nums[i]+sum(r)=total
     * sum=sum(l)=sum(r)
     * 2sum+nums[i]=total
     */
    public static int pivotIndexOpz(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
        System.out.println(pivotIndexOpz(nums));
    }
}
