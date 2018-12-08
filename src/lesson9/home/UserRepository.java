package lesson9.home;

import java.util.Arrays;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        String[] names = new String[0];
        if (users == null) {
            return names;
        }

        for (User user : users) {
            if (user != null && user.getName() != null) {
                int count = names.length;
                names = Arrays.copyOf(names, count +  1);
                names[count] = user.getName();
            }
        }

        return names;
    }

    public long[] getUserIds() {
        long[] ids = new long[0];
        if (users == null) {
            return ids;
        }

        for (User user: users) {
            if (user != null && user.getId() > 0) {
                int count = ids.length;
                ids = Arrays.copyOf(ids, count +  1);
                ids[count] = user.getId();
            }
        }

        return ids;
    }

    public String getUserNameById(long id) {
        if (users == null) {
            return null;
        }

        for (User user : users) {
            if (user != null && user.getId() > 0 && user.getId() == id) {
                return user.getName();
            }
        }

        return null;
    }
}
