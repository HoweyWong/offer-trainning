package design.pattern.strategy.javapattern;

/**
 * 关键是changeStrategy提供了一个动态传入策略，并更改为对应策略的方法
 *
 * @Author huanghao
 * @Date 2022-4-6
 * @Version 1.0
 */
public class DragonSlayer {
    private DragonSlayingStrategy strategy;

    public DragonSlayer(DragonSlayingStrategy strategy) {
        this.strategy = strategy;
    }

    public void changeStrategy(DragonSlayingStrategy strategy) {
        this.strategy = strategy;
    }

    public void goToBattle() {
        strategy.execute();
    }
}
