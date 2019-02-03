package main.lesson8.ads;

public class User extends BaseEntity{
    String userName;
    String location;

    public User(long id, String userName, String location) {
        super(id);
        this.userName = userName;
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", location='" + location + '\'' +
                ", id=" + id +
                '}';
    }
}
