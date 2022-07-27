package method.greedy;

/**
 * @Description
 * @Author huanghao
 * @Date 2022-2-23
 * @Version 1.0
 */
public class BagDemo {
    /**
     * 背包容量
     */
    double bag;

    /**
     * 往包中放入
     */
    public void take(Goods[] goods) {
        for (int i = 0; i < goods.length; i++) {
            double val = goods[i].weight;
            // 容量足够
            if (bag > val) {
                System.out.println("从" + goods[i].name + "中放入背包中，重量为（kg）：" + goods[i].weight);
                bag -= val;
            } else {
                System.out.println("从" + goods[i].name + "中放入背包中，重量为（kg）：" + bag);
                // 取完退出循环
                return;
            }
        }
    }

    public static void main(String[] args) {
        Goods a = new Goods("A", 10, 60);
        Goods b = new Goods("B", 20, 100);
        Goods c = new Goods("C", 30, 120);
        Goods d = new Goods("D", 30, 120);
        Goods[] goods = {a, b, c, d};
        BagDemo bagDemo = new BagDemo();
        bagDemo.bag = 50;
        bagDemo.take(goods);
    }
}
