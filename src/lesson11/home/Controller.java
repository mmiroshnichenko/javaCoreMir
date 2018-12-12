package lesson11.home;

import java.util.Arrays;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        Room[] selectedRooms;
        int length = 0;
        Room[] allRooms = new Room[length];
        for (API api : apis) {
            selectedRooms = api.findRooms(price, persons, city, hotel);
            allRooms = Arrays.copyOf(allRooms, length + selectedRooms.length);
            for (Room selectedRoom : selectedRooms) {
                allRooms[length] = selectedRoom;
                length++;
            }
        }

        return allRooms;
    }

    public Room[] check(API api1, API api2) {
        int length = 0;
        Room[] matchRooms = new Room[length];

        Room[] api1Rooms = api1.getAll();
        Room[] api2Rooms = api2.getAll();

        for (Room room : api1Rooms) {
            if (room != null && match(room, api2Rooms)) {
                matchRooms = Arrays.copyOf(matchRooms, length + 1);
                matchRooms[length] = room;
                length++;
            }
        }

        return matchRooms;
    }

    private boolean match(Room room, Room[] rooms) {
        for (Room elRoom : rooms) {
            if (elRoom != null) {
                if (elRoom.getPrice() == room.getPrice()
                        && elRoom.getPersons() == room.getPersons()
                        && elRoom.getHotelName() == room.getHotelName()
                        && elRoom.getCityName() == room.getCityName()) {
                    return true;
                }
            }
        }

        return false;
    }
}
