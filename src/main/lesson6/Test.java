package main.lesson6;

public class Test {
    public static void main(String[] args) {
        Order ord = new Order();
        ord.confirmOrder();

        System.out.println(ord.dateConfirmed);
        System.out.println(ord.isConfirmed);
    }
}
