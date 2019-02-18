package lesson35.service;

import lesson35.exceptions.AuthException;
import lesson35.exceptions.BadRequestException;
import lesson35.model.Session;
import lesson35.model.User;
import lesson35.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public UserService() throws Exception {
    }

    public User registerUser(User user) throws Exception {
        validate(user);

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

    public void clearAll() throws Exception {
        userRepository.clearDataInDb();
    }

    private void validate(User user) throws Exception {
        if (userRepository.findUserByName(user.getUserName()) != null) {
            throw new BadRequestException("Error: " + user.getUserName() + " already registered");
        }

        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            throw new BadRequestException("Error: user Name is required");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new BadRequestException("Error: user Password is required");
        }

        if (user.getCountry() == null || user.getCountry().isEmpty()) {
            throw new BadRequestException("Error: user Country is required");
        }

        if (user.getUserType() == null) {
            throw new BadRequestException("Error: user Type is required");
        }
    }
}
