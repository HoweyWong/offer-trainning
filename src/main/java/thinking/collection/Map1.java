package thinking.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Map1
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/22 14:53
 */
public class Map1 {
    public static final String[][] testData1 = {{"Happy", "Cheerful disposition"}};
    public static final String[][] testData2 = {{"Lazy", "Motivational problems"}};

    public static Map fill(Map m, Object[][] o) {
        for (int i = 0; i < o.length; i++) {
            m.put(o[i][0], o[i][1]);
        }
        return m;
    }

    public static void printKeys(Map m) {
        System.out.print("Size():" + m.size() + ",");
        System.out.print("Keys:");
        Collection1.print(m.keySet());
    }

    public static void printValues(Map m) {
        System.out.print("Values:");
        Collection1.print(m.values());
    }

    public static void main(String[] args) {
        Map m = new HashMap();
        fill(m, testData1);
        printKeys(m);
        printValues(m);
    }
}
