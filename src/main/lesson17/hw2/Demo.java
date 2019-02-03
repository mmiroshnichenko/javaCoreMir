package main.lesson17.hw2;

public class Demo {
    public static void main(String[] args) {
        String test = "ваыа.  на   вав343 ывыв@ yt     .";

        Solution solution = new Solution();

        System.out.println(solution.maxWord(test));
        System.out.println(solution.minWord(test));
    }
}
