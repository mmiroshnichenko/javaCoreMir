package lesson7;

import lesson6.Car;
import lesson6.DbConnector;
import lesson6.Order;
import lesson6.User;

public class Demo {
    public static void main(String[] args) {
        User user = new User();
        User user1 = new User();
        User user2 = new User();

        User user3 = new User("Jack");

        Car car = new Car(10000, 2015, "Anton");

        DbConnector dbConnector = new DbConnector();

        DemoHomeWork builder = new DemoHomeWork();
        Order order = builder.createOrder();
        System.out.println(order);

        Order order2 = builder.createOrderAndCallMethods();
        System.out.println(order2);
    }
}
