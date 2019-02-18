package lesson35.repository;

import lesson35.model.Order;

import java.text.SimpleDateFormat;

public class OrderRepository extends BaseRepository<Order> {
    private UserRepository userRepository = new UserRepository();
    private RoomRepository roomRepository = new RoomRepository();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public OrderRepository() throws Exception {
        super("OrderDb.txt");
    }

    @Override
    protected Order mapObject(String[] rowData) throws Exception {
        return new Order(
                    Long.parseLong(rowData[0]),                             // id
                    userRepository.findById(Long.parseLong(rowData[1])),    //user
                    roomRepository.findById(Long.parseLong(rowData[2])),    //room
                    dateFormat.parse(rowData[3]),                           //dateFrom
                    dateFormat.parse(rowData[4]),                           //dateTo
                    Double.parseDouble(rowData[5])                          //moneyPaid
            );
    }
}
