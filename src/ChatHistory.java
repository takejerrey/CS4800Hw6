import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements Iterable {
    private List<Message> messages = new ArrayList<>();

    public void addMessage(Message message) {
        messages.add(message);
    }
    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        Iterator<Message> message = new SearchMessage(userToSearchWith, messages);
        return message;
    }
}
