package StructuralPatterns.Adapter;

public class ClientGridService {
    public void sendGrid(String to, String subject, String body) {
        System.out.println("Sending email to " + to + "\nWith subject " + subject + "\nWith body " + body);
    }
}
