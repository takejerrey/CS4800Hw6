public class MessageMemento {
    private String content;
    private long timestamp;

    public MessageMemento(String content, long timestamp) {

        this.timestamp = timestamp;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
