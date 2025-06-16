package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        boolean[][] visit = new boolean[x][y];
        // 1) 频次剪枝
        int[] cntBoard = new int[128], cntWord = new int[128];
        for (char[] row : board) for (char c : row) cntBoard[c]++;
        for (char c : word.toCharArray()) {
            if (++cntWord[c] > cntBoard[c]) return false; // 不够用
        }

        // 2) 选“稀有端”作为起点
        boolean fromHead = cntBoard[word.charAt(0)] <= cntBoard[word.charAt(word.length() - 1)];
        String w = fromHead ? word : new StringBuilder(word).reverse().toString();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == w.charAt(0) && dfs(board, i, j, x, y, visit, w, 0)) {
                    // 找到任意一条符合的路径
                    return true;
                }
            }
        }
        return false;
    }

    // 深度遍历
    private boolean dfs(char[][] board, int i, int j, int x, int y, boolean[][] visit
            , String word, int index) {
        // 边界判断，是否访问过，遍历字符串的游标
        if (i < 0 || i >= x || j < 0 || j >= y || index >= word.length() || visit[i][j]) {
            return false;
        }
        // 当前字符不匹配字符，退出当前路径
        if (board[i][j] != word.charAt(index)) return false;
        // 找到一条路径符合，返回成功，遍历到最后一个字符
        if (index == word.length() - 1) return true;
        visit[i][j] = true;
        boolean tmp = dfs(board, i - 1, j, x, y, visit, word, index + 1) ||
                dfs(board, i + 1, j, x, y, visit, word, index + 1) ||
                dfs(board, i, j - 1, x, y, visit, word, index + 1) ||
                dfs(board, i, j + 1, x, y, visit, word, index + 1);
        visit[i][j] = false;
        return tmp;
    }

    // 广度遍历
    private boolean bfs(char[][] board, int i, int j, int x, int y, boolean[][] visit
            , String word, int index) {
        Queue<int[]> bQueue = new LinkedList<>();
        bQueue.offer(new int[]{i, j});
        while (!bQueue.isEmpty()) {
            // 边界判断，是否访问过，遍历字符串的游标
            if (i < 0 || i >= x || j < 0 || j >= y || index >= word.length() || visit[i][j]) {
                return false;
            }
            // 当前字符不匹配字符，退出当前路径
            if (board[i][j] != word.charAt(index)) return false;
            // 找到一条路径符合，返回成功，遍历到最后一个字符
            if (index == word.length() - 1) return true;
            visit[i][j] = true;
            bQueue.offer(new int[]{i + 1, j});
            bQueue.offer(new int[]{i - 1, j});
            bQueue.offer(new int[]{i, j + 1});
            bQueue.offer(new int[]{i, j - 1});
        }
        return false;
    }
}
