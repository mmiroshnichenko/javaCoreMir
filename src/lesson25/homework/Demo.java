package lesson25.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        try {
            GeneralDAO<String> stringDAO = new GeneralDAO<>();

            stringDAO.save("test1");
            System.out.println(Arrays.toString(stringDAO.getAll()));
            stringDAO.save("test2");
            System.out.println(Arrays.toString(stringDAO.getAll()));
            stringDAO.save("test2");
            System.out.println(Arrays.toString(stringDAO.getAll()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            GeneralDAO<Integer> integerDAO = new GeneralDAO<>();

            integerDAO.save(1);
            System.out.println(Arrays.toString(integerDAO.getAll()));
            Integer number = new Integer(2);
            integerDAO.save(number);
            System.out.println(Arrays.toString(integerDAO.getAll()));
            integerDAO.save(3);
            System.out.println(Arrays.toString(integerDAO.getAll()));
            integerDAO.save(4);
            System.out.println(Arrays.toString(integerDAO.getAll()));
            integerDAO.save(5);
            System.out.println(Arrays.toString(integerDAO.getAll()));
            integerDAO.save(6);
            System.out.println(Arrays.toString(integerDAO.getAll()));
            integerDAO.save(7);
            System.out.println(Arrays.toString(integerDAO.getAll()));
            integerDAO.save(8);
            System.out.println(Arrays.toString(integerDAO.getAll()));
            integerDAO.save(9);
            System.out.println(Arrays.toString(integerDAO.getAll()));
            integerDAO.save(10);
            System.out.println(Arrays.toString(integerDAO.getAll()));
            integerDAO.save(11);
            System.out.println(Arrays.toString(integerDAO.getAll()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            GeneralDAO<Order> orderDAO = new GeneralDAO<>();

            orderDAO.save(new Order(12));
            System.out.println(Arrays.toString(orderDAO.getAll()));
            orderDAO.save(new Order(42));
            System.out.println(Arrays.toString(orderDAO.getAll()));
            orderDAO.save(new Order(42));
            System.out.println(Arrays.toString(orderDAO.getAll()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
