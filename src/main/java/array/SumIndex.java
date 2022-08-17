package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 利用hashMap在数组中找出和为target的两个数的下标
 * @Author huanghao
 * @Date 2021-8-13
 * @Version 1.0
 */
public class SumIndex {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 2};
        System.out.println(Arrays.toString(twoSum(arr, 5)));
    }

    /**
     * 前提是只有一种答案，假如是重复值的，除非是这两者就是答案，否则不会用上
     */
    public static int[] twoSum(int[] nums, int target) {
        // 数组的值作为map的key，Index作为value
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            // 如有重复值，利用map的key唯一性，覆盖掉
            map.put(nums[i], i);
        }
        // 返回空
        return new int[0];
    }
}
