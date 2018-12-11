package lesson10.home;

import java.util.Date;

public class ElectronicsOrder extends Order {

    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    void validateOrder() {
        if (validateShipmentCities()
            && validateMinPrice()
            && getCustomerOwned().getGender() == "Женский"
        ) {
            setDateConfirmed(new Date());
        }
    }

    @Override
    protected void calculatePrice() {
        int shipmentPercent = (getShipToCity() == "Киев" || getShipToCity() == "Одесса") ? 10 : 15;
        double shipmentPrice = getBasePrice() * shipmentPercent / 100;
        double totalPrice = getBasePrice();
        if (totalPrice > 1000) {
            totalPrice -= totalPrice * 5 / 100;
        }
        totalPrice += shipmentPrice;
        setTotalPrice(totalPrice);
    }

    public int getGuaranteeMonths() {
        return guaranteeMonths;
    }

    @Override
    protected String[] getAllowedShipToCity() {
        String[] allowedCities = {"Киев", "Одесса", "Днепр", "Харьков"};

        return allowedCities;
    };

    @Override
    protected String[] getAllowedShipFromCity() {
        String[] allowedCities = {"Киев", "Одесса", "Днепр", "Харьков"};

        return allowedCities;
    };

    @Override
    protected int getMinPrice() {
        return 100;
    }
}
