package lesson9.home;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        String[] names = new String[users.length];

        int index = 0;
        for (User user : users) {
            names[index] = user.getName();
            index++;
        }

        return names;
    }

    public long[] getUserIds() {
        long[] ids = new long[users.length];

        int index = 0;
        for (User user: users) {
            ids[index] = user.getId();
            index++;
        }

        return ids;
    }

    public String getUserNameById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user.getName();
            }
        }

        return "";
    }
}
