package lesson15.library.controller;

import lesson15.library.entity.User;
import lesson15.library.entity.UserRole;
import lesson15.library.repository.UserRepository;

public class UserController {
    private UserRepository userRepository;
    private User user;

    public UserController(User user, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.user = user;
    }

    public User addLibrarian(String name, String password, String email, String address, String city, String contactNumber) {
        if (!user.isAdmin() || !user.isAuthorized()) {
            System.err.println("Access denied!");

            return null;
        }

        return userRepository.addUser(new User(name, password, email, address, city, contactNumber, UserRole.librarian));
    }

    public User[] viewLibrarian() {
        if (!user.isAdmin() || !user.isAuthorized()) {
            System.err.println("Access denied!");

            return null;
        }

        return userRepository.getAllLibrarian();
    }

    public boolean deleteLibrarian(long id) {
        if (!user.isAdmin() || !user.isAuthorized()) {
            System.err.println("Access denied!");

            return false;
        }

        return userRepository.deleteUserById(id);
    }

}
