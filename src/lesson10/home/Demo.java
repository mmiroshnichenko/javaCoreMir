package lesson10.home;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Инна", "Одесса", "Женский");
        Customer customer2 = new Customer("Павел", "Одесса", "Мужской");

        ElectronicsOrder electronicsOrder = new ElectronicsOrder("phone", new Date(), "Киев", "Одесса", 1200, customer1, 10);
        FurnitureOrder furnitureOrder = new FurnitureOrder("Шкаф", new Date(), "Одесса", "Киев", 6000, customer2, "амега");

        System.out.println(electronicsOrder);
        System.out.println(furnitureOrder);

        orderFlow(electronicsOrder);
        orderFlow(furnitureOrder);

        ElectronicsOrder electronicsOrder2 = new ElectronicsOrder("phone", new Date(), "Киев", "Одесса", 25, customer1, 10);
        orderFlow(electronicsOrder2);

        FurnitureOrder furnitureOrder2 = new FurnitureOrder("Шкаф", new Date(), null, null, 6000, customer2, "амега");
        orderFlow(furnitureOrder2);
    }

    private static void orderFlow(Order order) {
        System.out.println();
        order.validateOrder();
        System.out.println("Date confirmed: " + order.getDateConfirmed());
        order.calculatePrice();
        System.out.println("Total price: " + order.getTotalPrice());
        order.confirmShipping();
        System.out.println("Date shipped: " + order.getDateShipped());
    }
}
