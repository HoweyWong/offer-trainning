package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-12-29
 * @Version 1.0
 */
public class WeightPick {
    public static void main(String[] args) {
        Random random = new Random();
        /*for (int i = 0; i < 20; i++) {
            System.out.println(random.nextInt(10));
        }*/
        List<Integer> weight = Arrays.asList(2, 3, 5);
        for (int i = 0; i < 10; i++) {
            System.out.println(random(weight));
        }
    }

    /**
     * 权重随机数
     *
     * @param weight [15,568,4181,2]
     * @return 索引值
     */
    public static int random(List<Integer> weight) {
        List<Integer> weightTmp = new ArrayList<>(weight.size() + 1);
        weightTmp.add(0);
        Integer sum = 0;
        for (Integer d : weight) {
            sum += d;
            weightTmp.add(sum);
        }
        Random random = new Random();
        int rand = random.nextInt(sum);
        int index = 0;
        for (int i = weightTmp.size() - 1; i > 0; i--) {
            if (rand >= weightTmp.get(i)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
