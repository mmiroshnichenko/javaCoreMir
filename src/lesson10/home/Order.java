package lesson10.home;

import java.util.Date;

public abstract class Order {
    private String itemName;
    private Date dateCreated;
    private Date dateConfirmed;
    private Date dateShipped;
    private String shipFromCity;
    private String shipToCity;
    private int basePrice;
    private double totalPrice;
    private Customer customerOwned;

    public Order(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned) {
        this.itemName = itemName;
        this.dateCreated = dateCreated;
        this.shipFromCity = shipFromCity;
        this.shipToCity = shipToCity;
        this.basePrice = basePrice;
        this.customerOwned = customerOwned;
    }

    abstract public void validateOrder();
    abstract public void calculatePrice();
    abstract protected String[] getAllowedShipToCity();
    abstract protected String[] getAllowedShipFromCity();
    abstract protected int getMinPrice();

    public void confirmShipping() {
        if (dateShipped == null) {
            dateShipped = new Date();
        }
    }

    public String getItemName() {
        return itemName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateConfirmed() {
        return dateConfirmed;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public String getShipFromCity() {
        return shipFromCity;
    }

    public String getShipToCity() {
        return shipToCity;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomerOwned() {
        return customerOwned;
    }

    public void setDateConfirmed(Date dateConfirmed) {
        this.dateConfirmed = dateConfirmed;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    protected boolean validateShipmentCities() {

        return validateCity(getAllowedShipFromCity(), getShipFromCity())
                && validateCity(getAllowedShipToCity(), getShipToCity());
    }

    protected boolean validateMinPrice() {
        return getBasePrice() > getMinPrice();
    }

    private boolean validateCity(String[] shipmentCities, String city) {
        if (shipmentCities.length == 0) {
            return true;
        }

        return inArray(shipmentCities, city);
    }

    private boolean inArray(String[] array, String element) {
        for (String el : array) {
            if (el == element) {
                return true;
            }
        }

        return false;
    }

}
