package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyFindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        // 初始化数组 26个小写字母
        int[] sCounts = new int[26];
        int[] pCounts = new int[26];
        // s小于p，则直接返回空
        if (s.length()<p.length()){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        // 先对p初始化，同时s遍历到p的长度，然后以p的长度滑动窗口
        for (int i = 0; i < p.length(); i++) {
            ++sCounts[s.charAt(i)-'a'];
            ++pCounts[p.charAt(i)-'a'];
        }
        // 表示初始节点第一个位置就符合异位词
        if (Arrays.equals(pCounts,sCounts)){
            result.add(0);
        }
        // 从0的下一个位置继续滑动，左边减，右边加，一直滑动到尾端
        for (int i = 0; i < s.length()-p.length(); i++) {
            --sCounts[s.charAt(i)-'a'];
            ++sCounts[s.charAt(i+p.length())-'a'];
            if (Arrays.equals(pCounts,sCounts)){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 获得下标
        int i = 'b' - 'a';
        System.out.println(i);
        System.out.println('b');
    }
}
