package lesson17.hw4V2;

public class Demo {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.validate(" https://gromcode.com "));
        System.out.println(solution.validate("http://gro%*mcode.com"));
        System.out.println(solution.validate("https://gromc.ode2.com"));
        System.out.println(solution.validate("https://www.gromcode2.com"));
        System.out.println(solution.validate("https://gromcod@e.com"));
        System.out.println(solution.validate("https://gromcode.com.ua"));
        System.out.println(solution.validate("ftp://gromcode.com"));
        System.out.println(solution.validate("https://gromcode.ua"));
        System.out.println(solution.validate("gdfg"));
        System.out.println(solution.validate("https://gromyrty654456code.com"));
        System.out.println(solution.validate("  "));
        System.out.println(solution.validate("https://GROMcode2.com"));
        System.out.println(solution.validate("https://GROMcode2.org"));
        System.out.println(solution.validate("HttP://GROMcode2.net"));
        System.out.println(solution.validate("https://WWW.test.net"));
        System.out.println(solution.validate("https://WWW.net"));
    }
}
