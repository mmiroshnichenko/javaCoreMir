package lesson8.phones;

public class IPhone7 extends IPhone {
    boolean isGold;

    public IPhone7(int price, double weight, String countryProduced, boolean fingerPrint) {
        super(price, weight, countryProduced, fingerPrint);
    }

    @Override
    public String toString() {
        return "IPhone7{" +
                "isGold=" + isGold +
                ", fingerPrint=" + fingerPrint +
                ", price=" + price +
                ", weight=" + weight +
                ", countryProduced='" + countryProduced + '\'' +
                '}';
    }
}
