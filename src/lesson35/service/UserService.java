package lesson35.service;

import lesson35.model.User;
import lesson35.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user) {
        // chek business logic

        //if logic is ok
        return userRepository.registerUser(user);
    }
}
