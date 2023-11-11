package design.pattern.decorator.beverage;

public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.90 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Whip";
    }
}
