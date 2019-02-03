package main.lesson9.home;

public class UserRepository {
    private User[] users = new User[10];

    public User[] getUsers() {
        return users;
    }

    public User save(User user) {
        if (user == null) {
            return null;
        }
        User existUser = findById(user.getId());
        if (existUser != null) {
            return null;
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return user;
            }
        }

        return null;
    }

    public User update(User user) {
        if (user == null || users == null) {
            return null;
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == user.getId()) {
                users[i] = user;
                return user;
            }
        }

        return null;
    }

    public void delete(long id) {
        User existUser = findById(id);
        if (existUser == null) {
            return;
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] == existUser) {
                users[i] = null;
                return;
            }
        }
    }


    public String[] getUserNames() {
        if (users == null) {
            return new String[0];
        }

        int length = 0;
        for (User user : users) {
            if (user != null && user.getName() != null) {
                length++;
            }
        }

        if (length == 0) {
            return new String[0];
        }

        int index = 0;
        String[] names = new String[length];
        for (User user : users) {
            if (user != null && user.getName() != null) {
                names[index] = user.getName();
                index++;
            }
        }

        return names;
    }

    public long[] getUserIds() {
        if (users == null) {
            return new long[0];
        }

        int length = 0;
        for (User user: users) {
            if (user != null && user.getId() > 0) {
                length++;
            }
        }

        if (length == 0) {
            return new long[0];
        }

        long[] ids = new long[length];
        int index = 0;
        for (User user: users) {
            if (user != null && user.getId() > 0) {
                ids[index] = user.getId();
                index++;
            }
        }

        return ids;
    }

    public String getUserNameById(long id) {
        if (users == null) {
            return null;
        }

        for (User user : users) {
            if (user != null && user.getId() == id) {
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

    public User findById(long id) {
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
