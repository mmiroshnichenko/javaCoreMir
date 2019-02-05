package lesson35.service;

import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;

public class HotelService {
    private HotelRepository hotelRepository;

    public HotelService() throws Exception {
        this.hotelRepository = new HotelRepository();
    }

    public Hotel getById(long id) {
        return hotelRepository.findById(id);
    }

    public Hotel add(Hotel hotel) throws Exception {
        return hotelRepository.addObject(hotel);
    }

    public void remove(long hotelId) throws Exception {
        hotelRepository.removeById(hotelId);
    }
}
