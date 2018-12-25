package lesson15.library.repository;

import lesson15.library.entity.User;

import java.util.Date;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User getAdminByNameAndPassword(String name, String password) {
        for (User user : users) {
            if (user != null && user.isAdmin() && name.equals(user.getName()) && password.equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }

    public User getLibrarianByNameAndPassword(String name, String password) {
        for (User user : users) {
            if (user != null && !user.isAdmin() && name.equals(user.getName()) && password.equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }

    public void logoutAllExceptUser(User user) {
        for (User elUser : users) {
            if (elUser != null && !(elUser.equals(user) && elUser.hashCode() == user.hashCode())) {
                elUser.setSessionEnd(new Date());
            }
        }
    }

    public User getUserByNameAndEmail(String name, String email) {
        for (User user : users) {
            if (user != null && name.equals(user.getName()) && email.equals(user.getEmail())) {
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

    public boolean deleteUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (user.equals(users[i]) && user.hashCode() == users[i].hashCode()) {
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
