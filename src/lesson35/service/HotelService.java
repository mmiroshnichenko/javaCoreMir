package lesson35.service;

import lesson35.comparator.HotelComparator;
import lesson35.exceptions.BadRequestException;
import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;

import java.util.ArrayList;

public class HotelService {
    private HotelRepository hotelRepository = new HotelRepository();
    private RoomService roomService = new RoomService();
    private OrderService orderService = new OrderService();

    public HotelService() throws Exception {
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
        validate(hotel);

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

    private void validate(Hotel hotel) throws BadRequestException {
        if (hotel.getName() == null || hotel.getName().isEmpty()) {
            throw new BadRequestException("Error: hotel Name is required");
        }

        if (hotel.getCountry() == null || hotel.getCountry().isEmpty()) {
            throw new BadRequestException("Error: hotel Country is required");
        }

        if (hotel.getCity() == null || hotel.getCity().isEmpty()) {
            throw new BadRequestException("Error: hotel City is required");
        }

        if (hotel.getStreet() == null || hotel.getStreet().isEmpty()) {
            throw new BadRequestException("Error: hotel Street is required");
        }
    }
}
