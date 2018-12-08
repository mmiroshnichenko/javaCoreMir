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

    public User save(User user) {
        if (!isCorrectUser(user)) {
            return null;
        }

        User existUser = this.findById(user.getId());
        if (existUser != null) {
            return null;
        }

        if (users != null && users.length == 2147483647) {
            return null;
        }

        if (users == null) {
            this.users = new User[0];
        }

        int count = users.length;
        users = Arrays.copyOf(users, count + 1);
        users[count] = user;

        return user;
    }

    private boolean isCorrectUser(User user) {
        return user != null && user.getId() > 0 && user.getName() != null && user.getSessionId() != null;
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

    public User getUserByName(String name) {
        if (users == null) {
            return null;
        }

        for (User user : users) {
            if (user != null && user.getName() == name) {
                return user;
            }
        }

        return null;
    }

    private User findById(long id) {
        if (users == null) {
            return null;
        }

        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public User getUserBySessionId(String sessionId) {
        if (users == null) {
            return null;
        }

        for (User user : users) {
            if (user != null && user.getSessionId() == sessionId) {
                return user;
            }
        }

        return null;
    }


}
