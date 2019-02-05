package lesson35.repository;

import lesson35.exceptions.AuthException;
import lesson35.exceptions.FormatDataException;
import lesson35.model.User;
import lesson35.model.UserType;

public class UserRepository extends BaseRepository<User> {

    private static UserRepository instance = null;

    private UserRepository() {
        super(5, "UserDb.txt");
    }

    public static synchronized  UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }

        return instance;
    }

    public User registerUser(User user) throws Exception {
        if (findUserByName(user.getUserName()) != null) {
            throw new AuthException("Error: " + user.getUserName() + " already registered");
        }

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
    protected User mapObject(String[] rowData) throws FormatDataException {
        User user;
        try {
            user = new User(
                    Long.parseLong(rowData[0]),  // id
                    rowData[1],                  //userName
                    rowData[2],                  //password
                    rowData[3],                  //country
                    UserType.valueOf(rowData[4]) //UserType
            );
        } catch (NumberFormatException e) {
            throw new FormatDataException("Error: data format of object User is wrong");
        }
        return user;
    }

    @Override
    protected String toDbRow(User user) {
        return user.getId()
                + ";" + user.getUserName()
                + ";" + user.getPassword()
                + ";" + user.getCountry()
                + ";" + user.getUserType();
    }
}
