package design.strategy;

/**
 * @Description
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
