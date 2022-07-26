package array;

import java.util.Arrays;

/**
 * 图像渲染、图的遍历、二维数组
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/26 12:32
 */
public class FloodFillTest {
    public static void main(String[] args) {
        FloodFill fill = new FloodFill();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        fill.floodFill(image, 2, 2, 2);
        for (int i = 0; i < image.length; i++) {
            String s = Arrays.toString(image[i]);
            System.out.println(s);
        }
    }
}
