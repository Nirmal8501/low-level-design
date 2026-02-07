package StructuralPatterns.Adapter;

public class SendGridAdapter implements NotificationService{

    private ClientGridService clientGridService;

    public SendGridAdapter(ClientGridService clientGridService) {
        this.clientGridService = clientGridService;
    }

    @Override
    public void send(String to, String subject, String body) {
        clientGridService.sendGrid(to, subject, body);
    }
}
