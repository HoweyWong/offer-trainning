package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 上色
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
