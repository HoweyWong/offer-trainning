package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词 滑动窗口，哈希表
 * 字符转化为字符数组，字符组成的异同，通过字符数组的字符出现次数比较实现
 * aba对应的数组为[2,1,0,0,..]
 * aab对应的数组也为[2,1,0,0,..]所以aba和aab两者是异位词
 * abb对应数组为[1,2,0,0,...]
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/29 13:46
 */
public class FindAnagrams {
    /**
     * s = "cbaebabacd", p = "abc" [0,6]
     */
    static List<Integer> findAnagrams(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        if (sl < pl) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (int i = 0; i < pl; i++) {
            ++sArr[s.charAt(i) - 'a'];
            ++pArr[p.charAt(i) - 'a'];
        }
        // s和p长度相同
        if (Arrays.equals(sArr, pArr)) {
            ans.add(0);
        }
        for (int i = 0; i < sl - pl; i++) {
            // 窗口后移一位，前面的重置
            --sArr[s.charAt(i) - 'a'];
            ++sArr[s.charAt(i + pl) - 'a'];
            if (Arrays.equals(sArr, pArr)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
