package math;

/**
 * @author huanghao
 * @version 1.0
 * company: ANSO
 * copyright: Copyright (c) 2022
 * modified by:
 * @date 2023/12/29 13:02
 */
public class BuyChoco {
    /**
     * 1、一次遍历，如果比最小的小，则把最小的替换，把次小的用原最小替换；值小于次小的，则直接替换次小
     */
    public int buyChoco(int[] prices, int money) {
        int result = money;
        int fi = Integer.MAX_VALUE, se = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < fi) {
                se = fi;
                fi = price;
            } else if (price < se) {
                se = price;
            }
        }
        return result < fi + se ? result : result - fi - se;
    }
}
