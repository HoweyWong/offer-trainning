package thinking.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set2
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/20 14:31
 */
public class Set2 {
    static Set fill(Set a, int size) {
        for (int i = 0; i < size; i++) {
            a.add(new MyType(i));
        }
        return a;
    }

    static Set fill(Set a) {
        return fill(a, 10);
    }

    static void test(Set a) {
        fill(a);
        fill(a);
        fill(a);
        a.addAll(fill(new TreeSet()));
        System.out.println(a);
    }

    public static void main(String[] args) {
        test(new HashSet());
        test(new TreeSet());
    }
}

class MyType implements Comparable {
    private int i;

    public MyType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MyType && ((MyType) obj).i == i;
    }

    @Override
    public int hashCode() {
        return i;
    }

    @Override
    public String toString() {
        return "MyType{" +
                "i=" + i +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int i2 = ((MyType) o).i;
        return i2 < i ? -1 : (i2 == i ? 0 : 1);
    }
}
