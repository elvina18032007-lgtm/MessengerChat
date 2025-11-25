import com.sun.source.tree.UsesTree;

public class DirectMessages {
    protected User sender; // мы
    protected User receiver;
    protected Message[] messages = new Message[100];

    public DirectMessages(User receiver, Message[] messages) {
        this.sender = Main.admin;
        this.receiver = receiver;
        for (int i = 0; i < messages.length; i++) {
            this.messages[i] = messages[i];
        }
    }

    public DirectMessages(User receiver) {
        this.sender = Main.admin;
        this.receiver = receiver;
    }

    public DirectMessages() {
    }

    public void printMessages() {
        System.out.println("--- " + receiver.colorName() + " ---");
        for (Message msg : messages) {
            if (msg == null) {
                break;
            }
            if (msg.getSender().getUserName().equals(sender.getUserName())) {
                System.out.println("Вы |" + msg.getDate() + "|:\n" + msg.getText());
            } else {
                System.out.println(msg.getSender().colorName() + " |" + msg.getDate() + "|:\n" + msg.getText());
            }
        }
    }

    public void sendMessage(String text, String date) {
        Message message = new Message(text, date, sender);
        for (int i = 0; i < messages.length; i++) {
            if (messages[i] == null) {
                messages[i] = message;
                break;
            }
        }
    }
    public String getReceiver(){
        return receiver.getUserName();
    }
}
