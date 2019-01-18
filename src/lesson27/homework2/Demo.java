package lesson27.homework2;

public class Demo {
    public static void main(String[] args) {
        try {
            User user1 = new User(1001, "Daniil", "32434234sdsfuuuuo");
            UserRepository.save(user1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(UserRepository.getUsers());
        }

        try {
            User user10 = new User(1001, "Ivan", "32434234sdsfuuuuo");
            UserRepository.save(user10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(UserRepository.getUsers());
        }

        try {
            User user2 = new User(1002, "Andrey", "ewrewrwer4343wef");
            UserRepository.save(user2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(UserRepository.getUsers());
        }

        try {
            User user3 = new User(1000, "Test", "32434234sdsfuuuuo");
            UserRepository.update(user3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(UserRepository.getUsers());
        }

        try {
            User user30 = new User(1001, "Test", "32434234sdsfuuuuo");
            UserRepository.update(user30);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(UserRepository.getUsers());
        }

        try {
            UserRepository.delete(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(UserRepository.getUsers());
        }

        try {
            UserRepository.delete(1002);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(UserRepository.getUsers());
        }

        try {
            User user4 = UserRepository.findById(1002);
            System.out.println(user4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            User user5 = UserRepository.findById(1001);
            System.out.println(user5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
