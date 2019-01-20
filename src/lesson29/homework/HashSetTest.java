package lesson29.homework;

import java.util.*;

public class HashSetTest {
    public static void main(String[] args) {
        System.out.println(useHashSet());
    }

    public static Set<Order> useHashSet() {
        Set<Order> orderHashSet = new HashSet<>();

        Order order1 = new Order(101, 200, "UAH", "usb flash1", "rozetka");
        Order order2 = new Order(102, 210, "UAH", "usb flash2", "rozetka");
        Order order3 = new Order(103, 220, "UAH", "usb flash3", "rozetka");
        orderHashSet.add(order1);
        orderHashSet.add(order2);
        orderHashSet.add(order3);
        System.out.println(orderHashSet);

        Order order4 = new Order(104, 160, "UAH", "optical mouse4", "rozetka");
        Order order5 = new Order(105, 170, "UAH", "optical mouse5", "rozetka");
        Order order6 = new Order(106, 180, "UAH", "optical mouse6", "rozetka");
        orderHashSet.add(order4);
        orderHashSet.add(order5);
        orderHashSet.add(order6);
        System.out.println(orderHashSet);

        orderHashSet.remove(order5);
        orderHashSet.remove(order6);
        System.out.println(orderHashSet);

        Set<Order> orderHashSet2 = new HashSet<>();
        orderHashSet2.add(order3);
        orderHashSet2.add(order4);

        orderHashSet.retainAll(orderHashSet2);

        System.out.println(orderHashSet);

        Object[] objects = orderHashSet.toArray();

        System.out.println(Arrays.toString(objects));

        Order order7 = new Order(107, 300, "UAH", "keyboard7", "rozetka");
        Order order8 = new Order(108, 310, "UAH", "keyboard8", "rozetka");
        Order order9 = new Order(109, 320, "UAH", "keyboard9", "rozetka");

        orderHashSet.add(order7);
        orderHashSet.add(order8);
        orderHashSet.add(order9);

        System.out.println(orderHashSet.size());

        return orderHashSet;
    }
}
