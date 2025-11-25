import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] masUsers = new User[3];
        for (int i = 0; i < 3; i++) {
            User user = new User(scanner.nextLine());
            masUsers[i] = user;
        }
        Message message = new Message("приветики", "вчера", masUsers[0]);
        Group group1 = new Group("УРА", new Message[]{message});
        group1.sendMessage("прив", "сегодня", masUsers[1]);
        group1.printMessages();
    }
}
