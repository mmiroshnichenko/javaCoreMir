package lesson15.library.controller;

import lesson15.library.entity.User;
import lesson15.library.entity.UserRole;
import lesson15.library.repository.UserRepository;

import java.util.Date;

public class AuthController {
    private UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loginAdmin(String name, String password) {
        return loginUser(name, password, UserRole.admin);
    }

    public User loginLibrarian(String name, String password) {
        return loginUser(name, password, UserRole.librarian);
    }

    private User loginUser(String name, String password, UserRole userRole) {
        User user = userRepository.getUserByNamePasswordAndRole(name, password, userRole);
        if (user != null) {
            userRepository.logoutAllExceptUser(user);
            user.setSessionStart(new Date());
            user.setSessionEnd(null);

            return user;
        }

        return null;
    }

    public void logout(User user) {
        user.setSessionEnd(new Date());
    }
}
