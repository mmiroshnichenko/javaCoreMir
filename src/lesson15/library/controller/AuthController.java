package lesson15.library.controller;

import lesson15.library.entity.Session;
import lesson15.library.entity.User;
import lesson15.library.entity.UserRole;
import lesson15.library.repository.SessionRepository;
import lesson15.library.repository.UserRepository;

import java.util.Date;

public class AuthController {
    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    public AuthController(UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public User loginAdmin(String name, String password) {
        return loginUser(name, password, UserRole.ADMIN);
    }

    public User loginLibrarian(String name, String password) {
        return loginUser(name, password, UserRole.LIBRARIAN);
    }

    private User loginUser(String name, String password, UserRole userRole) {
        User user = userRepository.getUserByNamePasswordAndRole(name, password, userRole);
        if (user != null) {
            Session session = new Session(user);
            sessionRepository.saveSession(session);
            return user;
        }

        return null;
    }

    public void logout(User user) {
        sessionRepository.clearSessionForUser(user);
    }
}
