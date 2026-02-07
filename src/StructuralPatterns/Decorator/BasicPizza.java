package StructuralPatterns.Decorator;

public class BasicPizza implements Pizza{
    @Override
    public double getPrice() {
        return 5.00;
    }

    @Override
    public String getName() {
        return "Basic Pizza";
    }
}
