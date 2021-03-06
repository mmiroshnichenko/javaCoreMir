package lesson35.controller;

import lesson35.service.UserService;
import lesson35.model.User;

public class UserController {

    private UserService userService = new UserService();

    public UserController() throws Exception {
    }

    public User registerUser(User user) throws Exception{
        return userService.registerUser(user);
    }

    public void login(String userName, String password) throws Exception {
        userService.loginUser(userName, password);
    }

    public void logout() {
        userService.logoutUser();
    }

    public void clearAll() throws Exception {
        userService.clearAll();
    }
}
