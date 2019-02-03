package main.lesson15.library.controller;

import main.lesson15.library.entity.Session;
import main.lesson15.library.entity.User;
import main.lesson15.library.repository.SessionRepository;
import main.lesson15.library.repository.UserRepository;


public class AuthController {
    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    public AuthController(UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public User loginUser(String name, String password) {
        User user = userRepository.getUserByNameAndPassword(name, password);
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
