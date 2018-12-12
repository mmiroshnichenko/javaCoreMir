package lesson11.home;

import java.util.Arrays;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int length = 0;
        Room[] selectedRooms = new Room[length];
        for (Room elRoom : rooms) {
            if (elRoom != null
                    && elRoom.getPrice() == price
                    && elRoom.getPersons() == persons
                    && elRoom.getCityName() == city
                    && elRoom.getHotelName() == hotel) {
                selectedRooms = Arrays.copyOf(selectedRooms, length + 1);
                selectedRooms[length] = elRoom;
                length++;
            }
        }
        return selectedRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
