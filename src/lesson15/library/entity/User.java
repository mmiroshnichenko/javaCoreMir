package lesson15.library.entity;

import java.util.Date;

public class User {
    private long id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String city;
    private String contactNumber;
    private UserRole userRole;

    private Date sessionStart;
    private Date sessionEnd;

    public User(long id, String name, String password, String email, String address, String city, String contactNumber, UserRole userRole) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contactNumber = contactNumber;
        this.userRole = userRole;
    }

    public User(String name, String password, String email, String address, String city, String contactNumber, UserRole userRole) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contactNumber = contactNumber;
        this.userRole = userRole;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public boolean isAdmin() {
        return userRole == UserRole.admin;
    }

    public boolean isLibrarian() {
        return userRole == UserRole.librarian;
    }

    public boolean isVisitor() {
        return userRole == UserRole.visitor;
    }

    public Date getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(Date sessionStart) {
        this.sessionStart = sessionStart;
    }

    public Date getSessionEnd() {
        return sessionEnd;
    }

    public void setSessionEnd(Date sessionEnd) {
        this.sessionEnd = sessionEnd;
    }

    public boolean isAuthorized() {
        if (sessionStart != null && sessionEnd == null) {
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (userRole != user.userRole) return false;
        if (!name.equals(user.name)) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        if (!address.equals(user.address)) return false;
        if (!city.equals(user.city)) return false;
        return contactNumber.equals(user.contactNumber);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + contactNumber.hashCode();
        result = 31 * result + userRole.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", userRole=" + userRole +
                ", sessionStart=" + sessionStart +
                ", sessionEnd=" + sessionEnd +
                '}';
    }
}
