public class Message {
    private String recipient;
    private String sender;
    private String content;
    private long timestamp;

    public Message(String sender, String recipient, long timestamp, String content) {
        this.content = content;
        this.timestamp = timestamp;
        this.recipient = recipient;
        this.sender = sender;

    }
    public String getSender() {
        return sender;
    }
    public String getRecipient() {
        return recipient;
    }
    public String getContent() {
        return content;
    }
}
