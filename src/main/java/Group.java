public class Group {
    protected String name;
    protected Message[] messages = new Message[100];

    public Group(String name, Message[] messages) {
        for (int i = 0; i < messages.length; i++) {
            this.messages[i] = messages[i];
        }
        this.name = name;
    }

    public Group() {
        this.name = "Новая группа";
    }

    public void printMessages() {
        System.out.println("----- " + name + " -----");
        for (Message msg : messages) {
            if (msg == null) {
                break;
            }
            System.out.println(msg.getSender().colorName() + " |" + msg.getDate() + "|:\n" + msg.getText());
        }
    }

    public void sendMessage(String text, String date, User sender) {
        Message message = new Message(text, date, sender);
        for (int i = 0; i < messages.length; i++) {
            if (messages[i] == null) {
                messages[i] = message;
                break;
            }
        }
    }
    public String getName(){
        return name;
    }

    public static void printGroups(Group[] groups) {
        for (int i = 0; i < groups.length; i++) {
            System.out.println(groups[i].getName());
        }
    }
}

