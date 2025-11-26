public class Group {
    protected String name;
    protected Message[] messages = new Message[100];
    public User[] members;

    public Group(String name, Message[] messages, User[] members) {
        for (int i = 0; i < messages.length; i++) {
            this.messages[i] = messages[i];
        }
        this.name = name;
        this.members = members;
    }

    public Group() {
        this.name = "Новая группа";
        this.members = new User[]{Main.admin};
    }

    public void printMessages() {
        System.out.println("----- " + name + " -----");
        for (Message msg : messages) {
            if (msg == null) {
                break;
            }
            if (msg.getSender().getUserName().equals(Main.admin.getUserName())) {
                System.out.println(Main.admin.codeAdmin() + "Вы" + "\u001B[0m" +  " |" + msg.getDate() + "|:\n" + msg.getText());
            }
            else System.out.println(msg.getSender().colorName() + " |" + msg.getDate() + "|:\n" + msg.getText());
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

