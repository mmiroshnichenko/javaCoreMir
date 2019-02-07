package lesson35.service;

import lesson35.comparator.HotelComparator;
import lesson35.exceptions.BadRequestException;
import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;

import java.util.ArrayList;

public class HotelService {
    private HotelRepository hotelRepository = HotelRepository.getInstance();
    private RoomService roomService = new RoomService();
    private OrderService orderService = new OrderService();

    public Hotel addHotel(Hotel hotel) throws Exception {
        return hotelRepository.addObject(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        Hotel hotel = hotelRepository.findById(hotelId);
        if (hotel == null) {
            throw new BadRequestException("Error: Hotel with id:" + hotelId + " does not exist in DB");
        }

        if (orderService.existOrdersWithHotel(hotel)) {
            throw new BadRequestException("Error: cannot remove Hotel with id:" + hotelId + " for this room already exists orders");
        }

        roomService.deleteRoomsByHotel(hotel);

        hotelRepository.removeObject(hotel);
    }

    public ArrayList<Hotel> findHotelByName(String name) throws Exception{
        ArrayList<Hotel> hotels = hotelRepository.findHotelByName(name);

        hotels.sort(new HotelComparator());
        return hotels;
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        ArrayList<Hotel> hotels = hotelRepository.findHotelByCity(city);

        hotels.sort(new HotelComparator());
        return hotels;
    }

    public void clearAll() throws Exception {
        hotelRepository.clearDataInDb();
    }

    public ArrayList<Hotel> getAllHotels() throws Exception {
        return hotelRepository.getAllObjects();
    }
}
