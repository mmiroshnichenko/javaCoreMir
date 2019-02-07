package lesson35.service;

import lesson35.comparator.RoomComparator;
import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;

import java.util.ArrayList;
import java.util.Date;

public class RoomService {
    private RoomRepository roomRepository = RoomRepository.getInstance();

    public Room addRoom(Room room) throws Exception {
        return roomRepository.addObject(room);
    }

    public void deleteRoom(long roomId) throws Exception {
        roomRepository.removeById(roomId);
    }

    public void clearAll() throws Exception {
        roomRepository.clearDataInDb();
    }

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        ArrayList<Room> rooms = findRoomsByNumberOfGuests(roomRepository.getAllObjects(), filter.getNumberOfGuests());
        rooms = findRoomsByPrice(rooms, filter.getPrice());
        rooms = findRoomsByBreakfastIncluded(rooms, filter.isBreakfastIncluded());
        rooms = findRoomsByPetsAllowed(rooms, filter.isPetsAllowed());
        rooms = findRoomsByDateAvailableFrom(rooms, filter.getDateAvailableFrom());
        rooms = findRoomsByCountry(rooms, filter.getCountry());
        rooms = findRoomsByCity(rooms, filter.getCity());

        rooms.sort(new RoomComparator());
        return rooms;
    }

    private ArrayList<Room> findRoomsByNumberOfGuests(ArrayList<Room> rooms, int numberOfGuests) {
        if (rooms.isEmpty() || numberOfGuests == 0) {
            return rooms;
        }

        ArrayList<Room> res = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getNumberOfGuests() == numberOfGuests) {
                res.add(room);
            }
        }

        return res;
    }

    private ArrayList<Room> findRoomsByPrice(ArrayList<Room> rooms, double price) {
        if (rooms.isEmpty() || price == 0) {
            return rooms;
        }

        ArrayList<Room> res = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getPrice() == price) {
                res.add(room);
            }
        }

        return res;
    }

    private ArrayList<Room> findRoomsByBreakfastIncluded(ArrayList<Room> rooms, Boolean breakfastIncluded) {
        if (rooms.isEmpty() || breakfastIncluded == null) {
            return rooms;
        }

        ArrayList<Room> res = new ArrayList<>();
        for (Room room : rooms) {
            if ((room.isBreakfastIncluded() && breakfastIncluded) || ((!room.isBreakfastIncluded() && !breakfastIncluded))) {
                res.add(room);
            }
        }

        return res;
    }

    private ArrayList<Room> findRoomsByPetsAllowed(ArrayList<Room> rooms, Boolean petsAllowed) {
        if (rooms.isEmpty() || petsAllowed == null) {
            return rooms;
        }

        ArrayList<Room> res = new ArrayList<>();
        for (Room room : rooms) {
            if ((room.isPetsAllowed() && petsAllowed) || ((!room.isPetsAllowed() && !petsAllowed))) {
                res.add(room);
            }
        }

        return res;
    }

    private ArrayList<Room> findRoomsByDateAvailableFrom(ArrayList<Room> rooms, Date dateAvailableFrom) {
        if (rooms.isEmpty() || dateAvailableFrom == null) {
            return rooms;
        }

        ArrayList<Room> res = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getDateAvailableFrom().equals(dateAvailableFrom)) {
                res.add(room);
            }
        }

        return res;
    }

    private ArrayList<Room> findRoomsByCountry(ArrayList<Room> rooms, String country) {
        if (rooms.isEmpty() || country == null) {
            return rooms;
        }

        ArrayList<Room> res = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getHotel().getCountry().equals(country)) {
                res.add(room);
            }
        }

        return res;
    }

    private ArrayList<Room> findRoomsByCity(ArrayList<Room> rooms, String city) {
        if (rooms.isEmpty() || city == null) {
            return rooms;
        }

        ArrayList<Room> res = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getHotel().getCity().equals(city)) {
                res.add(room);
            }
        }

        return res;
    }
}
