package lesson9.home;

import java.util.Arrays;

public class DemoHome {
    public static void main(String[] args) {
        User user1 = new User(12, "Pavel", "5465364");
        User user2 = new User(14, "Roman", "8798798");
        User user3 = new User(17, "Igor", "465465");

        User[] users = {user1, user2, user3, null, null};

        UserRepository userRepository = new UserRepository(users);

        User user4 = userRepository.save(new User(18, "Igorok", "465465"));
        User user6 = userRepository.save(new User(18, "Igorok", "465465"));
        User user5 = userRepository.save(null);

        String[] names = userRepository.getUserNames();

        System.out.println(Arrays.toString(names));
    }


}
