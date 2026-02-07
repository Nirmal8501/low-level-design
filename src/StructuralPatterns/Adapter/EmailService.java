package StructuralPatterns.Adapter;

public class EmailService implements NotificationService {
    @Override
    public void send(String to, String subject, String body) {
        System.out.println("Sending email to " + to + "\nWith subject " + subject + "\nWith body " + body);
    }
}
