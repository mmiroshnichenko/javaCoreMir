package lesson35.demo;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;

public class DemoRoom extends BaseDemo {
    public static void main(String[] args) {
        try {
            fillData();

            System.out.println("all rooms");
            for (Room room : roomController.getAllRooms()) {
                System.out.println(room);
            }

            System.out.println("add already exist hotel");
            try {
                Hotel hotel1 = new Hotel("Hilton", "Ukraine", "Kiev", "Street 1");
                Room room1 = new Room(2, 100, true, false, dateFormat.parse("20-02-2019"), hotel1);

                roomController.addRoom(room1);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("delete room which does not exist");
            try {
                roomController.deleteRoom(78);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("delete room. Orders already exists");
            try {
                roomController.deleteRoom(3);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("delete room by User");
            userController.logout();
            userController.login("User1", "789465");
            try {
                roomController.deleteRoom(1);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            userController.logout();
            userController.login("Admin", "123456");
            roomController.deleteRoom(1);

            for (Room room : roomController.getAllRooms()) {
                System.out.println(room);
            }

            System.out.println("Find rooms by city");
            Filter filter1 = new Filter();
            filter1.setCity("Lviv");

            for (Room room : roomController.findRooms(filter1)) {
                System.out.println(room);
            }

            System.out.println("Find rooms by country");
            Filter filter2 = new Filter();
            filter2.setCountry("Ukraine");
            for (Room room : roomController.findRooms(filter2)) {
                System.out.println(room);
            }

            System.out.println("Find rooms by country, city, number of guests, pets allowed, price");
            Filter filter3 = new Filter();
            filter3.setCountry("Ukraine");
            filter3.setCity("Kiev");
            filter3.setNumberOfGuests(2);
            filter3.setPetsAllowed(true);
            filter3.setPrice(120);
            for (Room room : roomController.findRooms(filter3)) {
                System.out.println(room);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
