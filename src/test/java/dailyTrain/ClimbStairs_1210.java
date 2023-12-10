package dailyTrain;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs_1210 {
    private Map<Integer, Integer> result = new HashMap<>();

    public int climbStairs(int n) {
        if (n < 1 || n > 45) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (!result.containsKey(n)) {
            result.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }
        return result.get(n);
    }

    public static void main(String[] args) {
        ClimbStairs_1210 a = new ClimbStairs_1210();
        int i = a.climbStairs(5);
        System.out.println(i);
    }
}
