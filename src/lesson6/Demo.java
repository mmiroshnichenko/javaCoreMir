package lesson6;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Car carObject = new Car(10000, 2015, "Anton");
        System.out.println(carObject.color);
        System.out.println(carObject.horsePower);
        System.out.println(carObject.ownerName);

        Car carObject2 = new Car(-1000, 2015, null);
        System.out.println(carObject2);

        carObject.horsePower = 100;
        System.out.println(carObject.horsePower);

        carObject.startRun();
        carObject.stopRun();

        carObject.changeOwner("Test");
        System.out.println(carObject.ownerName);
        carObject.changeOwner("Test");
        System.out.println(carObject.ownerName);
        carObject.changeOwner(null);
        System.out.println(carObject.ownerName);

        Car carObject3 = null;
        System.out.println(carObject3);

        Order ord = new Order();
        ord.confirmOrder();
        ord.checkPrice();
        ord.isValidType();
        System.out.println(ord);

        Order orderObject = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        orderObject.confirmOrder();
        orderObject.checkPrice();
        orderObject.isValidType();
        System.out.println(orderObject);

        Order orderObject2 = new Order(1000, null, false, new Date(), "Kiev", "Ukraine", null);
        orderObject.confirmOrder();
        orderObject.checkPrice();
        orderObject.isValidType();
        System.out.println(orderObject2);

        User user = new User();
        System.out.println(user);
        user.isActive(true);
        System.out.println(user);
        user.isActive(false);
        System.out.println(user);

        User user2 = new User("Pavel", 12, "Kiev", new Date(), false);
        System.out.println(user2);
        user2.logIn();
        user2.increaseAge();
        user2.isActive(true);
        System.out.println(user2);
    }
}
