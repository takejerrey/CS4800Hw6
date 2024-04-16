import java.util.*;

public class Main {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        User bruce = new User("Bruce Willis", server);
        User katy = new User("Katy Perry", server);
        User miranda = new User("Miranda Cosgrove", server);

        server.registerUser(bruce);
        server.registerUser(katy);
        server.registerUser(miranda);

        bruce.sendMessage("Katy Perry", "Kickflips n stuff?");
        katy.sendMessage("Miranda Cosgrove", "Wanna kickflip with Bruce Willis?");
        miranda.sendMessage("Bruce Willis", "I wanna kickflip with u and Katy!");

        bruce.sendMessage("Katy Perry", "message 1");
        bruce.sendMessage("Katy Perry", "message 2");

        Set<String> blockedByKaty = new HashSet<>();
        blockedByKaty.add("Miranda Cosgrove");
        server.getBlocked().put("Katy Perry", blockedByKaty);
        System.out.println("before block ");
        miranda.sendMessage("Katy Perry", "If you see this, it no work :(");
        System.out.println("after block ");

        System.out.println("Searching for 'message 1' in Katy's messages:");
        Iterator<Message> it = katy.getChatHistory().iterator(katy);
        while (it.hasNext()) {
            Message message = it.next();
            if ("message 1".equals(message.getContent())) {
                System.out.println("Found 'message 1': From " + message.getSender() + " to " + message.getRecipient());
            }
        }
    }
}
