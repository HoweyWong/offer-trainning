package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1460. 通过翻转子数组使两个数组相等
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/8/24 15:54
 */
public class CanBeEqual {
    /**
     * 转换为判断两数组的元素出现次数是否完全一致
     */
    static boolean canBeEqual(int[] target, int[] arr) {
        int[] tmp = new int[10];
        int[] tmp2 = new int[10];
        for (int i : target) {
            tmp[i]++;
        }
        for (int i : arr) {
            tmp2[i]++;
        }
        return Arrays.equals(tmp, tmp2);
    }

    static boolean canBeEqualApi(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

    static boolean canBeEqualMap(int[] target, int[] arr) {
        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();
        for (int i : target) {
            count1.put(i, count1.getOrDefault(i, 0) + 1);
        }
        for (int i : arr) {
            count2.put(i, count1.getOrDefault(i, 0) + 1);
        }
        if (count1.size() != count2.size()) {
            return false;
        }
        for (Integer value : count1.values()) {
            if (!count2.containsKey(value) || !count1.get(value).equals(count2.get(value))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{7}, new int[]{7}));
        System.out.println(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{4, 2, 1, 3}));
    }
}
