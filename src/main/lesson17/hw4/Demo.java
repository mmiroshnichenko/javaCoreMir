package main.lesson17.hw4;

public class Demo {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.validate("https://gromcode.com"));
        System.out.println(solution.validate("https://gromcode2.com"));
        System.out.println(solution.validate("https://www.gromcode2.com"));
        System.out.println(solution.validate("https://gromcod@e.com"));
        System.out.println(solution.validate("https://gromcode.com.ua"));
        System.out.println(solution.validate("ftp://gromcode.com"));
        System.out.println(solution.validate("https://gromcode.ua"));
    }
}
