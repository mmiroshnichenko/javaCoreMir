package lesson11.home;

import java.util.Arrays;

public class TripAdvisorAPI implements API{
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int length = 0;
        Room[] selectedRooms = new Room[length];
        int minPersons = (persons - 1) > 0 ? (persons - 1) : 0;
        long maxPersons = persons + 1;
        for (Room elRoom : rooms) {
            if (elRoom != null
                    && elRoom.getPrice() == price
                    && elRoom.getCityName() == city
                    && elRoom.getHotelName() == hotel) {
                if (elRoom.getPersons() >= minPersons && elRoom.getPersons() <= maxPersons) {

                    selectedRooms = Arrays.copyOf(selectedRooms, length + 1);
                    selectedRooms[length] = elRoom;
                    length++;
                }
            }
        }
        return selectedRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
