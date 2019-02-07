package lesson35.demo;

import lesson35.model.Session;
import lesson35.model.User;
import lesson35.model.UserType;

public class DemoUser extends BaseDemo{
    public static void main(String[] args) {
        try {
            fillData();
            try {
                userController.registerUser(new User("User2", "46464645", "Ukraine", UserType.USER));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            userController.registerUser(new User("User3", "46464645", "Ukraine", UserType.USER));

            try {
                userController.login("User4", "454646rrsdf");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            userController.login("User3", "46464645");

            System.out.println(Session.getUser());

            userController.logout();

            System.out.println(Session.getUser());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
