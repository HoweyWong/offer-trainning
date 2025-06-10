package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyFindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        // 初始化数组 26个小写字母
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        int pl = p.length();
        int sl = s.length();
        List<Integer> res = new ArrayList();
        // s小于p，则直接返回空
        if(sl<pl){
            return res;
        }
        // 先对p初始化，同时s遍历到p的长度，然后以p的长度滑动窗口
        for(int i = 0;i<pl;i++){
            sCount[s.charAt(i)-'a']++;
            pCount[p.charAt(i)-'a']++;
        }
        // 表示初始节点第一个位置就符合异位词
        if(Arrays.equals(sCount,pCount)){
            res.add(0);
        }
        // 从0的下一个位置继续滑动，左边减，右边加，一直滑动到尾端
        for(int i = 0;i<sl-pl;i++){
            sCount[s.charAt(i)-'a']--;
            sCount[s.charAt(i+pl)-'a']++;
            if(Arrays.equals(sCount,pCount)){
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // 获得下标
        int i = 'b' - 'a';
        System.out.println(i);
        System.out.println('b');
    }
}
