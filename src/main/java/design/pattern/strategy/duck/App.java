package design.pattern.strategy.duck;

/**
 * @author huanghao
 * @version 1.0
 * company: ANSO
 * copyright: Copyright (c) 2022
 * modified by:
 * @date 2023/11/8 17:27
 */
public class App {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        System.out.println(">>>>>>修改行为前：");
        mallardDuck.performFlyBehavior();
        mallardDuck.performQuackBehavior();
        mallardDuck.setFlyBehavior(new FlyNoWay());
        mallardDuck.setQuackBehavior(new MuteQuack());
        System.out.println(">>>>>>修改行为后：");
        mallardDuck.performFlyBehavior();
        mallardDuck.performQuackBehavior();
    }
}
