package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *      双指针，滑动窗口优化，减少了循环次数，更清晰
 */
public class LengthOfLongestSubstringOpz {
    public int lengthOfLongestSubstring(String s){
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int charLength = chars.length;
        Set<Character> existCharSet = new HashSet<>(charLength);
        int rt = 0;
        for (int i = 0; i < charLength; i++) {
            char c=chars[i];
            while (rt<charLength&&!existCharSet.contains(chars[rt])){
                existCharSet.add(chars[rt]);
                rt++;
            }
            existCharSet.remove(c);
            maxLength = Math.max(maxLength, rt-i);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        String input = "abcabcbb";
        LengthOfLongestSubstringOpz longestSubstring = new LengthOfLongestSubstringOpz();
        int length = longestSubstring.lengthOfLongestSubstring(input);
        System.out.println(input+" lengthOfLongestSubstring is:"+length);
    }
}
