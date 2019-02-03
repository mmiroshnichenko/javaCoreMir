package main.lesson8.home1;

public class Demo {
    public static void main(String[] args) {
        Adder adder = new Adder();
        int[] array = {10, 15, 12, 2, 4, 45, 7};
        if (adder.check(array)) {
            System.out.println("Sum min and max is more than 100");
        } else {
            System.out.println("Sum min and max is less than 100");
        }
        int[] array2 = {0, 15, 120, 2, 4, -130, 7};
        if (adder.check(array2)) {
            System.out.println("Sum min and max is more than 100");
        } else {
            System.out.println("Sum min and max is less than 100");
        }

        int[] array3 = {0, 15, 1000, 2, 4, -130, 7};
        if (adder.check(array3)) {
            System.out.println("Sum min and max is more than 100");
        } else {
            System.out.println("Sum min and max is less than 100");
        }


        long sum = adder.add(2147483647, 2147483647);
        System.out.println(sum);
        sum = adder.add(-2147483647, 2147483647);
        System.out.println(sum);
        sum = adder.add(-2147483647, 0);
        System.out.println(sum);
    }
}
