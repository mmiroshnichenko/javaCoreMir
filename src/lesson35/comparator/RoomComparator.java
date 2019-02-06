package lesson35.comparator;

import lesson35.model.Room;

import java.util.Comparator;

public class RoomComparator implements Comparator<Room> {
    @Override
    public int compare(Room room1, Room room2) {
        if (room1.getNumberOfGuests() != room2.getNumberOfGuests()) {
            return room1.getNumberOfGuests() > room2.getNumberOfGuests() ? 1 : -1;
        }
        if (room1.getPrice() != room2.getPrice()) {
            return room1.getPrice() > room2.getPrice() ? 1 : -1;
        }
        if (!room1.getDateAvailableFrom().equals(room2.getDateAvailableFrom())) {
            return room1.getDateAvailableFrom().compareTo(room2.getDateAvailableFrom());
        }

        return room1.getHotel().getName().compareTo(room2.getHotel().getName());
    }
}
