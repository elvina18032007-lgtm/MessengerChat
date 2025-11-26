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
    public static DirectMessages[] dms = new DirectMessages[users.length];
    public static Channel[] allChannels; // каналы всех пользователей

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // создание пользователей
        System.out.println("Создайте пять различных пользователей:");
        for (int i = 0; i < masUsers.length; i++) {
            User user = new User(scanner.nextLine());
            masUsers[i] = user;
        }
        // выбор от чьего лица пишем и создание списка остальных
        System.out.println("Выберете ваш аккаунт:");
        User.toPrintUsers(masUsers);
        admin = new User(scanner.nextLine());
        users = User.getUsers(masUsers, admin);

        //создание личных чатов
        for (int i = 0; i < users.length; i++) {
            DirectMessages dm = new DirectMessages(users[i]);
            dms[i] = dm;
        }
        Message[] chat1Messages = new Message[]{new Message("приветики", "вчера", users[0]),
                new Message("привееет", "вчера", admin),
                new Message("как дела?", "вчера", users[0]),
                new Message("ээм.. что за игнор", "сегодня", users[0])};
        DirectMessages chat1 = new DirectMessages(users[0], chat1Messages);
        dms[0] = chat1;

        // создание групп
        Message[] messages = new Message[]{new Message("приветики", "вчера", masUsers[0]),
                new Message("привееет", "вчера", masUsers[2]),
                new Message("хеллоу", "сегодня", masUsers[1]),
                new Message("как дела?", "сегодня", masUsers[1])};
        Group group1 = new Group("УРА", messages, masUsers);
        Group group2 = new Group();
        groups[0] = group1;
        groups[1] = group2;

        // запуск программы
        menu();
        //User[] users = User.getUsers(masUsers, admin);
        // Создаём каналы для всех пользователей
        allChannels = new Channel[masUsers.length];
        for (int i = 0; i < masUsers.length; i++) {
            allChannels[i] = new Channel(masUsers[i]);
        }

        //Добавляем начальные посты
        int adminIndex = findUserIndex(admin, masUsers);
        int ind0 = findUserIndex(users[0], masUsers);
        int ind1 = findUserIndex(users[1], masUsers);
        int ind2 = findUserIndex(users[2], masUsers);
        int ind3 = findUserIndex(users[3], masUsers);

        // Канал admin
        if (adminIndex != -1) {
            allChannels[adminIndex].addPost(
                    "Канал: \u001B[38;2;184;134;11mстыд и позор\u001B[0m admin: " + admin.codeAdmin(masUsers,admin) + "Вы" + "\u001B[0m" + " followers: 4\n" +
                            "--------------------19 ноября 2025--------------------\n" +
                            "Блин такая классная кафешка открылась около моего дома. Оч вкусно!"
            );
            allChannels[adminIndex].addPost(
                    "--------------------20 ноября 2025--------------------\n" +
                            "Ничего не делать целый день так классно! А у вас как дела?)"
            );
            allChannels[adminIndex].addPost(
                    "--------------------21 ноября 2025--------------------\n" +
                            "Зачем люди придумали высшую математику..."
            );
        }

        // Каналы пользователей
        if (ind0 != -1) {
            allChannels[ind0].addPost(
                    "Канал: \u001B[38;2;184;134;11m Tail Mail \u001B[0m admin: " + users[0].colorName() + " followers: 35.000\n" +
                            "--------------------22 ноября 2025--------------------\n" +
                            "Всееееем привет!!! Немножко о себе: Я ПРОСТО ОБОЖАЮ ЖИВОТНЫХ\n" +
                            "Нуууу настолько сильно, что пришлось создать целый канал!\n" +
                            "Так чтооо.... Добро пожаловать!\n" +
                            "Здесь вы найдете: \n" +
                            "\u25CF Истории спасённых хвостиков\n" +
                            "\u25CF Советы по уходу за питомцами"
            );
        }
        if (ind1 != -1) {
            allChannels[ind1].addPost(
                    "Канал: \u001B[38;2;184;134;11m Физика для гуманитариев \u001B[0m  admin: " + users[1].colorName() + " followers: 1000" +
                            "\n --------------------19 ноября 2025--------------------\n" +
                            " Почему небо синее?\n" +
                            "Потому что синий свет «рассеивается» в воздухе сильнее других.\n" +
                            "Остальные цвета просто торопятся к земле — а синий остаётся болтаться над нами." +
                            "\n --------------------20 ноября 2025--------------------\n" +
                            "Лежать на диване — нормально.\n" +
                            "Это не лень — это инерция.\n" +
                            "Тело в покое остаётся в покое, пока не поймёт, что кофе остыл." +
                            "\n --------------------21 ноября 2025--------------------\n" +
                            "Почему чайник свистит?\n" +
                            "Пар давит на узкое отверстие — и заставляет воздух вибрировать.\n" +
                            "По сути, чайник — это духовой инструмент с единственной нотой: «Выключи меня!».\n"
            );
        }
        if (ind2 != -1) {
            allChannels[ind2].addPost(
                    "Канал: \u001B[38;2;184;134;11m Звёзды не врут (ну почти) \u001B[0m admin: " + users[2].colorName() + " followers: 5000" +
                            "\n --------------------20 ноября 2025--------------------\n" +
                            "Сегодня звёзды в замешательстве.\n" +
                            "Вы — тоже.\n" +
                            "Это нормально. Просто пейте чай и не принимайте важных решений до обеда. " +
                            "\n --------------------21 ноября 2025--------------------\n" +
                            "Луна в Раке, а вы — в пижаме.\n" +
                            "Звёзды одобряют.\n" +
                            "Главное — не путать «планы на вечер» с «планами выжить до утра». \n"
            );
        }
        if (ind3 != -1) {
            allChannels[ind3].addPost(
                    "Канал: \u001B[38;2;184;134;11m Between Pages \u001B[0m admin: " + users[3].colorName() + " followers: 35" +
                            "\n --------------------20 ноября 2025--------------------\n" +
                            "ОООО ребят моя домашняя библиотека пополнилась на пру тройку книг\n" +
                            "Ждите обзорчики!!!!!\n" +
                            "\n --------------------21 ноября 2025--------------------\n" +
                            "о гспд... каждый должен прочитать Тревожные люди\n" +
                            "поверьте это оооочень хорошо\n" +
                            "завтра будет отзыв!\n"
            );
        }
        String action = scanner.nextLine(); //тип ввод операции, которую хочет совершить админ
        while (!action.equals("Exit")) {
            if (action.equals("Зайти на канал")) {
                enterTheChannel();
            } else if (action.equals("Сделать новый пост")) {
                makeNewPost();
            } else if (action.equals("Написать сообщение")) {
                writeAMessage();
            } else if (action.equals("Прочитать сообщения")) {
                readMessages();
            } else {
                System.out.println("Некорректный ввод команды");
            }
            menu();
            action = scanner.nextLine();
        }
    }

    // Зайти на канал
    public static void enterTheChannel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбери чей канал хочешь посетить: ");
        User.toPrintUsers(users);
        System.out.println(admin.codeAdmin(masUsers, admin) + "Мой канал" + "\u001B[0m");
        String name = scanner.nextLine();
        User user = new User(name);
        if (name.equals("Мой канал")) user = admin;
        int ind = findUserIndex(user, masUsers);
        if (ind == -1) {
            System.out.println("Пользователь не найден.");
        } else {
            allChannels[ind].printChannel();
        }

    }

    // Сделать новый пост
    public static void makeNewPost() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новый пост:");
        String post = scanner.nextLine();
        int ind = findUserIndex(admin, masUsers);
        if (ind != -1) {
            allChannels[ind].addPost("--------------------сегодня--------------------\n" +
                    post);
        }else {
            System.out.println("Ваш аккаунт не найден.");
        }
        allChannels[ind].printChannel();
    }

    // прочитать сообщения
    public static void readMessages() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выбери, где прочитать: \"личные сообщения\" (\"лс\") или \"группы\"");
        String choice = scanner.nextLine();
        if (choice.equals("личные сообщения") || choice.equals("лс")) {
            System.out.println("Выбери чат:");
            User.toPrintUsers(users);
            String directChat = scanner.nextLine();
            for (DirectMessages dm : dms) {
                if (dm.getReceiver().equals(directChat)) {
                    dm.printMessages();
                    break;
                }
            }
        } else if (choice.equals("группы")) {
            System.out.println("Выбери группу:");
            Group.printGroups(groups);
            String chat = scanner.nextLine();
            for (Group group : groups) {
                if (group.getName().equals(chat)) {
                    group.printMessages();
                    break;
                }
            }
        } else System.out.println("Некорректный ввод");
    }

    public static int findUserIndex(User user, User[] mas) {
        for (int i = 0; i < mas.length; i++) {
            if (mas[i].userName.equals(user.userName)) {
                return i;
            }
        }
        return -1;
    }


        // Написать сообщение
        public static void writeAMessage() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выбери, куда написать: \"личные сообщения\" (\"лс\") или \"группы\"");
            String toWhere = scanner.nextLine();

            if (toWhere.equals("личные сообщения") || toWhere.equals("лс")) {
                System.out.println("Выбери кому написать:");
                User.toPrintUsers(users);
                String directChat = scanner.nextLine();
                for (DirectMessages dm : dms) {
                    if (dm.getReceiver().equals(directChat)) {
                        dm.printMessages();
                        System.out.println("Введите сообщение...");
                        dm.sendMessage(scanner.nextLine(), "сегодня");
                        dm.printMessages();
                        break;
                    }
                }
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

        // вывод меню
        public static void menu() {
            System.out.println("""
                    \nВам доступны следующие операции:
                    \u25CF Написать сообщение
                    \u25CF Прочитать сообщения
                    \u25CF Зайти на канал
                    \u25CF Сделать новый пост
                    \u25CF Exit
                    """);
        }
}
