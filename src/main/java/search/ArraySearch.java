package search;

import java.util.HashSet;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-8-16
 * @Version 1.0
 */
public class ArraySearch {
    /**
     * 用repeatFlag标识有无重复值，有则返回该值，无则为-1
     * 利用set无重复性，当发生重复时，即找到
     */
    public int findRepeatNumber(int[] nums) {
        // 返回重复的值
        int repeatFlag = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                repeatFlag = num;
                return repeatFlag;
            }
        }
        return -1;
    }

    /**
     * 高效算法：利用索引下标，找到第一个重复值
     */
    public int findRepeatNumberEft(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // 值与下标相等
            if (nums[i] == i) {
                i++;
                continue;
            }
            // nums[i]当前值，所在的值已有，故重复
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            // 下标与值不等，交换
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    /**
     * 查找顺序数组中的target出现次数，二分查找
     */
    public int search(int[] nums, int target) {
        return findUpIndex(nums, target) - findUpIndex(nums, target - 1);
    }

    /**
     * 查找target出现的右边界
     */
    int findUpIndex(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    /**
     * 缺失的数
     */
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        // 缺失项为最后一项
        return nums.length;
    }

    public static void main(String[] args) {
        ArraySearch search = new ArraySearch();
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] b = {0, 1, 2, 4};
        int[] c = {1};
        System.out.println(search.missingNumber(a));
        System.out.println(search.missingNumberBin(a));
        System.out.println(search.missingNumberBin(b));
        System.out.println(search.missingNumberBin(c));
        int[][] d = {{0, 1}, {0, 1}, {0, 1}};
        System.out.println(d.length);
        System.out.println(d[0].length);
    }

    public int missingNumberBin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            } else if (num > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * 查找旋转数据的最小值[1,2,3,4,5]-->[2,3,4,5,1]
     */
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            // 如果中间数大于最右侧的值，说明最小值肯定在右侧，因为左侧的数组是递增的，最左侧值一定大于最右侧值
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                // 当中间值小于j，说明
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];
    }
}
