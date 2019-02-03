package main.lesson27.homework1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        System.out.println(useList());
    }

    public static LinkedList<Order> useList() {
        LinkedList<Order> orderLinkedList = new LinkedList<>();

        Order order1 = new Order(101, 200, "UAH", "usb flash1", "rozetka");
        Order order2 = new Order(102, 210, "UAH", "usb flash2", "rozetka");
        Order order3 = new Order(103, 220, "UAH", "usb flash3", "rozetka");
        orderLinkedList.add(order1);
        orderLinkedList.add(order2);
        orderLinkedList.add(order3);
        System.out.println(orderLinkedList);

        Order order4 = new Order(104, 160, "UAH", "optical mouse4", "rozetka");
        Order order5 = new Order(105, 170, "UAH", "optical mouse5", "rozetka");
        Order order6 = new Order(106, 180, "UAH", "optical mouse6", "rozetka");
        orderLinkedList.add(0, order4);
        orderLinkedList.add(1, order5);
        orderLinkedList.add(2, order6);
        System.out.println(orderLinkedList);

        orderLinkedList.remove(0);
        orderLinkedList.remove(order6);
        System.out.println(orderLinkedList);

        LinkedList<Order> orderLinkedList2 = new LinkedList<>();
        Order order7 = new Order(107, 300, "UAH", "keyboard7", "rozetka");
        Order order8 = new Order(108, 310, "UAH", "keyboard8", "rozetka");
        Order order9 = new Order(109, 320, "UAH", "keyboard9", "rozetka");
        orderLinkedList2.add(order7);
        orderLinkedList2.add(order8);
        orderLinkedList2.add(order9);
        System.out.println(orderLinkedList2);

        orderLinkedList.addAll(orderLinkedList2);
        System.out.println(orderLinkedList);
        orderLinkedList2.clear();
        System.out.println(orderLinkedList2);

        List<Order> orderList3 = orderLinkedList.subList(2, 5);
        System.out.println(orderList3);
        orderList3.clear();
        System.out.println(orderList3);
        System.out.println(orderLinkedList);

        Order order10 = new Order(110, 3200, "UAH", "monitor1", "rozetka");
        orderLinkedList.set(0, order10);
        System.out.println(orderLinkedList);

        if (orderLinkedList.contains(order1)) {
            System.out.println(order1.toString() + " already exist in ArrayList");
        }
        Order order11 = new Order(111, 3300, "UAH", "monitor2", "rozetka");
        if (!orderLinkedList.contains(order2)) {
            orderLinkedList.add(order11);
        }
        System.out.println(orderLinkedList);

        Object[] orders = orderLinkedList.toArray();
        System.out.println(Arrays.toString(orders));

        return orderLinkedList;
    }
}
