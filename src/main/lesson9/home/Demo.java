package main.lesson9.home;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user = new User(1001, "Ann", "1w21212");
        userRepository.save(user);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        userRepository.save(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));



        //сохранение юзера
        //сохранение того же юзера
        //когда нет места в массиве
        //когда сохраняем null

        int n = 15;
        while(n > 0) {
            User users1 = new User(n, "Ann", "1w21212");
            System.out.println(userRepository.save(users1));
            n--;
        }

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.save(null);

        //test update
        user = new User(1001, "Ann", "eretertert");
        userRepository.update(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //обновление юзера
        //когда нет юзера на обновление
        //когда обновляем null

        user = new User(9999, "Ann", "eretertert");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println(userRepository.update(null));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.delete(1001);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        userRepository.delete(0);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        userRepository.delete(-89);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println(Arrays.deepToString(userRepository.getUserNames()));
        System.out.println(Arrays.toString(userRepository.getUserIds()));

        System.out.println(userRepository.getUserNameById(15));
        System.out.println(userRepository.getUserNameById(48));
        System.out.println(userRepository.getUserNameById(-12));
        System.out.println(userRepository.getUserNameById(0));

        System.out.println(userRepository.getUserByName("Ann"));
        System.out.println(userRepository.getUserByName("Stepa"));
        System.out.println(userRepository.getUserByName(null));
        System.out.println(userRepository.getUserByName(""));

        System.out.println(userRepository.findById(15));
        System.out.println(userRepository.findById(48));
        System.out.println(userRepository.findById(-12));
        System.out.println(userRepository.findById(0));

        System.out.println(userRepository.getUserBySessionId("1w21212"));
        System.out.println(userRepository.getUserBySessionId("465465"));
        System.out.println(userRepository.getUserBySessionId(""));
        System.out.println(userRepository.getUserBySessionId(null));
    }


}
