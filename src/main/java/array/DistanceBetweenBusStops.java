package array;

/**
 * 公交站距离
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离
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
