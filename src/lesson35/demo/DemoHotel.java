package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.model.Hotel;

public class DemoHotel {
    public static void main(String[] args) {
        try {
            HotelController hotelController = new HotelController();
            Hotel hotel1 = new Hotel("Hotel 1", "Ukraine", "Lviv", "Street 1");
            Hotel hotel2 = new Hotel("Hotel 2", "Ukraine", "Lviv", "Street 2");

            hotelController.addHotel(hotel1);
            hotelController.addHotel(hotel2);

          // hotelController.deleteHotel(2);



        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
