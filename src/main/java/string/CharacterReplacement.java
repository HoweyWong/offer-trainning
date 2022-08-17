package string;

/**
 * 替换后的最长重复字符
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/30 15:48
 */
public class CharacterReplacement {
    /**
     * 输入：s = "ABAB", k = 2
     * 输出：4
     * 输入：s = "AABABBA", k = 1
     * 输出：4
     */
    static int characterReplacement(String s, int k) {
        int res = 0, tmp = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                tmp++;
            } else if (k > 0 && s.charAt(i) != s.charAt(i + 1)) {
                tmp++;
                k--;
            } else {
                if (tmp > res) {
                    res = tmp;
                    tmp = 0;
                }
            }
        }
        return 0;
    }

    public int characterReplacementOpz(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
