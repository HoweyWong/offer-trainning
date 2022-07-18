package thinking.array;

import java.util.Arrays;

/**
 * 数组练习
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/18 16:39
 */
public class ArraySize {
    public static void main(String[] args) {
        // arrays of object
        // null handle 空指针
        // 编译错误 a not initialize
        // System.out.println(a.length);
        Weeble[] a;
        // 空指针,里面有5个null，length是5
        Weeble[] b = new Weeble[5];
        System.out.println("b.length = " + b.length);
        System.out.println("b数组内的元素依次是：" + Arrays.toString(b));
        // 正确初始化 c,d
        Weeble[] c = new Weeble[4];
        for (int i = 0; i < c.length; i++) {
            c[i] = new Weeble();
        }
        System.out.println("c.length = " + c.length);
        Weeble[] d = {
                new Weeble(), new Weeble(), new Weeble()
        };
        System.out.println("d.length = " + d.length);
        a = d;
        System.out.println("a.length = " + a.length);
        a = new Weeble[]{
                new Weeble(), new Weeble()
        };
        System.out.println("a.length = " + a.length);
        System.out.println("a数组内的元素依次是：" + Arrays.toString(a));

        // 基础类型
        int[] e;
        int[] f = new int[5];
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }
        int[] h = {11, 17, 49};
        System.out.println("f.length = " + f.length);
        System.out.println("f包含的元素依次是：" + Arrays.toString(f));
    }
}

class Weeble {
}
