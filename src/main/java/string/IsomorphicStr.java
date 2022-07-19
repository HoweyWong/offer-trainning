package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/19 15:14
 */
public class IsomorphicStr {
    /**
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * s = "egg", t = "add" true,类似成语的abb格式，aabb，aabc
     */
    static boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Character> tmp = new HashMap<>(20);
        Map<Character, Character> tmp2 = new HashMap<>(20);
        for (int i = 0; i < sChars.length; i++) {
            if ((tmp.containsKey(sChars[i]) && tmp.get(sChars[i]) != tChars[i]) || (tmp2.containsKey(tChars[i]) && tmp2.get(tChars[i]) != sChars[i])) {
                return false;
            }
            tmp.put(sChars[i], tChars[i]);
            tmp2.put(tChars[i], sChars[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("add", "egg"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }
}
