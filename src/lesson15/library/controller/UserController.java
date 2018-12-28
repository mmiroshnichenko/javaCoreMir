package lesson15.library.controller;

import lesson15.library.entity.User;
import lesson15.library.entity.UserRole;
import lesson15.library.repository.SessionRepository;
import lesson15.library.repository.UserRepository;

public class UserController {
    private UserRepository userRepository;
    private SessionRepository sessionRepository;
    private User user;

    public UserController(User user, UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.user = user;
    }

    public User addLibrarian(String name, String password, String email, String address, String city, String contactNumber) {
        if (!user.isAdmin() || !sessionRepository.userAuthorized(user)) {
            return null;
        }

        return userRepository.addUser(new User(name, password, email, address, city, contactNumber, UserRole.LIBRARIAN));
    }

    public User[] viewLibrarian() {
        if (!user.isAdmin() || !sessionRepository.userAuthorized(user)) {
            return null;
        }

        return userRepository.getAllLibrarian();
    }

    public boolean deleteLibrarian(long id) {
        if (!user.isAdmin() || !sessionRepository.userAuthorized(user)) {
            return false;
        }

        return userRepository.deleteUserById(id);
    }

}
