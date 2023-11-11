package design.pattern.strategy.duck;

/**
 * @author huanghao
 * @version 1.0
 * company: ANSO
 * copyright: Copyright (c) 2022
 * modified by:
 * @date 2023/11/8 17:05
 */
public abstract class Duck {

    QuackBehavior quackBehavior;

    FlyBehavior flyBehavior;

    public Duck() {
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void swim() {
        System.out.println("All ducks float,even decoys!");
    }

    public void performQuackBehavior() {
        quackBehavior.quack();
    }

    public void performFlyBehavior() {
        flyBehavior.fly();
    }

    /**
     * 外形
     *
     * @author huanghao
     * @date 2023/11/8 17:15
     */
    public abstract void display();
}
