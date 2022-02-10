package string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-8-15
 * @Version 1.0
 */
public class StringTrain {
    /**
     * 替换空格
     */
    public String replaceSpace(String s) {
        int length = s.length();
        // 新建数组存放处理后的字符串字符，如果是空格，替换为‘%20’，需要3个字符，故乘以3
        char[] arr = new char[length * 3];
        // 字符数组的下标
        int size = 0;
        // 遍历字符串
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                // ++后自增
                arr[size++] = '%';
                arr[size++] = '2';
                arr[size++] = '0';
            } else {
                arr[size++] = c;
            }
        }

        return new String(arr, 0, size);
    }

    /**
     * 左旋转字符串
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    /**
     * 第一个只出现一次的字符，入参只有小写字符，另一种是用有序hash实现，不需要遍历两次数组
     */
    public char firstUniqChar(String s) {
        // String转为char数组，利用hash，如果重复则排除
        char[] chars = s.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char c : chars) {
            // 以字符作为key，按顺序放入，如有重复的为false值，单一个的value都是true
            map.put(c, !map.containsKey(c));
        }
        for (char c : chars) {
            // 按顺序第二次遍历字符数组，找到第一个value为true的字符，返回
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    public char firstUniqCharUsingLinkedHashMap(String s) {
        char[] chars = s.toCharArray();
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
        // 此处无需遍历数组，遍历map
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
//        Stream.builder(chars) 流式编程针对的是集合类，不是数组
        return ' ';
    }

    public static void main(String[] args) {
        StringTrain stringTrain = new StringTrain();
        System.out.println(stringTrain.replaceSpace("We are happy!"));
        System.out.println(stringTrain.reverseLeftWords("abcdefg", 2));
    }
}
