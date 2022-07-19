package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 我的日程安排表 II（不可三重预定）
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/19 9:50
 */
public class MyCalendarTwo {
    static List<int[]> books = new ArrayList<>();
    static Map<Integer, Integer> bookTimes = new HashMap<>();

    /**
     * 预定
     * MyCalendar.book(10, 20); // returns true
     * MyCalendar.book(50, 60); // returns true
     * MyCalendar.book(10, 40); // returns true
     * MyCalendar.book(5, 15); // returns false
     * MyCalendar.book(5, 10); // returns true
     * MyCalendar.book(25, 55); // returns true
     */
    static boolean book(int start, int end) {
        int size = books.size();
        // 判断区间，是否有重复预订，作交集
        if (books.size() != 0) {
            for (int i = 0; i < size; i++) {
                int[] book = books.get(i);
                // 落在区间
                if (!(start >= book[1] || end <= book[0])) {
                    Integer times = bookTimes.get(i);
                    if (times == 2) {
                        return false;
                    }
                    times++;
                    bookTimes.put(i, times);
                }
            }
        }
        books.add(new int[]{start, end});
        bookTimes.put(size, 1);
        return true;
    }

    List<int[]> booked;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book2(int start, int end) {
        // 遍历2重预订列表
        for (int[] arr : overlaps) {
            int l = arr[0], r = arr[1];
            if (l < end && r > start) {
                return false;
            }
        }
        // 遍历所有预订列表
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            // 筛选出二重预订日程
            if (l < end && r > start) {
                // 取出交集部分区间
                overlaps.add(new int[]{Math.max(l, start), Math.min(r, end)});
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        /**
         * 预定
         * MyCalendar.book(10, 20); // returns true
         * MyCalendar.book(50, 60); // returns true
         * MyCalendar.book(10, 40); // returns true
         * MyCalendar.book(5, 15); // returns false
         * MyCalendar.book(5, 10); // returns true
         * MyCalendar.book(25, 55); // returns true
         * [47,50],[1,10],[27,36],[40,47],[20,27],[15,23],[10,18],[27,36],[17,25],[8,17]
         */
        System.out.println(book(47, 50));
        System.out.println(book(1, 10));
        System.out.println(book(27, 36));
        System.out.println(book(40, 47));
        System.out.println(book(20, 27));
        System.out.println(book(15, 23));
        System.out.println(book(10, 18));
        System.out.println(book(27, 36));
        System.out.println(book(17, 25));
        System.out.println(book(8, 17));
    }
}
