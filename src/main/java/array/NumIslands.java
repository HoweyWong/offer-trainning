package array;

/**
 * 岛屿数量，图遍历、深度、广度
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/26 14:09
 */
public class NumIslands {
    int[][] border = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    /**
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * 1是陆地，0是海水
     */
    public int numIslands(char[][] grid) {
        //找到第一个陆地
        int x = grid.length, y = grid[0].length;
        int res = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    grid[i][j] = '2';
                    gridDfs(grid, x, y, i, j);
                }
            }
        }
        return res;
    }

    private void gridDfs(char[][] grid, int x, int y, int i, int j) {
        for (int k = 0; k < border.length; k++) {
            int nx = i + border[k][0], ny = j + border[k][1];
            if (nx >= 0 && nx < x && ny >= 0 && ny < y) {
                if (grid[nx][ny] == '1') {
                    grid[nx][ny] = '2';
                    gridDfs(grid, x, y, nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        NumIslands islands = new NumIslands();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(islands.numIslands(grid));
    }
}
