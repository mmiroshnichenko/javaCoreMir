package lesson15.homeUserRepository;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User save(User user) {
        if (user == null) {
            return null;
        }
        User existUser = findUser(user);
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
            if (users[i] != null && users[i].equals(user) && users[i].hashCode() == user.hashCode()) {
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

    public User findUser(User user) {
        if (users == null) {
            return null;
        }

        for (User userInArr : users) {
            if (user.equals(userInArr) && user.hashCode() == userInArr.hashCode()) {
                return userInArr;
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
}
