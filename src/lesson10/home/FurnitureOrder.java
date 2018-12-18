package lesson10.home;

import java.util.Arrays;
import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    private String[] allowedFromCities = {"Киев", "Львов"};

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        if (Arrays.asList(allowedFromCities).contains(getShipFromCity())
                && getBasePrice() > 500
                && getCustomerOwned().getName() != "Тест"
        ) {
            setDateConfirmed(new Date());
        } else {
            printErrorIncorrectOrderData();
        }
    }

    @Override
    public void calculatePrice() {
        if (getDateConfirmed() == null) {
            printErrorIncorrectOrderData();
            return;
        }

        int shipmentPercent = getBasePrice() < 5000 ? 5 : 2;
        double shipmentPrice = getBasePrice() * shipmentPercent / 100;
        double totalPrice = getBasePrice() + shipmentPrice;

        setTotalPrice(totalPrice);
    }

    public String getFurnitureCode() {
        return furnitureCode;
    }

    @Override
    public String toString() {
        return super.toString() + " FurnitureOrder{" +
                "furnitureCode='" + furnitureCode + '\'' +
                ", allowedFromCities=" + Arrays.toString(allowedFromCities) +
                '}';
    }

    protected void printErrorIncorrectOrderData() {
        System.out.println("Incorrect furniture order data");
    }
}
