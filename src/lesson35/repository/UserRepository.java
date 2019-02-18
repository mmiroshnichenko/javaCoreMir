package lesson35.repository;

import lesson35.model.User;
import lesson35.model.UserType;

public class UserRepository extends BaseRepository<User> {
    public UserRepository() throws Exception {
        super("UserDb.txt");
    }

    public User registerUser(User user) throws Exception {
        return addObject(user);
    }

    public User findUserByName(String userName) throws Exception {
        for (User user : getAllObjects()) {
            if (userName.equals(user.getUserName())) {
                return user;
            }
        }

        return null;
    }

    public User getUserByUserNameAndPassword(String userName, String password) throws Exception {
        for (User user : getAllObjects()) {
            if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }

    @Override
    protected User mapObject(String[] rowData) {
        return new User(
                    Long.parseLong(rowData[0]),  // id
                    rowData[1],                  //userName
                    rowData[2],                  //password
                    rowData[3],                  //country
                    UserType.valueOf(rowData[4]) //UserType
            );
    }
}
