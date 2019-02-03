package main.lesson24.firstexample;

public class Main {
    private static void demo() {
        User user = new User(11);
        Solution solution = new Solution("test1");

        Demo<User> demo = new Demo<User>();
        demo.print(user);

        Demo<Solution> demo1 = new Demo<Solution>();
        demo1.print(solution);
    }

    public static void main(String[] args) {
        demo();
    }
}
