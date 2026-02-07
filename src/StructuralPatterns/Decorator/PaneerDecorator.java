package StructuralPatterns.Decorator;

public class PaneerDecorator extends PizzaDecorator {

    protected PaneerDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 10;
    }

    @Override
    public String getName() {
        return pizza.getName() + "Paneer";
    }
}
