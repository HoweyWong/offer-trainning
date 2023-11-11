package design.pattern.decorator.beverage;

public class StarbuzzCoffeeApp {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
        Beverage houseBlend = new HouseBlend();
        // add 2 mocha ,1 whip
        houseBlend = new Whip(new Mocha(new Mocha(houseBlend)));
        System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());
    }
}
