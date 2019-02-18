package lesson35.repository;

import lesson35.model.Room;

import java.text.SimpleDateFormat;

public class RoomRepository extends BaseRepository<Room> {
    private HotelRepository hotelRepository = new HotelRepository();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public RoomRepository() throws Exception {
        super("RoomDb.txt");
    }

    @Override
    protected Room mapObject(String[] rowData) throws Exception {
        return new Room(
                    Long.parseLong(rowData[0]),                          // id
                    Integer.parseInt(rowData[1]) ,                       //numberOfGuests
                    Double.parseDouble(rowData[2]),                      //price
                    Boolean.parseBoolean(rowData[3]),                    //breakfastIncluded
                    Boolean.parseBoolean(rowData[4]),                    //petsAllowed
                    dateFormat.parse(rowData[5]),                        //dateAvailableFrom
                    hotelRepository.findById(Long.parseLong(rowData[6])) //hotel
            );
    }
}
