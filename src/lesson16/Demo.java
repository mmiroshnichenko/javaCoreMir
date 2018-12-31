package lesson16;

import lesson16.home.Solution;

public class Demo {
    public static void main(String[] args) {
        String test = "енен еооп Tere, dsfs 76 u6ti test fgj&fhj kjkj";

        Solution solution = new Solution();

        System.out.println(solution.countWords(test));
        System.out.println(solution.maxWord(test));
        System.out.println(solution.minWord(test));
        System.out.println(solution.mostCountedWord(test));
        System.out.println(solution.validate("https://gromcode.com"));
        System.out.println(solution.validate("https://gromcode2.com"));
        System.out.println(solution.validate("https://www.gromcode2.com"));
        System.out.println(solution.validate("https://gromcod@e.com"));
        System.out.println(solution.validate("https://gromcode.com.ua"));
        System.out.println(solution.validate("ftp://gromcode.com"));
        System.out.println(solution.validate("https://gromcode.ua"));
    }
}
