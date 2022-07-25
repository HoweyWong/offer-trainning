package array;

/**
 * 公交站距离
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/25 15:05
 */
public class DistanceBetweenBusStops {
    static int distanceBetweenBusStops(int[] distance, int start, int dest) {
        int sum = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
        }
        int begin = start, end = dest;
        if (start > dest) {
            begin = dest;
            end = start;
        }
        int des = 0;
        for (int i = begin; i < end; i++) {
            des += distance[i];
        }
        return des < sum - des ? des : sum - des;
    }

    static int distanceBetweenBusStopsOpz(int[] distance, int start, int dest) {
        if (start > dest) {
            int temp = start;
            start = dest;
            dest = temp;
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < dest) {
                sum1 += distance[i];
            } else {
                sum2 += distance[i];
            }
        }
        return Math.min(sum1, sum2);
    }

    public static void main(String[] args) {
        System.out.println(distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
        System.out.println(distanceBetweenBusStopsOpz(new int[]{1, 2, 3, 4}, 0, 1));
    }
}
