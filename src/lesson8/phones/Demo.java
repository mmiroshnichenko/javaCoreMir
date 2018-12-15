package lesson8.phones;

public class Demo {
    public static void main(String[] args) {
        IPhone iPhone = new IPhone(110, 10.0, "China", true);
        System.out.println(iPhone);
        iPhone.deleteIPhoneFromDb();
        iPhone.orderPhone();

        IPhone7 iPhone7 = new IPhone7(150, 200.2, "China", true);
        System.out.println(iPhone7);
        iPhone7.deleteIPhoneFromDb();
        iPhone7.orderPhone();

        Android android = new Android(100, 250.4, "China", "8.3", 5, "test");
        System.out.println(android);
        android.installNewAndroidVersion();
        android.orderPhone();
    }
}
