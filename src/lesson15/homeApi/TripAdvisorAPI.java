package lesson15.homeApi;

import java.util.Arrays;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int length = 0;
        int minPersons = (persons - 1) > 0 ? (persons - 1) : 0;
        long maxPersons = persons + 1;
        for (Room elRoom : rooms) {
            if (elRoom != null
                    && elRoom.getPrice() == price
                    && elRoom.getCityName().equals(city)
                    && elRoom.getHotelName().equals(hotel)
                    && elRoom.getPersons() >= minPersons && elRoom.getPersons() <= maxPersons)
            {
                length++;
            }
        }

        if (length == 0) {
            return new Room[0];
        }

        Room[] selectedRooms = new Room[length];
        int index = 0;
        for (Room elRoom : rooms) {
            if (elRoom != null
                    && elRoom.getPrice() == price
                    && elRoom.getCityName().equals(city)
                    && elRoom.getHotelName().equals(hotel)
                    && elRoom.getPersons() >= minPersons && elRoom.getPersons() <= maxPersons)
            {
                selectedRooms[index] = elRoom;
                index++;
            }
        }
        return selectedRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

    @Override
    public String toString() {
        return "TripAdvisorAPI{" +
                "rooms=" + Arrays.toString(rooms) +
                '}';
    }
}
