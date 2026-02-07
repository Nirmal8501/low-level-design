package StructuralPatterns.Decorator;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new PaneerDecorator(new MushroomDecorator(new BasicPizza()));
        System.out.println(pizza.getName());
        System.out.println(pizza.getPrice());

//        or

        Pizza pizza2 = new BasicPizza();
        pizza2 = new MushroomDecorator(pizza2);
        pizza2 = new PaneerDecorator(pizza2);
        System.out.println(pizza2.getName());
        System.out.println(pizza2.getPrice());
    }
}
