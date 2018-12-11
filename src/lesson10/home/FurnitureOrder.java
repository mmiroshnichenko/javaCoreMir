package lesson10.home;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    void validateOrder() {
        if (validateShipmentCities()
                && validateMinPrice()
                && getCustomerOwned().getName() != "Тест"
        ) {
            setDateConfirmed(new Date());
        }
    }

    @Override
    void calculatePrice() {
        int shipmentPercent = getBasePrice() < 5000 ? 5 : 2;
        double shipmentPrice = getBasePrice() * shipmentPercent / 100;
        double totalPrice = getBasePrice() + shipmentPrice;

        setTotalPrice(totalPrice);
    }

    public String getFurnitureCode() {
        return furnitureCode;
    }

    @Override
    protected String[] getAllowedShipToCity() {
        String[] allowedCities = new String[0];

        return allowedCities;
    };

    @Override
    protected String[] getAllowedShipFromCity() {
        String[] allowedCities = {"Киев", "Львов"};

        return allowedCities;
    };

    @Override
    protected int getMinPrice() {
        return 500;
    }
}
