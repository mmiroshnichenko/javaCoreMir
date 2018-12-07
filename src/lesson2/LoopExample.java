package lesson2;

public class LoopExample {
    public static void main(String[] args) {
        int a = 10;
        while (a <= 9) {
            System.out.println(a);
            a++;
        }

        do {
            System.out.println(a);
            a++;
        } while (a <= 11);
    }
}
