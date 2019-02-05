package lesson35.repository;

import lesson35.exceptions.FormatDataException;
import lesson35.model.Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RoomRepository extends BaseRepository<Room> {
    private HotelRepository hotelRepository = HotelRepository.getInstance();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private static RoomRepository instance = null;

    private RoomRepository() {
        super(7, "RoomDb.txt");
    }

    public static synchronized  RoomRepository getInstance() {
        if (instance == null) {
            instance = new RoomRepository();
        }

        return instance;
    }

    @Override
    protected Room mapObject(String[] rowData) throws Exception {
        Room room;
        try {
            room = new Room(
                    Long.parseLong(rowData[0]),                          // id
                    Integer.parseInt(rowData[1]) ,                       //numberOfGuests
                    Double.parseDouble(rowData[2]),                      //price
                    Boolean.parseBoolean(rowData[3]),                    //breakfastIncluded
                    Boolean.parseBoolean(rowData[4]),                    //petsAllowed
                    dateFormat.parse(rowData[5]),                        //dateAvailableFrom
                    hotelRepository.findById(Long.parseLong(rowData[6])) //hotel
            );
        } catch (NumberFormatException e) {
            throw new FormatDataException("Error: data format of object Hotel is wrong");
        } catch (ParseException e) {
            throw new FormatDataException("Error: date format of object Hotel is wrong");
        }
        return room;
    }

    @Override
    protected String toDbRow(Room room) {
        return room.getId()
                + ";" + room.getNumberOfGuests()
                + ";" + room.getPrice()
                + ";" + room.isBreakfastIncluded()
                + ";" + room.isPetsAllowed()
                + ";" + dateFormat.format(room.getDateAvailableFrom())
                + ";" + room.getHotel().getId();
    }
}
