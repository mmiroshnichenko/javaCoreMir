package lesson5;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] array = {-10, 0, 110, 555, 1000, -45, 0, 60, 10};
        int[] array2 = {0, 0, 0, 0, 0, -0, 0, 0, 0};
        int[] array3 = {0, 10, 10, 20, 30, 40, 50, 60, -70};
        int[] array4 = new int[0];

        System.out.println(ArraysPractice.maxElement(array));
        System.out.println(ArraysPractice.maxElement(array2));
        System.out.println(ArraysPractice.maxElement(array3));
        System.out.println(ArraysPractice.maxElement(array4));

        System.out.println(ArraysPractice.nCount(array, 10));
        System.out.println(ArraysPractice.nCount(array2, 10));
        System.out.println(ArraysPractice.nCount(array4, 10));

        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, 99, 12000, -54, 0};
        System.out.println(Arrays.toString(BanksPractice.findClientsByBalance(names, balances, -100)));

        String[] names2 = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", null};
        int[] balances2 = {100, 500, 8432, 99, 12000, -54, -10};
        System.out.println(Arrays.toString(BanksPractice.findClientsByBalance(names2, balances2, -20)));

        System.out.println(Arrays.toString(BanksPractice.findClientsWithNegativeBalance(names, balances)));
        System.out.println(Arrays.toString(BanksPractice.findClientsWithNegativeBalance(names2, balances2)));

        BanksPractice.depositMoney(names, balances, "Ann", 2000);
        System.out.println(Arrays.toString(balances));

        int[] numbers = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 0};
        System.out.println(Arrays.toString(numbers));
        System.out.println(BanksPractice.uniqueCount(numbers));

        int[] numbers2 = {0, 0, -10, 5, 4, 44, 100, 44, 11, 10, 0};
        System.out.println(Arrays.toString(numbers2));
        System.out.println(BanksPractice.uniqueCount(numbers2));

        int[] numbers3 = {0, 0, -10, 5, 4, 44 * 2, 100, 4 + 4, 11, 10 / 2, 0};
        System.out.println(Arrays.toString(numbers3));
        System.out.println(BanksPractice.uniqueCount(numbers3));

        numbers = HomePractice.sortAscending(numbers);
        System.out.println(Arrays.toString(numbers));

        numbers2 = HomePractice.sortAscending(numbers2);
        System.out.println(Arrays.toString(numbers2));

        numbers3 = HomePractice.sortAscending(numbers3);
        System.out.println(Arrays.toString(numbers3));

        numbers = HomePractice.sortDescending(numbers);
        System.out.println(Arrays.toString(numbers));

        numbers2 = HomePractice.sortDescending(numbers2);
        System.out.println(Arrays.toString(numbers2));

        numbers3 = HomePractice.sortDescending(numbers3);
        System.out.println(Arrays.toString(numbers3));
    }
}
