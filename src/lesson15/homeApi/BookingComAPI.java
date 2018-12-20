package lesson15.homeApi;

import java.util.Arrays;

public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int length = 0;
        int minPrice = (price - 100) > 0 ? (price - 100) : 0;
        long maxPrice = price + 100;
        for (Room elRoom : rooms) {
            if (elRoom != null
                    && elRoom.getPersons() == persons
                    && elRoom.getCityName().equals(city)
                    && elRoom.getHotelName().equals(hotel)
                    && elRoom.getPrice() >= minPrice && elRoom.getPrice() <= maxPrice)
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
                    && elRoom.getPersons() == persons
                    && elRoom.getCityName().equals(city)
                    && elRoom.getHotelName().equals(hotel)
                    && elRoom.getPrice() >= minPrice && elRoom.getPrice() <= maxPrice)
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
        return "BookingComAPI{" +
                "rooms=" + Arrays.toString(rooms) +
                '}';
    }
}
