package thinking.collection;

import java.util.List;

/**
 * List工具类
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/19 18:41
 */
public class List1 {
    /**
     * 调用collection1的fill方法创建
     */
    public static List fill(List a) {
        return (List) Collection1.fill(a);
    }

    public static void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
