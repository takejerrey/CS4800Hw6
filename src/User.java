import java.util.Iterator;

public class User implements Iterable {
    private String name;
    private ChatServer server;
    private ChatHistory chatHistory = new ChatHistory();

    public User(String name, ChatServer server) {
        this.name = name;
        this.server = server;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String recipient, String content) {
        server.sendMessage(this.name, recipient, content);
        chatHistory.addMessage(new Message(this.name, recipient, System.currentTimeMillis(), content));
    }

    public void receiveMessage(Message message) {
        chatHistory.addMessage(message);
        System.out.println("From " + message.getSender() + " to " + name + ": " + message.getContent());
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return chatHistory.iterator(userToSearchWith);
    }
}
