package lesson35.demo;

import lesson35.model.Order;

public class DemoOrder extends DemoHotel {

    public static void main(String[] args) {
        try {
            fillData();

            for (Order order : orderController.getAllOrders()) {
                System.out.println(order);
            }

            System.out.println("Add order for not authorized user");
            userController.logout();
            try {
                orderController.bookRoom(1, 2, dateFormat.parse("16-03-2019"), dateFormat.parse("20-03-2019"));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            userController.login("User1", "789465");
            System.out.println("Add order on already booked room");
            try {
                orderController.bookRoom(1, 2, dateFormat.parse("10-02-2019"), dateFormat.parse("20-03-2019"));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("Add order on not exist room");
            try {
                orderController.bookRoom(253, 2, dateFormat.parse("10-02-2019"), dateFormat.parse("20-03-2019"));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("Add order on not exist user");
            try {
                orderController.bookRoom(1, 25, dateFormat.parse("21-02-2019"), dateFormat.parse("20-03-2019"));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("Add valid order");
            orderController.bookRoom(1, 2, dateFormat.parse("21-02-2019"), dateFormat.parse("20-03-2019"));

            for (Order order : orderController.getAllOrders()) {
                System.out.println(order);
            }
            System.out.println("Cancel order");
            orderController.cancelReservation(2);
            for (Order order : orderController.getAllOrders()) {
                System.out.println(order);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
