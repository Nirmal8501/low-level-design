package BehaviouralPatterns.Strategy;

public class CreditCard implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Paying via credit card");
    }
}
