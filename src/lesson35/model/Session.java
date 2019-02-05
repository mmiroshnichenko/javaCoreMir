package lesson35.model;

public class Session {
    private static User user;

    public static void addUser(User newUser) {
        user = newUser;
    }

    public static void clear() {
        user = null;
    }

    public static User getUser() {
        return user;
    }
}
