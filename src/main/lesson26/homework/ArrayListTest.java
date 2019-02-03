package main.lesson26.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        System.out.println(useList());
    }

    public static ArrayList<Order> useList() {
        ArrayList<Order> orderArrayList = new ArrayList<>();

        Order order1 = new Order(101, 200, "UAH", "usb flash1", "rozetka");
        Order order2 = new Order(102, 210, "UAH", "usb flash2", "rozetka");
        Order order3 = new Order(103, 220, "UAH", "usb flash3", "rozetka");
        orderArrayList.add(order1);
        orderArrayList.add(order2);
        orderArrayList.add(order3);
        System.out.println(orderArrayList);

        Order order4 = new Order(104, 160, "UAH", "optical mouse4", "rozetka");
        Order order5 = new Order(105, 170, "UAH", "optical mouse5", "rozetka");
        Order order6 = new Order(106, 180, "UAH", "optical mouse6", "rozetka");
        orderArrayList.add(0, order4);
        orderArrayList.add(1, order5);
        orderArrayList.add(2, order6);
        System.out.println(orderArrayList);

        orderArrayList.remove(0);
        orderArrayList.remove(order6);
        System.out.println(orderArrayList);

        ArrayList<Order> orderArrayList2 = new ArrayList<>();
        Order order7 = new Order(107, 300, "UAH", "keyboard7", "rozetka");
        Order order8 = new Order(108, 310, "UAH", "keyboard8", "rozetka");
        Order order9 = new Order(109, 320, "UAH", "keyboard9", "rozetka");
        orderArrayList2.add(order7);
        orderArrayList2.add(order8);
        orderArrayList2.add(order9);
        System.out.println(orderArrayList2);

        orderArrayList.addAll(orderArrayList2);
        System.out.println(orderArrayList);
        orderArrayList2.clear();
        System.out.println(orderArrayList2);

        List<Order> orderList3 = orderArrayList.subList(2, 5);
        System.out.println(orderList3);
        orderList3.clear();
        System.out.println(orderList3);
        System.out.println(orderArrayList);

        Order order10 = new Order(110, 3200, "UAH", "monitor1", "rozetka");
        orderArrayList.set(0, order10);
        System.out.println(orderArrayList);

        if (orderArrayList.contains(order1)) {
            System.out.println(order1.toString() + " already exist in ArrayList");
        }
        Order order11 = new Order(111, 3300, "UAH", "monitor2", "rozetka");
        if (!orderArrayList.contains(order2)) {
            orderArrayList.add(order11);
        }
        System.out.println(orderArrayList);

        Object[] orders = orderArrayList.toArray();
        System.out.println(Arrays.toString(orders));

        return orderArrayList;
    }
}
