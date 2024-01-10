package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 栈计算最小的字符串
 *
 * @author huanghao
 * @version 1.0
 * company: ANSO
 * copyright: Copyright (c) 2022
 * modified by:
 * @date 2024/1/10 12:43
 */
public class MinLengthStrWithStack {
    public int minLength(String s) {
        // 用list模拟栈
        List<Character> stack = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stack.add(chars[i]);
            int m = stack.size();
            if (m >= 2 && ((stack.get(m - 2) == 'A' && stack.get(m - 1) == 'B')
                    || (stack.get(m - 2) == 'C' && stack.get(m - 1) == 'D'))) {
                // 先移除后面的，否则会越界
                stack.remove(m - 1);
                stack.remove(m - 2);
            }
        }
        return stack.size();
    }
}
