package lesson10.home;

import java.util.Date;

public class ElectronicsOrder extends Order {

    private int guaranteeMonths;

    private String[] allowedFromCities = {"Киев", "Одесса", "Днепр", "Харьков"};
    private String[] allowedToCities = {"Киев", "Одесса", "Днепр", "Харьков"};

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        if (inArray(allowedFromCities, getShipFromCity()) && inArray(allowedToCities, getShipToCity())
            && getBasePrice() > 100
            && getCustomerOwned().getGender() == "Женский"
        ) {
            setDateConfirmed(new Date());
        }
    }

    @Override
    public void calculatePrice() {
        int shipmentPercent = (getShipToCity() == "Киев" || getShipToCity() == "Одесса") ? 10 : 15;
        double shipmentPrice = getBasePrice() * shipmentPercent / 100;
        double totalPrice = getBasePrice() + shipmentPrice;
        if (totalPrice > 1000) {
            totalPrice -= totalPrice * 5 / 100;
        }
        setTotalPrice(totalPrice);
    }

    public int getGuaranteeMonths() {
        return guaranteeMonths;
    }
}
