import java.util.Iterator;

public interface Iterable {
    Iterator<Message> iterator(User userToSearchWith);
}

