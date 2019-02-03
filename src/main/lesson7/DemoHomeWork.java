package main.lesson7;

import main.lesson6.Order;
import java.util.Date;

public class DemoHomeWork {

    public Order createOrder() {
        //int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type
        Order orderObject = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");

        return orderObject;
    }

    public Order createOrderAndCallMethods() {
        Order orderObject = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        orderObject.confirmOrder();
        orderObject.checkPrice();
        orderObject.isValidType();
        return orderObject;
    }
}
