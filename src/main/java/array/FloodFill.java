package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 上色
 * 有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。你也被给予三个整数 sr ,  sc 和 color 。你应该从像素 image[sr][sc] 开始对图像进行上色 填充 。
 * 为了完成 上色工作：
 * 从初始像素开始，将其颜色改为 color。
 * 对初始坐标的 上下左右四个方向上 相邻且与初始像素的原始颜色同色的像素点执行相同操作。
 * 通过检查与初始像素的原始颜色相同的相邻像素并修改其颜色来继续 重复 此过程。
 * 当 没有 其它原始颜色的相邻像素时 停止 操作。
 * 最后返回经过上色渲染 修改 后的图像 。
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/26 10:46
 */
public class FloodFill {
    /**
     * 二维数组的上下左右计算坐标
     */
    int[][] border = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    /**
     * 深度优先遍历dfs，时间复杂度、空间复杂度都是n*m
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // 把与目标color相同的一整块区域标记为新的color
        int curColor = image[sr][sc];
        if (curColor != color) {
            dfs(image, sr, sc, curColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int x, int y, int curColor, int newColor) {
        if (image[x][y] == curColor) {
            image[x][y] = newColor;
            for (int i = 0; i < border.length; i++) {
                // 获得四个方向的相邻点
                int nx = x + border[i][0], ny = y + border[i][1];
                if (nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length) {
                    // 递归深度遍历
                    dfs(image, nx, ny, curColor, newColor);
                }
            }
        }
    }

    /**
     * 广度优先遍历bfs
     */
    public int[][] floodFillBfs(int[][] image, int sr, int sc, int color) {
        int curColor = image[sr][sc];
        if (curColor != color) {
            int n = image.length;
            int m = image[0].length;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{sr, sc});
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                image[x][y] = color;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && image[nx][ny] == curColor) {
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return image;
    }
}
