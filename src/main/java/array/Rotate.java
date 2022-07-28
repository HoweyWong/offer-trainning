package array;

import java.util.Arrays;

/**
 * 数组轮转
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/28 15:15
 */
public class Rotate {
    static int[] rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = (i + k) % nums.length;
            res[j] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }
}
