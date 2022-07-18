package thinking.array;

/**
 * 数组返回
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/18 17:24
 */
public class IceCream {
    static String[] flav = {
            "a", "b", "c", "d", "e", "f"
    };

    static String[] flavorSet(int n) {
        n = Math.abs(n) % (flav.length + 1);
        String[] results = new String[n];
        int[] picks = new int[n];
        for (int i = 0; i < picks.length; i++) {
            picks[i] = -i;
        }
        for (int i = 0; i < picks.length; i++) {
            retry:
            while (true) {
                int t = (int) (Math.random() * flav.length);
                for (int j = 0; j < i; j++) {
                    if (t == picks[j]) {
                        continue retry;
                    }
                }
                picks[i] = t;
                results[i] = flav[t];
                break;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println("flavorSet(" + i + ") = ");
            String[] f1 = flavorSet(flav.length);
            for (int j = 0; j < f1.length; j++) {
                System.out.println("\t" + f1[j]);
            }
        }
    }
}
