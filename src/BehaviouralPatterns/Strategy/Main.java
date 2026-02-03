package BehaviouralPatterns.Strategy;

public class Main {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCard();
        PaymentStrategy upi = new UPI();

        PaymentService paymentService = new PaymentService(creditCard);
        paymentService.processPayment();

        paymentService.setPaymentStrategy(upi);
        paymentService.processPayment();
    }
}
