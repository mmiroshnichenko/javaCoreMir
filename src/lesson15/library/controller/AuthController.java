package lesson15.library.controller;

import lesson15.library.entity.User;
import lesson15.library.repository.UserRepository;

import java.util.Date;

public class AuthController {
    private UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loginAdmin(String name, String password) {
        User user = userRepository.getAdminByNameAndPassword(name, password);
        if (user != null) {
            userRepository.logoutAllExceptUser(user);
            user.setSessionStart(new Date());
            user.setSessionEnd(null);
            System.out.println("Admin logged in");

            return user;
        } else {
            System.err.println("Incorrect name or password");
        }

        return null;
    }

    public User loginLibrarian(String name, String password) {
        User user = userRepository.getLibrarianByNameAndPassword(name, password);
        if (user != null) {
            userRepository.logoutAllExceptUser(user);
            user.setSessionStart(new Date());
            user.setSessionEnd(null);
            System.out.println("Librarian logged in");

            return user;
        } else {
            System.err.println("Incorrect name or password");
        }

        return null;
    }

    public void logout(User user) {
        user.setSessionEnd(new Date());
    }
}
