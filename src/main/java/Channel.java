public class Channel {
    private User owner;
    private String[] posts;
    private int count; // сколько постов реально добавлено

    // Максимум постов — например, 20
    private static final int maxPosts = 10;

    public Channel(User owner) {
        this.owner = owner;
        this.posts = new String[maxPosts];
        this.count = 0;
    }

    public void addPost(String post) {
        if (count < maxPosts) {
            posts[count] = post;
            count++;
        } else {
            System.out.println("Канал переполнен! Нельзя добавить больше " + maxPosts + " постов.");
        }
    }

    public void printChannel() {
        if (count == 0) {
            System.out.println("Пока нет постов.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(posts[i]);
            }
        }
        System.out.println("======================================\n");
    }

    public User getOwner() {
        return owner;
    }
}
