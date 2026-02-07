package StructuralPatterns.Facade;

public class Main {
    public static void main(String[] args) {
//        Now instead of the client calling each 3 service n do something, we will call the orchestrator api service here

        APIGateway apiGateway = new APIGateway();
        apiGateway.getFullOrderDetails();
    }
}
