package StructuralPatterns.Decorator;

public abstract class PizzaDecorator implements Pizza{
    protected Pizza pizza;

    protected PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public abstract double getPrice() ;

    @Override
    public abstract String getName();
}
