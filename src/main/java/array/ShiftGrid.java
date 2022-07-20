package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二维网格迁移
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/20 15:21
 */
public class ShiftGrid {
    /**
     * 位于 grid[i][j]的元素将会移动到grid[i][j + 1]。
     * 位于grid[i][n- 1] 的元素将会移动到grid[i + 1][0]。
     * 位于 grid[m- 1][n - 1]的元素将会移动到grid[0][0]。
     * <p>
     * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
     * 输出：[[9,1,2],[3,4,5],[6,7,8]]
     */
    static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            grid = shift(grid);
        }
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
            List<int[]> rows = Arrays.asList(grid[i]);
        }
        return null;
    }

    static List<List<Integer>> shiftGridOpz(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
        // 数组扁平化
        for (int i = 0; i < row; i++) {
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                rows.add(grid[i][j]);
            }
            result.add(rows);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int index = (i * col + j + k) % (row * col);
                result.get(index / col).set(index % col, grid[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        shiftGrid(grid, 1);
        System.out.println(shiftGridOpz(grid, 1));
        System.out.println(shiftGridOpz(grid, 2));
    }

    private static int[][] shift(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 位于 grid[m- 1][n - 1]的元素将会移动到grid[0][0]
                if (i == row - 1 && j == col - 1) {
                    result[0][0] = grid[i][j];
                    continue;
                }
                // 位于grid[i][n- 1] 的元素将会移动到grid[i + 1][0]
                if (j == col - 1) {
                    result[i + 1][0] = grid[i][j];
                    continue;
                }
                result[i][j + 1] = grid[i][j];
            }
        }
        return result;
    }
}
