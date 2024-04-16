import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchMessage implements Iterator<Message> {
    private Iterator<Message> iterator;
    private Message nextMessage;
    private User userToSearchWith;

    @Override
    public Message next() {
        if (nextMessage == null) {
            throw new NoSuchElementException("Error.");
        }
        Message result = nextMessage;
        goNext();
        return result;
    }
    public SearchMessage(User userToSearchWith, List<Message> messages) {
        this.userToSearchWith = userToSearchWith;
        this.iterator = messages.iterator();
        goNext();
    }
    @Override
    public boolean hasNext() {
        return !(nextMessage == null);
    }

    private void goNext() {
        nextMessage = null;
        while (iterator.hasNext()) {
            Message current = iterator.next();
            String sender = current.getSender();
            String recipient = current.getRecipient();
            String targetUserName = userToSearchWith.getName();

            boolean isSender = sender.equals(targetUserName);
            boolean isRecipient = recipient.equals(targetUserName);

            if (isSender || isRecipient) {
                nextMessage = current;
                break;
            }
        }
    }

}
