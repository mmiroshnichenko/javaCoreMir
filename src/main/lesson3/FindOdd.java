package main.lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int a = 0;
        int sum = 0;
        int b;

        while (a <= 1000) {
            b = a % 2;
            if (b == 0) {
                System.out.println("Found");
                sum += a;
            }
            a++;
        }

        int res = sum * 5;

        if (res > 5000) {
            System.out.println("Bigger");
        } else {
            System.out.println("Smaller or equal");
        }
    }
}
