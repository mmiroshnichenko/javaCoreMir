package lesson35.service;

import lesson35.comparator.HotelComparator;
import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;

import java.util.ArrayList;

public class HotelService {
    private HotelRepository hotelRepository = HotelRepository.getInstance();

    public Hotel getById(long id) throws Exception {
        return hotelRepository.findById(id);
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
        return hotelRepository.addObject(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        hotelRepository.removeById(hotelId);
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
}
