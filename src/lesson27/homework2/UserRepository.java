package lesson27.homework2;

import java.util.ArrayList;

public class UserRepository {
    private static ArrayList<User> users = new ArrayList<>();

    public static User save(User user) throws BadRequestException {
        try {
            findById(user.getId());
            throw new BadRequestException(user.toString() + " already exist");
        } catch (UserNotFoundException e) {
            //System.out.println(user.toString() + " will be saved");
        }

        users.add(user);
        return user;
    }

    public static User update(User user) throws UserNotFoundException {
        int index = users.indexOf(findById(user.getId()));
        users.set(index, user);

        return users.get(index);
    }

    public static void delete(long id) throws UserNotFoundException {
        users.remove(findById(id));
    }

    public static User findById(long id) throws UserNotFoundException {
        for (User user : users) {
            if (id == user.getId()){
                return user;
            }
        }

        throw new UserNotFoundException("User with id: " + id + " not found in repository");
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

}
