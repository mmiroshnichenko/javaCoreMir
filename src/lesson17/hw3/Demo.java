package lesson17.hw3;

public class Demo {
    public static void main(String[] args) {
        //String test = "test, ваыа.  на test   вав343 ывыв@ yt     .";
        //String test = "test, ваыа. .  на test   вав343 ывыв@ yt  test   .";
        String test = "test, ваыа. .  на test   вав343 ывыв@ yt вав343 test   . вав343";

        Solution solution = new Solution();
        System.out.println(solution.mostCountedWord(test));
    }
}
