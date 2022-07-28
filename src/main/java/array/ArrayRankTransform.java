package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组序号转换，排序+哈希表
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/28 14:57
 */
public class ArrayRankTransform {
    static int[] arrayRankTransform(int[] arr) {
        // 拷贝一个数组
        int[] tmp = new int[arr.length];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        // 排序数组
        Arrays.sort(tmp);
        Map<Integer, Integer> num = new HashMap<>();
        // 把数组的值作为key，序号作为value
        for (int i : tmp) {
            if (!num.containsKey(i)) {
                num.put(i, num.size() + 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = num.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{40, 10, 20, 30})));
    }
}
