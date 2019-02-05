package lesson35.service;

import lesson35.model.User;
import lesson35.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = UserRepository.getInstance();

    public User registerUser(User user) throws Exception {
        // chek business logic

        //if logic is ok
        return userRepository.addObject(user);
    }
}
