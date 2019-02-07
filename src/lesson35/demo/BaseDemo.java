package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.controller.OrderController;
import lesson35.controller.RoomController;
import lesson35.controller.UserController;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.model.UserType;
import lesson35.repository.HotelRepository;
import lesson35.repository.RoomRepository;
import lesson35.repository.UserRepository;

import java.text.SimpleDateFormat;


public class BaseDemo {

    protected static UserController userController = new UserController();
    protected static HotelController hotelController = new HotelController();
    protected static RoomController roomController = new RoomController();
    protected static OrderController orderController = new OrderController();

    protected static SimpleDateFormat dateFormat =  new SimpleDateFormat("dd-MM-yyyy");


    protected static void fillData() throws Exception {
        clearData();

        User admin = new User("Admin", "123456", "Ukraine", UserType.ADMIN);
        User user1 = new User("User1", "789465", "Ukraine", UserType.USER);
        User user2 = new User("User2", "454654", "Ukraine", UserType.USER);

        userController.registerUser(admin);
        userController.registerUser(user1);
        userController.registerUser(user2);

        userController.login("Admin", "123456");

        Hotel hotel1 = new Hotel("Hilton", "Ukraine", "Kiev", "Street 1");
        Hotel hotel2 = new Hotel("Hilton", "USA", "New-York", "Street 2");
        Hotel hotel3 = new Hotel("Hilton", "Great Britain", "London", "Street 3");
        Hotel hotel4 = new Hotel("Libid", "Ukraine", "Kiev", "Street 4");
        Hotel hotel5 = new Hotel("Edem", "Ukraine", "Lviv", "Street 5");
        Hotel hotel6 = new Hotel("Relax", "Ukraine", "Lviv", "Street 6");

        hotelController.addHotel(hotel1);
        hotelController.addHotel(hotel2);
        hotelController.addHotel(hotel3);
        hotelController.addHotel(hotel4);
        hotelController.addHotel(hotel5);
        hotelController.addHotel(hotel6);

        Room room1 = new Room(2, 100, true, false, dateFormat.parse("20-02-2019"), hotel1);
        Room room2 = new Room(2, 120, true, true, dateFormat.parse("31-03-2019"), hotel1);
        Room room3 = new Room(4, 200, true, true, dateFormat.parse("15-03-2019"), hotel1);
        Room room4 = new Room(3, 150, false, true, dateFormat.parse("01-03-2019"), hotel1);

        Room room5 = new Room(1, 50, true, false, dateFormat.parse("01-03-2019"), hotel2);
        Room room6 = new Room(2, 110, true, false, dateFormat.parse("06-03-2019"), hotel2);
        Room room7 = new Room(2, 120, true, true, dateFormat.parse("15-03-2019"), hotel2);
        Room room8 = new Room(4, 180, true, false, dateFormat.parse("20-03-2019"), hotel2);

        Room room9 = new Room(2, 80, true, false, dateFormat.parse("20-03-2019"), hotel3);
        Room room10 = new Room(2, 100, true, true, dateFormat.parse("10-03-2019"), hotel3);
        Room room11 = new Room(3, 110, false, false, dateFormat.parse("15-03-2019"), hotel3);
        Room room12 = new Room(3, 150, true, true, dateFormat.parse("21-03-2019"), hotel3);

        Room room13 = new Room(2, 40, true, false, dateFormat.parse("19-03-2019"), hotel4);
        Room room14 = new Room(2, 60, true, true, dateFormat.parse("16-03-2019"), hotel4);
        Room room15 = new Room(3, 80, true, false, dateFormat.parse("18-03-2019"), hotel4);
        Room room16 = new Room(3, 120, true, true, dateFormat.parse("25-03-2019"), hotel4);

        Room room17 = new Room(1, 40, false, false, dateFormat.parse("02-03-2019"), hotel5);
        Room room18 = new Room(2, 60, true, false, dateFormat.parse("07-03-2019"), hotel5);
        Room room19 = new Room(2, 70, true, true, dateFormat.parse("12-03-2019"), hotel5);
        Room room20 = new Room(3, 100, true, false, dateFormat.parse("14-03-2019"), hotel5);

        Room room21 = new Room(2, 80, true, false, dateFormat.parse("11-03-2019"), hotel6);
        Room room22 = new Room(2, 90, true, true, dateFormat.parse("10-03-2019"), hotel6);
        Room room23 = new Room(3, 110, true, true, dateFormat.parse("14-03-2019"), hotel6);
        Room room24 = new Room(4, 150, true, false, dateFormat.parse("12-03-2019"), hotel6);

        roomController.addRoom(room1);
        roomController.addRoom(room2);
        roomController.addRoom(room3);
        roomController.addRoom(room4);
        roomController.addRoom(room5);
        roomController.addRoom(room6);
        roomController.addRoom(room7);
        roomController.addRoom(room8);
        roomController.addRoom(room9);
        roomController.addRoom(room10);
        roomController.addRoom(room11);
        roomController.addRoom(room12);
        roomController.addRoom(room13);
        roomController.addRoom(room14);
        roomController.addRoom(room15);
        roomController.addRoom(room16);
        roomController.addRoom(room17);
        roomController.addRoom(room18);
        roomController.addRoom(room19);
        roomController.addRoom(room20);
        roomController.addRoom(room21);
        roomController.addRoom(room22);
        roomController.addRoom(room23);
        roomController.addRoom(room24);

        //bookRoom(long roomId, long userId, Date dateFrom, Date dateTo)
        orderController.bookRoom(3, 2, dateFormat.parse("16-03-2019"), dateFormat.parse("20-03-2019"));

    }

    protected static void clearData() throws Exception {
        userController.clearAll();
        hotelController.clearAll();
        roomController.clearAll();
    }
}
