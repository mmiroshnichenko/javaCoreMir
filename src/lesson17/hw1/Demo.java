package lesson17.hw1;

public class Demo {
    public static void main(String[] args) {
        String test = "ваыа.  на   вав343 ывыв@ yt     .";

        Solution solution = new Solution();

        System.out.println(solution.countWords(test));
        System.out.println(solution.countWords(""));
        System.out.println(solution.countWords(null));
    }
}
