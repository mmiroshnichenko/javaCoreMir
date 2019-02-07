package lesson35.controller;

import lesson35.model.Order;
import lesson35.service.OrderService;

import java.util.Date;

public class OrderController {
    OrderService orderService = new OrderService();

    public Order bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        return orderService.bookRoom(roomId, userId, dateFrom, dateTo);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        orderService.cancelReservation(roomId, userId);
    }

    public void clearAll() throws Exception {
        orderService.clearAll();
    }
}
