package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文串
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/22 13:47
 */
public class LongestPalindrome {
    /**
     * 输入:s = "abccccdd"
     * 输出:7 dccaccd
     * 奇数个数的字母只能有一个，奇数个数的得拿到最大的，偶数的可以任意加进去
     * 空间复杂度多了一个map
     */
    static int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> c = new HashMap<>();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (c.containsKey(chars[i])) {
                c.put(chars[i], c.get(chars[i]) + 1);
            } else {
                c.put(chars[i], 1);
            }
        }
        // 遍历hash表
        for (Integer value : c.values()) {
            result += value / 2 * 2;
            if (value % 2 == 1 && result % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    /**
     * 利用字符数组，出现了的就加1操作，统计各字符出现次数
     * 时间复杂度O(n)
     * 空间复杂度O(s)
     */
    static int longestPalindromeOpz(String s) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }
        int ans = 0;
        for (int value : count) {
            ans += value / 2 * 2;
            if (value % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeOpz("aaabb"));
    }
}
