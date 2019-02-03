package main.lesson15.homeApi;

import java.util.Arrays;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int length = 0;

        for (Room elRoom : rooms) {
            if (elRoom != null
                    && elRoom.getPrice() == price && elRoom.getPersons() == persons
                    && elRoom.getCityName().equals(city) && elRoom.getHotelName().equals(hotel))
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
                    && elRoom.getPrice() == price && elRoom.getPersons() == persons
                    && elRoom.getCityName().equals(city) && elRoom.getHotelName().equals(hotel))
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
        return "GoogleAPI{" +
                "rooms=" + Arrays.toString(rooms) +
                '}';
    }
}
