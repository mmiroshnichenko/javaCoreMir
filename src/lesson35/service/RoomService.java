package lesson35.service;

import lesson35.comparator.RoomComparator;
import lesson35.exceptions.BadRequestException;
import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;

import java.util.ArrayList;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();
    private OrderService orderService = new OrderService();

    public RoomService() throws Exception {
    }

    public Room addRoom(Room room) throws Exception {
        validate(room);

        return roomRepository.addObject(room);
    }

    public void deleteRoomsByHotel(Hotel hotel) throws Exception {
        for (Room room : getRoomsByHotel(hotel)) {
            deleteRoom(room);
        }
    }

    public void deleteRoomById(long roomId) throws Exception {
        Room room = roomRepository.findById(roomId);
        if (room == null) {
            throw new BadRequestException("Error: Room with id:" + roomId + " does not exist in DB");
        }

        deleteRoom(room);
    }

    public void deleteRoom(Room room) throws Exception {
        if (orderService.existOrdersWithRoom(room)) {
            throw new BadRequestException("Error: cannot remove :" + room + ", already exists orders");
        }

        roomRepository.removeObject(room);
    }

    public void clearAll() throws Exception {
        roomRepository.clearDataInDb();
    }

    public ArrayList<Room> getAllRooms() throws Exception {
        return roomRepository.getAllObjects();
    }

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        ArrayList<Room> rooms = new ArrayList<>();
        for (Room room : roomRepository.getAllObjects()) {
            if (
                (filter.getNumberOfGuests() == 0 || room.getNumberOfGuests() == filter.getNumberOfGuests())
                && (filter.getPrice() == 0 || room.getPrice() == filter.getPrice())
                && (filter.getBreakfastIncluded() == null || room.isBreakfastIncluded() == filter.getBreakfastIncluded())
                && (filter.getPetsAllowed() == null || room.isPetsAllowed() == filter.getPetsAllowed())
                && (filter.getDateAvailableFrom() == null || room.getDateAvailableFrom().equals(filter.getDateAvailableFrom()))
                && (filter.getCountry() == null || room.getHotel().getCountry().equals(filter.getCountry()))
                && (filter.getCity() == null || room.getHotel().getCity().equals(filter.getCity()))
            ) {
                rooms.add(room);
            }
        }
        rooms.sort(new RoomComparator());
        return rooms;
    }

    private ArrayList<Room> getRoomsByHotel(Hotel hotel) throws Exception {
        ArrayList<Room> rooms = new ArrayList<>();
        for (Room room : roomRepository.getAllObjects()) {
            if (room.getHotel().equals(hotel)) {
                rooms.add(room);
            }
        }

        return rooms;
    }

    private void validate(Room room) throws BadRequestException {
        if(room.getNumberOfGuests() <= 0) {
            throw new BadRequestException("Error: incorrect room param: number of guests");
        }

        if(room.getPrice() <= 0) {
            throw new BadRequestException("Error: incorrect room param: price");
        }

        if(room.getDateAvailableFrom() == null) {
            throw new BadRequestException("Error: room param Date Available From is required");
        }

        if(room.getHotel() == null) {
            throw new BadRequestException("Error: room param Hotel is required");
        }
    }
}
