package StructuralPatterns.Decorator;

public class MushroomDecorator extends PizzaDecorator {

    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 5.00;
    }

    @Override
    public String getName() {
        return pizza.getName() + "Mushroom";
    }
}
