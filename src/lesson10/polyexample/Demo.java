package lesson10.polyexample;

public class Demo {
    public static void main(String[] args) {

        Human human = new Human("Test");
        run(human);

        System.out.println();

        User user = new User("Jack");
        run(user);

        System.out.println();

        Child child = new Child("Mary");
        run(child);
    }



    private static void run(Human human) {
        human.run();
    }
}
