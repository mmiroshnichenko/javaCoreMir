package lesson8.home1;

public class Demo {
    public static void main(String[] args) {
        Adder adder = new Adder();
        int[] array = {10, 15, 12, 2, 4, 45, 7};
        adder.check(array);
        long sum = adder.add(2147483647, 2147483647);
        System.out.println(sum);
    }
}
