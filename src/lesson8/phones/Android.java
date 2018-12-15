package lesson8.phones;

public class Android extends Phone {
    String androidVersion;
    int screenSize;
    String secretDeviceCode;

    public Android(int price, double weight, String countryProduced, String androidVersion, int screenSize, String secretDeviceCode) {
        super(price, weight, countryProduced);
        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretDeviceCode = secretDeviceCode;
    }

    public void installNewAndroidVersion() {
        System.out.println("installNewAndroidVersion invoked...");
    }

    @Override
    public String toString() {
        return "Android{" +
                "androidVersion='" + androidVersion + '\'' +
                ", screenSize=" + screenSize +
                ", secretDeviceCode='" + secretDeviceCode + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", countryProduced='" + countryProduced + '\'' +
                '}';
    }
}
