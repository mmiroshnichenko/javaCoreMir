package lesson4;

public class Demo {
    public static void main(String[] args) {

        System.out.println(MethodExample.increaser(5, 20));
        System.out.println(MethodExample.increaser(5, -20));
        System.out.println(MethodExample.increaser(-5, 20));

        System.out.println(MethodExample.min(5, 25));
        System.out.println(MethodExample.min(-45, 25));
        System.out.println(MethodExample.min(10, 10));

        System.out.println(MethodExample.concat("First ", "Second ", "Third"));
        System.out.println(MethodExample.concat("First ", null, "Third"));
        System.out.println(MethodExample.concat("", null, "Third"));

        short a = 2;
        short b = 10;
        System.out.println(MethodExample.findDivCount(a, b, 5));
        System.out.println(MethodExample.findDivCount(a, b, 0));
        System.out.println(MethodExample.findDivCount(a, b, -5));

        System.out.println(MethodExample.compareSums(2,5, 3, 10));
        System.out.println(MethodExample.compareSums(-5,2, 3, 10));
        System.out.println(MethodExample.compareSums(5,2, 0, 0));

        System.out.println(PracticeExample.min(2, 5, 10));
        System.out.println(PracticeExample.min(-10, 5, 2));
        System.out.println(PracticeExample.min(10, 0, 10));

        System.out.println(PracticeExample.average(2));
        System.out.println(PracticeExample.average(10));
        System.out.println(PracticeExample.average(2, -5));
        System.out.println(PracticeExample.average(6, 5));

        System.out.println(PracticeExample.count(10, 100, 5));
        System.out.println(PracticeExample.count(10, 0, 5));
        System.out.println(PracticeExample.count(10, 200, 0));


    }
}
