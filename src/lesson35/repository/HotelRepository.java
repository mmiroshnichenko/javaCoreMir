package lesson35.repository;

import lesson35.model.Hotel;

import java.util.ArrayList;

public class HotelRepository extends BaseRepository<Hotel> {

    public HotelRepository() throws Exception {
        super("HotelDb.txt");
    }

    public ArrayList<Hotel> findHotelByName(String name) throws Exception{
        ArrayList<Hotel> hotels = new ArrayList<>();
        for (Hotel hotel : getAllObjects()) {
            if (name.equals(hotel.getName())) {
                hotels.add(hotel);
            }
        }

        return hotels;
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        ArrayList<Hotel> hotels = new ArrayList<>();
        for (Hotel hotel : getAllObjects()) {
            if (city.equals(hotel.getCity())) {
                hotels.add(hotel);
            }
        }

        return hotels;
    }

    @Override
    protected Hotel mapObject(String[] rowData) {
        return new Hotel(
                    Long.parseLong(rowData[0]), // id
                    rowData[1],                 //name
                    rowData[2],                 //country
                    rowData[3],                 //city
                    rowData[4]                  //street
            );
    }
}
