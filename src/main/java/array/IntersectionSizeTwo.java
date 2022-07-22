package array;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 区间交集最小
 *
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
