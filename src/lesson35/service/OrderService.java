package lesson35.service;

import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.repository.OrderRepository;
import lesson35.repository.RoomRepository;
import lesson35.repository.UserRepository;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class OrderService {
    OrderRepository orderRepository = OrderRepository.getInstance();
    RoomRepository roomRepository = RoomRepository.getInstance();
    UserRepository userRepository = UserRepository.getInstance();

    public Order bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        Room room = roomRepository.findById(roomId);
        User user = userRepository.findById(userId);
        long countDays = TimeUnit.DAYS.convert(dateTo.getTime() - dateFrom.getTime(), TimeUnit.MILLISECONDS);
        double moneyPaid = countDays * room.getPrice();

        return orderRepository.addObject(new Order(user, room, dateFrom, dateTo, moneyPaid));
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        for (Order order : orderRepository.findActiveOrdersByRoomAndUser(roomId, userId)) {
            orderRepository.removeObject(order);
        }
    }
}
