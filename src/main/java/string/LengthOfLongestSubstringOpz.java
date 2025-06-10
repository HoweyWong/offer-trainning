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
    /**
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     */
    public int lengthOfLongestSubstring(String s){
        int sl = s.length();
        int maxL = 0 , rt = 0;
        // 重复判断
        Set<Character> existChars = new HashSet<>();
        for(int i = 0;i < sl; i++){
            // i，rt双指针滑动
            while(rt<sl && !existChars.contains(s.charAt(rt))){
                existChars.add(s.charAt(rt));
                rt++;
            }
            // 获得最大长度
            maxL = Math.max(maxL,rt-i);
            existChars.remove(s.charAt(i));
        }
        return maxL;
    }


    public static void main(String[] args) {
        String input = "abcabcbb";
        LengthOfLongestSubstringOpz longestSubstring = new LengthOfLongestSubstringOpz();
        int length = longestSubstring.lengthOfLongestSubstring(input);
        System.out.println(input+" lengthOfLongestSubstring is:"+length);
    }
}
