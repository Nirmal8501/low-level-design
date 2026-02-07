package StructuralPatterns.Adapter;

public class Main {
    public static void main(String[] args) {
        NotificationService emailService = new EmailService();
        emailService.send("NJ", "NO Subject", "No Body");

        ClientGridService clientGridService = new ClientGridService();
        SendGridAdapter sendGridAdapter = new SendGridAdapter(clientGridService);

        sendGridAdapter.send("NJ", "NO Subject", "No Body");
    }
}
