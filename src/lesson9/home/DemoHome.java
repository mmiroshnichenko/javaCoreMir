package lesson9.home;

public class DemoHome {
    public static void main(String[] args) {
        User user1 = new User(12, "Pavel", "5465364");
        User user2 = new User(14, "Roman", "8798798");
        User user3 = new User(17, "Igor", "465465");

        User[] users = {user1, user2, user3};

        UserRepository userRepository = new UserRepository(users);

        String[] names = userRepository.getUserNames();
    }


}
