package lesson35.service;

import lesson35.exceptions.BadRequestException;
import lesson35.model.Hotel;
import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.repository.OrderRepository;
import lesson35.repository.RoomRepository;
import lesson35.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private RoomRepository roomRepository = new RoomRepository();
    private UserRepository userRepository = new UserRepository();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public OrderService() throws Exception {
    }

    public Order bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        Room room = roomRepository.findById(roomId);
        User user = userRepository.findById(userId);
        validateBookRoomParams(room, roomId, user, userId, dateFrom);

        long countDays = TimeUnit.DAYS.convert(dateTo.getTime() - dateFrom.getTime(), TimeUnit.MILLISECONDS);
        double moneyPaid = countDays * room.getPrice();

        Order order = orderRepository.addObject(new Order(user, room, dateFrom, dateTo, moneyPaid));
        room.setDateAvailableFrom(dateTo);
        roomRepository.updateObject(room);

        return order;
    }

    public void cancelReservation(long orderId) throws Exception {
        Order order = orderRepository.findById(orderId);
        validateCancelReservationParams(order);

        Date dateFrom = order.getDateFrom();
        Room room = order.getRoom();
        orderRepository.removeObject(order);
        //я понимаю, что просто установить доступность комнаты в dateFrom от удаленного заказа - это не совсем верно
        //но тут возможно очень много вариантов, которые тоже будут отличаться от того как это сделано на реальных проектах
        //поэтому сделал этот простой вариант
        room.setDateAvailableFrom(dateFrom);
        roomRepository.updateObject(room);
    }

    public void clearAll() throws Exception {
        orderRepository.clearDataInDb();
    }

    public boolean existOrdersWithRoom(Room room) throws Exception {
        for (Order order : orderRepository.getAllObjects()) {
            if (order.getRoom().equals(room)) {
                return true;
            }
        }

        return false;
    }

    public boolean existOrdersWithHotel(Hotel hotel) throws Exception {
        for (Order order : orderRepository.getAllObjects()) {
            if (order.getRoom().getHotel().equals(hotel)) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Order> getAllOrders() throws Exception {
        return orderRepository.getAllObjects();
    }

    private void validateBookRoomParams(Room room, long roomId, User user, long userId, Date dateFrom) throws BadRequestException {
        if (room == null) {
            throw new BadRequestException("Error: room with id:" + roomId + " does not exist");
        }

        if (dateFrom.compareTo(room.getDateAvailableFrom()) < 0) {
            throw new BadRequestException("Error: " + room + " is available from " + dateFormat.format(room.getDateAvailableFrom()));
        }

        if (user == null) {
            throw new BadRequestException("Error: user with id:" + userId + " does not exist");
        }
    }

    private void validateCancelReservationParams(Order order) throws BadRequestException {
        if (order == null) {
            throw new BadRequestException("Error: order does not exist");
        }

        Date currentDate = new Date();
        if (currentDate.compareTo(order.getDateFrom()) >= 0) {
            throw new BadRequestException("Error: cancel time already expired for order " + order);
        }
    }
}
