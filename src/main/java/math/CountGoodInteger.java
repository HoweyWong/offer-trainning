package math;

import java.util.Arrays;

/**
 * 好整数统计：num1<x<num2
 * min_num<digit_sum(x)<max_num
 *
 * @author huanghao
 * @version 1.0
 * company: ANSO
 * copyright: Copyright (c) 2022
 * modified by:
 * @date 2024/1/16 12:39
 */
public class CountGoodInteger {
    public int count(String num1, String num2, int min_sum, int max_sum) {
        Integer begin = Integer.valueOf(num1);
        Integer end = Integer.valueOf(num2);
        int result = 0;
        for (int i = begin; i < end + 1; i++) {
            char[] chars = Integer.valueOf(i).toString().toCharArray();
            int digitSum = 0;
            for (char c : chars) {
                digitSum += c - 48;
            }
            if (digitSum >= min_sum && digitSum <= max_sum) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountGoodInteger count = new CountGoodInteger();
        int result = count.count("1", "5", 1, 5);
        System.out.println(result);
    }

    static final int N = 23;
    static final int M = 401;
    static final int MOD = 1000000007;
    int[][] d;
    String num;
    int min_sum;
    int max_sum;

    public int countDfs(String num1, String num2, int min_sum, int max_sum) {
        d = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(d[i], -1);
        }
        this.min_sum = min_sum;
        this.max_sum = max_sum;
        return (get(num2) - get(sub(num1)) + MOD) % MOD;
    }

    public int get(String num) {
        this.num = new StringBuffer(num).reverse().toString();
        return dfs(num.length() - 1, 0, true);
    }

    /**
     * 求解 num - 1，先把最后一个非 0 字符减去 1，再把后面的 0 字符变为 9
     */
    public String sub(String num) {
        char[] arr = num.toCharArray();
        int i = arr.length - 1;
        while (arr[i] == '0') {
            i--;
        }
        arr[i]--;
        i++;
        while (i < arr.length) {
            arr[i] = '9';
            i++;
        }
        return new String(arr);
    }

    public int dfs(int i, int j, boolean limit) {
        if (j > max_sum) {
            return 0;
        }
        if (i == -1) {
            return j >= min_sum ? 1 : 0;
        }
        if (!limit && d[i][j] != -1) {
            return d[i][j];
        }
        int res = 0;
        int up = limit ? num.charAt(i) - '0' : 9;
        for (int x = 0; x <= up; x++) {
            res = (res + dfs(i - 1, j + x, limit && x == up)) % MOD;
        }
        if (!limit) {
            d[i][j] = res;
        }
        return res;
    }
}
