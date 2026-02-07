package StructuralPatterns.Facade;

public class APIGateway {
    private UserService userService;
    private OrderService orderService;
    private PaymentService paymentService;

    public APIGateway(){
        userService = new UserService();
        orderService = new OrderService();
        paymentService = new PaymentService();
    }

    public void getFullOrderDetails(){
        userService.getUserDetails();
        orderService.getOrderDetails();
        paymentService.getPaymentDetails();
    }
}
