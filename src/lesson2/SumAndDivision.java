package lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
        int a = 1;
        int s = 0;
        while (a <= 1000) {
            s += a;
            a++;
        }

        int c1 = s / 1234;
        int c2 = a % 1234;

        boolean res = c2 > c1;

        System.out.println(res);
    }
}
