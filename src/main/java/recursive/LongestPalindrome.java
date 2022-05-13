package recursive;

/**
 * 最长回文子串 一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/5/13 15:23
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            }
        }
        return "bab";
    }

    public static void main(String[] args) {
        System.out.println(LongestPalindrome.longestPalindrome("babad"));
    }
}
