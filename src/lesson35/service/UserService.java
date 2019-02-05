package lesson35.service;

import lesson35.exceptions.AuthException;
import lesson35.model.Session;
import lesson35.model.User;
import lesson35.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = UserRepository.getInstance();

    public User registerUser(User user) throws Exception {
        return userRepository.registerUser(user);
    }

    public User loginUser(String userName, String password) throws Exception {
        User user = userRepository.getUserByUserNameAndPassword(userName, password);
        if (user == null) {
            throw new AuthException("Error: incorrect userName or password");
        }

        Session.addUser(user);

        return user;
    }

    public void logoutUser() {
        Session.clear();
    }
}
