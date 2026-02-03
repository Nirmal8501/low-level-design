package BehaviouralPatterns.Strategy;

public class PaymentService {
    private PaymentStrategy paymentStrategy;  // Or additionally u can have a list of allowedPaymentStrategies and so on

    public PaymentService(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(){
        paymentStrategy.processPayment();
    }
}
