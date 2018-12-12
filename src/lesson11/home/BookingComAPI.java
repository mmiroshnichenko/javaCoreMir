package lesson11.home;

import java.util.Arrays;

public class BookingComAPI implements API{
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int length = 0;
        Room[] selectedRooms = new Room[length];
        int minPrice = (price - 100) > 0 ? (price - 100) : 0;
        long maxPrice = price + 100;
        for (Room elRoom : rooms) {
            if (elRoom != null
                    && elRoom.getPersons() == persons
                    && elRoom.getCityName() == city
                    && elRoom.getHotelName() == hotel) {
                if (elRoom.getPrice() >= minPrice && elRoom.getPrice() <= maxPrice) {

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
