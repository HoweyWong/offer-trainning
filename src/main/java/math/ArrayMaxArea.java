package math;

/**
 * @author huanghao
 * @version 1.0
 * @date 2022/6/27 15:55
 */
public class ArrayMaxArea {
    /**
     * 暴力双重循环
     */
    public static int maxArea(int[] height) {

        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {
                int i1 = Math.min(height[i], height[j]) * (j - i);
                area = i1 > area ? i1 : area;
            }
        }
        return area;


    }

    public static int maxArea2(int[] height) {
        int i = 0, j = height.length - 1, area = 0;
        while (i < j) {
            area = height[i] < height[j] ? Math.max(area, (j - i) * height[i++]) : Math.max(area, (j - i) * height[j--]);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(ArrayMaxArea.maxArea2(height));
    }
}
