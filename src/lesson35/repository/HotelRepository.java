package lesson35.repository;

import lesson35.exceptions.FormatDataException;
import lesson35.model.Hotel;

public class HotelRepository extends BaseRepository<Hotel> {

    public HotelRepository() throws Exception {
        super(5, "..\\database\\HotelDb.txt");
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
                + "|" + hotel.getName()
                + "|" + hotel.getCountry()
                + "|" + hotel.getCity()
                + "|" + hotel.getStreet();
    }
}
