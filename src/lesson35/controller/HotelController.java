package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.AuthorizationService;
import lesson35.service.HotelService;

import java.util.ArrayList;

public class HotelController {
    private HotelService hotelService = new HotelService();

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        return hotelService.findHotelByCity(city);
    }

    public Hotel addHotel(Hotel hotel) throws Exception{
        AuthorizationService.checkAdminPermissions();

        return hotelService.addHotel(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        AuthorizationService.checkAdminPermissions();

        hotelService.deleteHotel(hotelId);
    }

    public void clearAll() throws Exception {
        hotelService.clearAll();
    }
}
