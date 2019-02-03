package main.lesson8.home1;

public class Adder extends Arithmetic{
    public long add(int a, int b) {
        long sum = 0;
        sum += a;
        sum += b;

        return sum;
    }
}
