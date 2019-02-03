package main.lesson2;

public class SumOfNumbers {
    public static void main(String[] args) {
        int a = 0;
        long s = 0;
        while (a <= 10000000) {
            s += a;
            a++;
        }

        System.out.println(s);
    }
}
