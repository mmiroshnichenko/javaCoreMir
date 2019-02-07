package lesson35.demo;

public class DemoUser extends BaseDemo{
    public static void main(String[] args) {
        try {
            fillData();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
