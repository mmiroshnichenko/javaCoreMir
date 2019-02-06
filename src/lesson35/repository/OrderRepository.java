package lesson35.repository;

import lesson35.exceptions.FormatDataException;
import lesson35.model.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderRepository extends BaseRepository<Order> {
    private UserRepository userRepository = UserRepository.getInstance();
    private RoomRepository roomRepository = RoomRepository.getInstance();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private static OrderRepository instance = null;

    private OrderRepository() {
        super(6, "OrderDb.txt");
    }

    public static synchronized  OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepository();
        }

        return instance;
    }

    public ArrayList<Order> findActiveOrdersByRoomAndUser(long roomId, long userId) throws Exception {
        Date currentDate = new Date();
        ArrayList<Order> orders = new ArrayList<>();
        for (Order order : getAllObjects()) {
            if (order.getUser().getId() == userId
                && order.getRoom().getId() == roomId
                && order.getDateFrom().compareTo(currentDate) > 0 ) {
                orders.add(order);
            }
        }

        return orders;
    }

    @Override
    protected Order mapObject(String[] rowData) throws Exception {
        Order order;
        try {
            order = new Order(
                    Long.parseLong(rowData[0]),                             // id
                    userRepository.findById(Long.parseLong(rowData[1])),    //user
                    roomRepository.findById(Long.parseLong(rowData[2])),    //room
                    dateFormat.parse(rowData[3]),                           //dateFrom
                    dateFormat.parse(rowData[4]),                           //dateTo
                    Double.parseDouble(rowData[5])                          //moneyPaid
            );
        } catch (NumberFormatException e) {
            throw new FormatDataException("Error: data format of object Hotel is wrong");
        }
        return order;
    }

    @Override
    protected String toDbRow(Order order) {
        return order.getId()
                + ";" + order.getUser().getId()
                + ";" + order.getRoom().getId()
                + ";" + dateFormat.format(order.getDateFrom())
                + ";" + dateFormat.format(order.getDateTo())
                + ";" + order.getMoneyPaid();
    }
}
