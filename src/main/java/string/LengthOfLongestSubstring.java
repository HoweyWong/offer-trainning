package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    static Set<Character> existCharSet;
    public int lengthOfLongestSubstring(String s){
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int charLength = chars.length;
        existCharSet = new HashSet<>(charLength);
        maxLength = getLength(chars,charLength, maxLength,0);
        return maxLength;
    }

    private static int getLength(char[] chars,int charLength, int maxLength,int offset) {
        if (charLength-offset<=maxLength){
            return maxLength;
        }
        int length = 0;
        for (int i = offset; i < charLength; i++) {
            char c=chars[i];
            if (existCharSet.contains(c)){
                offset = i;
                existCharSet.clear();
                break;
            }
            length++;
            existCharSet.add(c);
        }
        maxLength = Math.max(length, maxLength);
        maxLength = getLength(chars,charLength,maxLength,offset);
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "pwwkew";
        LengthOfLongestSubstring longestSubstring = new LengthOfLongestSubstring();
        int length = longestSubstring.lengthOfLongestSubstring(input);
        System.out.println(input+" lengthOfLongestSubstring is:"+length);
    }
}
