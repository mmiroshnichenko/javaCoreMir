package lesson10.Home;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Инна", "Одесса", "Женский");
        Customer customer2 = new Customer("Павел", "Одесса", "Мужской");

        ElectronicsOrder electronicsOrder = new ElectronicsOrder("phone", new Date(), "Киев", "Одесса", 1200, customer1, 10);
        FurnitureOrder furnitureOrder = new FurnitureOrder("Шкаф", new Date(), "Одесса", "Киев", 6000, customer2, "амега");

        electronicsOrder.validateOrder();
        electronicsOrder.calculatePrice();
        electronicsOrder.confirmShipping();

        furnitureOrder.validateOrder();
        furnitureOrder.calculatePrice();
        furnitureOrder.confirmShipping();
    }
}
