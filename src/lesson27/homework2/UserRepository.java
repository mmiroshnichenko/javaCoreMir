package lesson27.homework2;

import java.util.ArrayList;

public class UserRepository {
    private static ArrayList<User> users = new ArrayList<>();

    public static User save(User user) throws BadRequestException {
        User existUser = findById(user.getId());
        if (existUser != null) {
            throw new BadRequestException(user.toString() + " already exist");
        }

        users.add(user);
        return user;
    }

    public static User update(User user) throws UserNotFoundException {
        int index = 0;
        for (User elUser : users) {
            if (user.getId() == elUser.getId()) {
                users.set(index, user);

                return users.get(index);
            }
            index++;
        }

        throw new UserNotFoundException(user.toString() + " not found in repository");
    }

    public static void delete(long id) throws UserNotFoundException {
        User user = findById(id);
        if (user == null) {
            throw new UserNotFoundException("User with id: " + id + " not found in repository");
        }

        users.remove(user);
    }

    public static User findById(long id) {
        for (User user : users) {
            if (id == user.getId()){
                return user;
            }
        }

        return null;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

}
