import java.util.Random;

public class User {
    protected String userName;
    protected String colorCode;

    public User(String userName) {
        this.userName = userName;
        this.colorCode = generateColor();
    }

    public User() {
    }

    public String getUserName() {
        return this.userName;
    }
    public String generateColor() {
        Random random = new Random();
        String[] colors = {
                "\u001B[38;2;135;206;235m",
                "\u001B[38;2;238;130;238m",
                "\u001B[38;2;100;149;237m",
                "\u001B[38;2;220;20;60m",
                "\u001B[38;2;255;165;0m",
                "\u001B[38;2;0;250;154m",
                "\u001B[38;2;255;105;180m",
                "\u001B[38;2;0;255;0m",
                "\u001B[38;2;0;191;255m",
                "\u001B[38;2;255;255;0m",

        };
        int color = random.nextInt(colors.length);
        return colors[color];
    }
    public static User[] getUsers(User[] masUsers, User admin) {
        User[] users = new User[masUsers.length-1];
        int index = 0;
        for (int i = 0; i < masUsers.length; i++) {
            if (!masUsers[i].userName.equals(admin.userName)) users[index++] = masUsers[i];
        }
        return users;
    }
    public String codeAdmin() {
        for (int i = 0; i < Main.masUsers.length; i++) {
            if (Main.masUsers[i].userName.equals(Main.admin.userName)) return Main.masUsers[i].colorCode;
        }
        return null;
    }

    public String colorName() {
        return colorCode + userName + "\u001B[0m";
    }
    public static void toPrintUsers(User[] masUsers) {
        for (int i = 0; i < masUsers.length; i++) {
            System.out.println(masUsers[i].colorName());
        }
    }
}
