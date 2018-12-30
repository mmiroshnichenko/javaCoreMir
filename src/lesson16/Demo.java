package lesson16;

import lesson16.home.Solution;

public class Demo {
    public static void main(String[] args) {
        String test = "Tere, dsfs 76 u6ti fgj&fhj kjkj";

        Solution solution = new Solution();

        System.out.println(solution.countWords(test));
        System.out.println(solution.maxWord(test));
        System.out.println(solution.minWord(test));
    }
}
