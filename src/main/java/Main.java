import java.util.Scanner;

/*
Стейси
Джейкоб
Боб
Аманда
Нил
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Создайте пять различных пользователей: ");
        User[] masUsers = new User[5];
        for (int i = 0; i < 5; i++) {
            User user = new User(scanner.nextLine());
            masUsers[i] = user;
        }
        System.out.println("Выберете ваш аккаунт:");
        User.toPrintUsers(masUsers);
        User admin = new User(scanner.nextLine());
        menu();
        User[] users = User.getUsers(masUsers, admin);
        String action = scanner.nextLine(); //тип ввод операции, которую хочет совершить админ
        while (!action.equals("Exit")) {
            //КАК ЕЁ ЗАЦИКЛИТЬ??? типо оно должно работать пока админ не введет Exit, но крч у меня все ломается и мне лень думать  ТТ_ТТ

        /*Message message = new Message("приветики", "вчера", masUsers[0]);
        Group group1 = new Group("УРА", new Message[]{message});
        group1.sendMessage("прив", "сегодня", masUsers[1]);
        group1.printMessages();*/
            if (action.equals("Зайти на канал")) {
                System.out.println("Выбери чей канал хочешь посетить: ");
                User.toPrintUsers(users);
                System.out.println(admin.codeAdmin(masUsers, admin) + "Мой канал" + "\u001B[0m");
                User choice = new User(scanner.nextLine());
                Channel.posts(choice, admin, masUsers, "");
            }
            if (action.equals("Сделать новый пост")) {
                System.out.println("Введите новый пост:");
                String post = scanner.nextLine();
                Channel.posts(new User("Мой канал"), admin, masUsers, post);
            }
            menu();
            action = scanner.nextLine();
        }
    }

    public static void menu() {
        System.out.println("""
                Вам доступны следующие операции:\s
                \u25CF Написать сообщение\s
                \u25CF Прочитать сообщения
                \u25CF Зайти на канал\s
                \u25CF Сделать новый пост\s
                \u25CF Exit
                """);
    }
}
