import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    private HashMap<String, User> users = new HashMap<>();
    private HashMap<String, Set<String>> blocked = new HashMap<>();
    public void sendMessage(String sender, String recipient, String content) {
        if (!users.containsKey(recipient)) {
            System.out.println("Recipient not found.");
            return;
        }
        Set<String> blockedSenders = blocked.getOrDefault(recipient, new HashSet<>());
        if (blockedSenders.contains(sender)) {
            System.out.println(recipient + " blocked " + sender);
            return;
        }
        users.get(recipient).receiveMessage(new Message(sender, recipient, System.currentTimeMillis(), content));
    }
    public HashMap<String, Set<String>> getBlocked() {
        return blocked;
    }
    public void registerUser(User user) {
        users.put(user.getName(), user);
    }
}
