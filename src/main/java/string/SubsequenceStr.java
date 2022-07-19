package string;

/**
 * 判断子序列
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/19 16:27
 */
public class SubsequenceStr {
    /**
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     */
    static boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
