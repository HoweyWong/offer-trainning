package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 */
public class MyNumIslands {
    static int[][] directions = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    public int numIslands(char[][] grid) {
        if (grid == null && grid.length == 0) {
            return 0;
        }
        int xl = grid.length;
        int yl = grid[0].length;
        int num = 0;
        boolean[][] visit = new boolean[xl][yl];
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    num++;
                    bfs(grid, i, j, xl, yl, visit);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j, int xl, int yl, boolean[][] visit) {
        if (i < 0 || j < 0 || i >= xl || j >= yl || visit[i][j] || grid[i][j] == '0') {
            return;
        }
        visit[i][j] = true;
        dfs(grid, i - 1, j, xl, yl, visit);
        dfs(grid, i + 1, j, xl, yl, visit);
        dfs(grid, i, j - 1, xl, yl, visit);
        dfs(grid, i, j + 1, xl, yl, visit);
    }

    private void bfs(char[][] grid, int i, int j, int xl, int yl, boolean[][] visit) {
        // 坐标点作为元素
        Queue<int[]> lQueue = new LinkedList<>();
        lQueue.offer(new int[]{i, j});
        visit[i][j] = true;
        while (!lQueue.isEmpty()) {
            int[] cur = lQueue.poll();
            // 每一点的四个方向为一层 4*n节点
            for (int[] direction : directions) {
                int xi = cur[0] + direction[0];
                int yj = cur[1] + direction[1];
                if (xi >= 0 && yj >= 0 && xi < xl && yj < yl && !visit[xi][yj] && grid[xi][yj] == '1') {
                    lQueue.offer(new int[]{xi, yj});
                    visit[xi][yj] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyNumIslands nums = new MyNumIslands();
        char[][] grid = {
                {'1', '0', '1', '0'},
                {'0', '0', '0', '0'},
                {'1', '1', '0', '1'},
                {'0', '0', '1', '0'}
        };
        System.out.println("Number is:" + nums.numIslands(grid));
    }
}
