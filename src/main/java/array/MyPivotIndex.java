package array;

import java.util.Arrays;

public class MyPivotIndex {
    /*
     暴力求解
     1、从第一个下标开始算，如果左边等于右边，则返回下标值
     */
    public static int pivotIndex(int[] nums) {
        int index = 0;
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            // 左边求和
            if (sumLeft(nums, i) == sumRight(nums, i)) {
                return i;
            }
        }
        return index;
    }

    /**
     * 根据数学公式优化
     *
     * @param nums
     * @return
     */
    public static int pivotIndexOpz(int[] nums) {
        // 计算出总数
        int sum = Arrays.stream(nums).sum();
        int subtotal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * subtotal + nums[i] == sum) {
                return i;
            }
            subtotal += nums[i];
        }
        return -1;
    }

    private static int sumRight(int[] nums, int i) {
        int rul = 0;
        for (int i1 = i + 1; i1 < nums.length; i1++) {
            rul += nums[i1];
        }
        return rul;
    }

    private static int sumLeft(int[] nums, int i) {
        int rul = 0;
        for (int i1 = 0; i1 < i; i1++) {
            rul += nums[i1];
        }
        return rul;
    }

    public static void main(String[] args) {
        int nums[] = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
        System.out.println(pivotIndexOpz(nums));
    }

}
