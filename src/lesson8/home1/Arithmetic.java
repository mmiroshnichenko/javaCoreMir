package lesson8.home1;

public class Arithmetic {
    public boolean checks(int[] array) {
        int min = array[0];
        int max = array[array.length - 1];
        for (int el : array) {
            if (el < min) {
                min = el;
            }
            if (el > max) {
                max = el;
            }
        }

        long sum = min + max;

        return sum > 100;
    }
}
