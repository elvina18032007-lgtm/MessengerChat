public class Message {
    protected String text;
    protected String date;
//    protected User sender;
//    protected User receiver;
//
//    public Message(){
//        this.text = "";
//        this.date = "";
//        this.sender = new User();
//        this.receiver = new User();
//    }
//
//    public Message(String text, String date, User sender, User receiver) {
//        this.text = text;
//        this.date = date;
//        this.sender = sender;
//        this.receiver = receiver;
//    }
//
//    public Message(String text, String date, User sender) {
//        this.text = text;
//        this.date = date;
//        this.sender = sender;
//    }

//    public String toString(){
//        return sender + " |" + date + "|" + ":\n" + text;
//    }

    public String getText() {
        return text;
    }
}
