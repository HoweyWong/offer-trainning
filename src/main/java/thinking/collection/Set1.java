package thinking.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set1
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/20 14:24
 */
public class Set1 {
    static void testVisual(Set a) {
        Collection1.fill(a);
        Collection1.fill(a);
        Collection1.fill(a);
        Collection1.print(a);
        a.addAll(a);
        a.add("one");
        a.add("one");
        a.add("one");
        Collection1.print(a);
        System.out.println(a.contains("one"));
    }

    public static void main(String[] args) {
        testVisual(new HashSet());
        testVisual(new TreeSet());
    }
}
