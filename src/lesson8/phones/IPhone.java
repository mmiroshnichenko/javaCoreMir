package lesson8.phones;

public class IPhone extends Phone{

    boolean fingerPrint;

    public IPhone(int price, double weight, String countryProduced, boolean fingerPrint) {
        super(price, weight, countryProduced);
        System.out.println("IPhone constructor was invoked...");
        this.fingerPrint = fingerPrint;
    }

    public void deleteIPhoneFromDb() {
        System.out.println("deletePhoneFromDb invoked...");
    }

    @Override
    public String toString() {
        return "IPhone{" +
                "fingerPrint=" + fingerPrint +
                ", price=" + price +
                ", weight=" + weight +
                ", countryProduced='" + countryProduced + '\'' +
                '}';
    }
}
