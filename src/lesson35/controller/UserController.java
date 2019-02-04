package lesson35.controller;

import lesson35.service.UserService;
import lesson35.model.User;

public class UserController {

    private UserService userService = new UserService();

    public User registerUser(User user) {
        return userService.registerUser(user);
    }
}
