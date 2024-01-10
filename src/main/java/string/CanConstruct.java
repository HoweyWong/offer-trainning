package string;

import com.google.common.collect.Lists;

import java.util.List;

public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomNoteCharArray = ransomNote.toCharArray();
        List magazineList = Lists.newArrayList(magazine.toCharArray());
        for (char c : ransomNoteCharArray) {
            if (!magazineList.contains(c)) {
                return false;
            }
            magazineList.remove(c);
        }
        return true;
    }

    /*
    哈希表解决
     */
    public boolean canConstructHash(String ransomNote, String magazine) {
        // 长度不足，肯定无法匹配
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        // 26个字母计数
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if (cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
