package lesson15.library.controller;

import lesson15.library.entity.User;
import lesson15.library.repository.UserRepository;

public class UserController {
    private UserRepository userRepository;
    private User adminUser;

    public UserController(User adminUser, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.adminUser = adminUser;
    }

    public void addLibrarian(String name, String password, String email, String address, String city, String contactNumber) {
        if (!adminUser.isAdmin() || !adminUser.isAuthorized()) {
            System.err.println("Access denied!");

            return;
        }

        User user = userRepository.addUser(new User(name, password, email, address, city, contactNumber, false));
        if (user != null) {
            System.out.println("Librarian added successfully");
        } else {
            System.err.println("Wrong adding librarian");
        }
    }

    public User[] viewLibrarian() {
        if (!adminUser.isAdmin() || !adminUser.isAuthorized()) {
            System.err.println("Access denied!");

            return null;
        }

        return userRepository.getAllLibrarian();
    }

    public void deleteLibrarian(long id) {
        if (!adminUser.isAdmin() || !adminUser.isAuthorized()) {
            System.err.println("Access denied!");

            return;
        }

        User user = userRepository.getUserById(id);
        if (user == null || user.isAdmin()) {
            System.err.println("Incorrect librarian ID!");

            return;
        }

        if (userRepository.deleteUser(user)) {
            System.out.println("Record deleted successfully!");
        } else {
            System.err.println("Wrong deleting librarian!");
        }
    }

}
