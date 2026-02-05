package BehaviouralPatterns.Mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ChatUser {
    private String name;
    private ChatMediator chatMediator;

    public ChatUser(String name) {
        this.name = name;
    }

    public void setChatMediator(ChatMediator mediator) {
        this.chatMediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String msg) {
        chatMediator.sendMessage(msg, this);
    }

    public void receiveMessage(String msg, ChatUser fromUser){
        System.out.println(this.name +  " Received Msg from " + fromUser.getName());
    }
}

interface ChatMediator {
    void sendMessage(String msg, ChatUser fromUser);
    void addUser(ChatUser user);
}

class ChatRoom implements ChatMediator {

    List<ChatUser> users = new ArrayList<>();

    public void addUser(ChatUser user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String msg, ChatUser fromUser) {
        for(var user: users){
            if(user != fromUser){
                user.receiveMessage(msg, fromUser);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        ChatUser alice = new ChatUser("Alice");
        alice.setChatMediator(chatRoom);
        ChatUser bob = new ChatUser("Bob");
        bob.setChatMediator(chatRoom);
        ChatUser charlie = new ChatUser("Charlie");
        charlie.setChatMediator(chatRoom);

        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);

        alice.sendMessage("Hello from Alice");
        System.out.println("\n");
        bob.sendMessage("Hello from Bob");
        System.out.println("\n");
        charlie.sendMessage("H frm C");
    }
}
