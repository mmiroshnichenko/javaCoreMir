package lesson35.controller;

import lesson35.model.Order;
import lesson35.service.AuthorizationService;
import lesson35.service.OrderService;

import java.util.ArrayList;
import java.util.Date;

public class OrderController {
    private OrderService orderService = new OrderService();

    public OrderController() throws Exception {
    }

    public Order bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        AuthorizationService.checkUserAuthorization();

        return orderService.bookRoom(roomId, userId, dateFrom, dateTo);
    }

    public void cancelReservation(long orderId) throws Exception {
        AuthorizationService.checkUserAuthorization();

        orderService.cancelReservation(orderId);
    }

    public void clearAll() throws Exception {
        orderService.clearAll();
    }

    public ArrayList<Order> getAllOrders() throws Exception {
        return orderService.getAllOrders();
    }
}
