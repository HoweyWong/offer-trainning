package array;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 区间交集最小
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [starti, endi] 表示从 starti 到 endi 的所有整数，包括 starti 和 endi 。
 * 包含集合 是一个名为 nums 的数组，并满足 intervals 中的每个区间都 至少 有 两个 整数在 nums 中。
 * 例如，如果 intervals = [[1,3], [3,7], [8,9]] ，那么 [1,2,4,7,8,9] 和 [2,3,4,8,9] 都符合 包含集合 的定义。
 * 返回包含集合可能的最小大小。
 * @author huanghao
 * @version 1.0
 * @date 2022/7/22 9:41
 */
public class IntersectionSizeTwo {
    /**
     * m- n + 3
     * intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
     */
    static int intersectionSizeTwo(int[][] intervals) {
        int[] min = new int[intervals.length];
        int[] max = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            min[i] = intervals[i][0];
            max[i] = intervals[i][1];
        }
        int n = Arrays.stream(min).max().getAsInt();
        int m = Arrays.stream(max).min().getAsInt();
        return n - m + 3;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 4};
        OptionalInt max = Arrays.stream(a).max();
        System.out.println(max.getAsInt());
        int[][] intervals = {
                {1, 3}, {1, 4}, {2, 5}, {3, 5}
        };
        System.out.println(intersectionSizeTwo(intervals));
        int[][] b = {
                {1, 2}, {2, 3}, {2, 4}, {4, 5}
        };
        System.out.println(intersectionSizeTwo(b));
    }
}
