import java.util.Objects;
import java.util.Scanner;

/*
Стейси
Джейкоб
Боб
Аманда
Нил
 */
public class Main {
    public static User[] masUsers = new User[5];
    public static Group[] groups = new Group[2];
    public static User admin = new User();
    public static User[] users = new User[masUsers.length - 1];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // создание пользователей
        System.out.println("Создайте пять различных пользователей: ");
        for (int i = 0; i < 5; i++) {
            User user = new User(scanner.nextLine());
            masUsers[i] = user;
        }
        // выбор от чьего лица пишем и создание списка остальных
        System.out.println("Выберете ваш аккаунт:");
        User.toPrintUsers(masUsers);
        admin = new User(scanner.nextLine());
        users = User.getUsers(masUsers, admin);

        // создание групп
        Message[] messages = new Message[]{new Message("приветики", "вчера", masUsers[0]),
                new Message("привееет", "вчера", masUsers[2]),
                new Message("хеллоу", "сегодня", masUsers[1]),
                new Message("как дела?", "сегодня", masUsers[1])};
        Group group1 = new Group("УРА", messages);
        Group group2 = new Group();
        groups[0] = group1;
        groups[1] = group2;

        // запуск программы
        menu();
        String action = scanner.nextLine(); //тип ввод операции, которую хочет совершить админ

        while (!action.equals("Exit")) {
            if (action.equals("Зайти на канал")) {
                enterTheChannel();
            } else if (action.equals("Сделать новый пост")) {
                makeNewPost();
            } else if (action.equals("Написать сообщение")) {
                writeAMessage();
            } else {
                System.out.println("Некорректный ввод команды");
            }
            menu();
            action = scanner.nextLine();
        }
    }

    public static void enterTheChannel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбери чей канал хочешь посетить: ");
        User.toPrintUsers(users);
        System.out.println(admin.codeAdmin(masUsers, admin) + "Мой канал" + "\u001B[0m");
        User choice = new User(scanner.nextLine());
        Channel.posts(choice, admin, masUsers, "");
    }

    public static void makeNewPost() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новый пост:");
        String post = scanner.nextLine();
        Channel.posts(new User("Мой канал"), admin, masUsers, post);
    }

    public static void writeAMessage() {
        Scanner scanner = new Scanner(System.in);
        ;
        System.out.println("Выбери, куда написать: \"личные сообщения\" или \"группы\"");
        String toWhere = scanner.nextLine();
        if (toWhere.equals("личные сообщения")) {
            System.out.println("Выбери кому написать:");
            User.toPrintUsers(masUsers);
            String chat = scanner.nextLine();
            System.out.println();
        } else if (toWhere.equals("группы")) {
            System.out.println("Выбери группу:");
            Group.printGroups(groups);
            String chat = scanner.nextLine();
            for (Group group : groups) {
                if (group.getName().equals(chat)) {
                    group.printMessages();
                    System.out.println("Введите сообщение...");
                    group.sendMessage(scanner.nextLine(), "сегодня", admin);
                    group.printMessages();
                    break;
                }
            }
        } else System.out.println("Некорректный ввод");
    }

    public static void menu() {
        System.out.println("""
                \nВам доступны следующие операции:\s
                \u25CF Написать сообщение\s
                \u25CF Прочитать сообщения
                \u25CF Зайти на канал\s
                \u25CF Сделать новый пост\s
                \u25CF Exit
                """);
    }
}
