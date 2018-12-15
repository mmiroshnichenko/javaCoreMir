package lesson10.home;

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
        if (inArray(allowedFromCities, getShipFromCity())
                && getBasePrice() > 500
                && getCustomerOwned().getName() != "Тест"
        ) {
            setDateConfirmed(new Date());
        }
    }

    @Override
    public void calculatePrice() {
        int shipmentPercent = getBasePrice() < 5000 ? 5 : 2;
        double shipmentPrice = getBasePrice() * shipmentPercent / 100;
        double totalPrice = getBasePrice() + shipmentPrice;

        setTotalPrice(totalPrice);
    }

    public String getFurnitureCode() {
        return furnitureCode;
    }

}
