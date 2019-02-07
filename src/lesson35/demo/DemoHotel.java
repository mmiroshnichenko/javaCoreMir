package lesson35.demo;

import lesson35.model.Hotel;

public class DemoHotel extends BaseDemo {
    public static void main(String[] args) {
        try {
            fillData();

            for (Hotel hotel : hotelController.getAllHotels()) {
                System.out.println(hotel);
            }

            System.out.println("add already exist hotel");
            try {
                hotelController.addHotel(new Hotel("Relax", "Ukraine", "Lviv", "Street 6"));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("delete hotel which does not exist");
            try {
                hotelController.deleteHotel(78);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("delete hotel. Orders already exists");
            try {
                hotelController.deleteHotel(1);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("delete hotel by User");
            userController.logout();
            userController.login("User1", "789465");
            try {
                hotelController.deleteHotel(4);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            userController.logout();
            userController.login("Admin", "123456");
            hotelController.deleteHotel(4);

            for (Hotel hotel : hotelController.getAllHotels()) {
                System.out.println(hotel);
            }

            System.out.println("find by name");
            for (Hotel hotel : hotelController.findHotelByName("Hilton")) {
                System.out.println(hotel);
            }

            System.out.println("find by name");
            for (Hotel hotel : hotelController.findHotelByCity("Lviv")) {
                System.out.println(hotel);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
