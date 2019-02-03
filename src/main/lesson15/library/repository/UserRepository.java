package main.lesson15.library.repository;

import main.lesson15.library.entity.User;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User getUserByNameAndPassword(String name, String password) {
        for (User user : users) {
            if (user != null && name.equals(user.getName()) && password.equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }

    public User getUserById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public boolean deleteUserById(long id) {
        User user = getUserById(id);
        if (user == null || user.isAdmin()) {
            return false;
        }

        return deleteUser(user);
    }

    public boolean deleteUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (user.equals(users[i])) {
                users[i] = null;

                return true;
            }
        }

        return false;
    }

    public User addUser(User user) {
        if (getUserByNameAndEmail(user.getName(), user.getEmail()) != null) {
            System.err.println("Name or email already exist");

            return null;
        }

        user.setId(getNextUserId());

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return user;
            }
        }

        return null;
    }

    public User[] getAllLibrarian() {
        int length = 0;
        for (User user : users) {
            if (user != null && !user.isAdmin()) {
                length++;
            }
        }

        User[] librarian = new User[length];
        int index = 0;
        for (User user : users) {
            if (user != null && !user.isAdmin()) {
                librarian[index] = user;
                index++;
            }
        }

        return librarian;
    }

    private User getUserByNameAndEmail(String name, String email) {
        for (User user : users) {
            if (user != null && name.equals(user.getName()) && email.equals(user.getEmail())) {
                return user;
            }
        }

        return null;
    }

    private long getNextUserId() {
        long maxId = users[0] != null ? users[0].getId() : 0;
        for (User user : users) {
            if (user != null && user.getId() > maxId) {
                maxId = user.getId();
            }
        }
        maxId++;

        return maxId;
    }
}
