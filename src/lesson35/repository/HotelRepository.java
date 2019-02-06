package lesson35.repository;

import lesson35.exceptions.FormatDataException;
import lesson35.model.Hotel;

import java.util.ArrayList;

public class HotelRepository extends BaseRepository<Hotel> {

    private static HotelRepository instance = null;

    private HotelRepository() {
        super(5, "HotelDb.txt");
    }

    public static synchronized  HotelRepository getInstance() {
        if (instance == null) {
            instance = new HotelRepository();
        }

        return instance;
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
    protected Hotel mapObject(String[] rowData) throws FormatDataException {
        Hotel hotel;
        try {
            hotel = new Hotel(
                    Long.parseLong(rowData[0]), // id
                    rowData[1],                 //name
                    rowData[2],                 //country
                    rowData[3],                 //city
                    rowData[4]                  //street
            );
        } catch (NumberFormatException e) {
            throw new FormatDataException("Error: data format of object Hotel is wrong");
        }
        return hotel;
    }

    @Override
    protected String toDbRow(Hotel hotel) {
        return hotel.getId()
                + ";" + hotel.getName()
                + ";" + hotel.getCountry()
                + ";" + hotel.getCity()
                + ";" + hotel.getStreet();
    }
}
