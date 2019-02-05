package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

public class HotelController {
    private HotelService hotelService;

    public HotelController() throws Exception{
        hotelService = new HotelService();
    }

    public Hotel addHotel(Hotel hotel) throws Exception{
        return hotelService.add(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        hotelService.remove(hotelId);
    }
}
